package com.chenshun.learnsummarize.model;

import com.chenshun.learnsummarize.util.JSONKits;

/**
 * User: chenshun <p />
 * Time: 16/10/23 00:15 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class BaseModel
{
    private int code = 0; // 返回状态码 (默认0:成功,1:失败)
    private String message; // 返回的中文消息,主要是错误描述信息
    private Object data; // 成功时携带的数据

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public boolean isSuccess()
    {
        return getCode() == 0;
    }

    @Override
    public String toString()
    {
        return JSONKits.toJson(this);
    }
}
