package com.chenshun.learnsummarize.constant;

/**
 * User: chenshun <p />
 * Time: 16/10/13 16:06  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Constants
{
    /** whether in debug model */
    public static final boolean IS_DEBUG = true;
    public static final String BASE_IP = "192.168.0.11";
    public static final String BASE_PATH = "http://" + BASE_IP + ":8080/LearnSummarize";

    /******************************** 【Network Access Path】 *******************************************/
    public static final String CAPTCHA = BASE_PATH + "/captcha";// 验证码
    public static final String LOGIN = BASE_PATH + "/login";// 登录

    /******************************** 【Network Status Code】 *******************************************/
    public static final String STATUS_CODE_OK = "0";// access server success
    public static final String STATUS_CODE_ACCESS_TIME_NOT = "-999";// long time not access server and need relogin

    /******************************** 【Network Access Param】 *******************************************/
    public static final String ACCOUNT = "account";
    public static final String PASSWORD = "password";
    public static final String IMGCODE = "imgCode";
    public static final String PLATFORM = "platform";
}
