package com.zhuodewen.myproject.base;

/**
 * Ajax处理类
 */
public class JSONResult {

    private boolean success = true;

    private String msg;

    //成功时返回的数据
    private Object result;

    //设置返回结果和返回信息
    public JSONResult mark(String msg) {
        this.msg = msg;
        this.success = false;
        return this;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }


}
