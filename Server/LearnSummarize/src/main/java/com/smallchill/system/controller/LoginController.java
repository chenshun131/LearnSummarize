/**
 * Copyright (c) 2015-2016, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smallchill.system.controller;

import com.smallchill.common.base.BaseController;
import com.smallchill.common.vo.LoginLog;
import com.smallchill.core.annotation.Before;
import com.smallchill.core.constant.Const;
import com.smallchill.core.plugins.dao.Blade;
import com.smallchill.core.plugins.dao.Db;
import com.smallchill.core.shiro.ShiroKit;
import com.smallchill.core.toolbox.Func;
import com.smallchill.core.toolbox.Paras;
import com.smallchill.core.toolbox.ajax.AjaxResult;
import com.smallchill.core.toolbox.captcha.Captcha;
import com.smallchill.core.toolbox.kit.LogKit;
import com.smallchill.core.toolbox.log.BladeLogManager;
import com.smallchill.system.meta.intercept.LoginValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

@Controller
public class LoginController extends BaseController implements Const
{
    private static Logger log = LogManager.getLogger(LoginController.class);

    @RequestMapping("/")
    public String index()
    {
        return indexRealPath;
    }

    /**
     * GET 登录
     */
    @GetMapping("/login")
    public String login()
    {
        if (ShiroKit.isAuthenticated())
        {
            return redirect + "/";
        }
        return loginRealPath;
    }

    /**
     * POST 登录
     */
    @Before(LoginValidator.class)
    @ResponseBody
    @PostMapping("/login")
    public AjaxResult login(HttpServletRequest request, HttpServletResponse response)
    {
        String account = getParameter("account");
        String password = getParameter("password");
        String imgCode = getParameter("imgCode");
        if (!Captcha.validate(request, response, imgCode))
        {
            return error("验证码错误");
        }
        // 得到 Subject 及创建用户名/密码身份验证 Token（即用户身份/凭证）
        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account, password.toCharArray());
        token.setRememberMe(true);
        try
        {
            // 登录，即身份验证
            currentUser.login(token);

            Session session = ShiroKit.getSession();
            LogKit.println("\nsessionID	: {} ", session.getId());
            LogKit.println("sessionHost	: {}", session.getHost());
            LogKit.println("sessionTimeOut	: {}", session.getTimeout());
        }
        catch (UnknownAccountException e)
        {
            // 错误的帐号
            log.error("账号不存在!", e);
            return error("账号不存在");
        }
        catch (DisabledAccountException e)
        {
            // 禁用的帐号
            log.error("账号未启用!", e);
            return error("账号未启用");
        }
        catch (ExcessiveAttemptsException e)
        {
            log.error("登录失败次数过多!", e);
            return error("登录失败次数过多");
        }
        catch (IncorrectCredentialsException e)
        {
            // 错误的凭证
            log.error("密码错误!", e);
            return error("密码错误");
        }
        catch (ExpiredCredentialsException e)
        {
            // 过期的凭证
            log.error("登陆失效,请重新登陆!", e);
            return error("登陆失效,请重新登陆!");
        }
        catch (RuntimeException e)
        {
            log.error("未知错误,请联系管理员!", e);
            return error("未知错误,请联系管理员");
        }
        doLog(ShiroKit.getSession(), "登录");
        return success("登录成功");
    }

    @RequestMapping("/logout")
    public String logout()
    {
        doLog(ShiroKit.getSession(), "登出");
        Subject currentUser = ShiroKit.getSubject();
        // 退出
        currentUser.logout();
        return redirect + "/login";
    }

    @RequestMapping(value = "/unauth")
    public String unauth()
    {
        if (ShiroKit.notAuthenticated())
        {
            return redirect + "/login";
        }
        return noPermissionPath;
    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletResponse response)
    {
        Captcha.init(response).render();
    }

    public void doLog(Session session, String type)
    {
        if (!BladeLogManager.isDoLog())
        {
            return;
        }
        try
        {
            LoginLog log = new LoginLog();
            String msg = Func.format("[sessionID]: {} [sessionHost]: {} [sessionHost]: {}", session.getId(), session.getHost(), session.getTimeout());
            log.setLogname(type);
            log.setMethod(msg);
            log.setCreatetime(new Date());
            log.setSucceed("1");
            log.setUserid(Func.toStr(ShiroKit.getUser().getId()));
            Blade.create(LoginLog.class).save(log);
        }
        catch (Exception ex)
        {
            LogKit.logNothing(ex);
        }
    }

    @RequestMapping(value = "/getVersionInfo")
    public void getVersionInfo(PrintWriter out)
    {
        String platform = getParameter("platform");
        Map<String, Object> userRole = Db.selectOneByCache(SYS_APPINFO, "appInfoExt_" + platform, "SELECT * FROM AppInfo WHERE type= #{type}", Paras.create().set("type", platform));
        if (Func.isEmpty(userRole))
        {
            out.write(error("获取 App 信息失败").toString());
        }
        else
        {
            out.write(json(userRole).toString());
        }
    }
}
