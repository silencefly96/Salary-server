package com.fundark.salary.bean;

public class JsonResult<T> {

    public static final int RESULT_OK = 0;
    public static final int RESULT_FAIL = -1;
    public static final int RESULT_ERROR = -2;

    private int status = RESULT_OK;

    private String errMsg = "";

    private T result;

    public JsonResult status(int status) {
        this.status = status;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
