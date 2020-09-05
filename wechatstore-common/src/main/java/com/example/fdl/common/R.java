package com.example.fdl.common;

import java.io.Serializable;

public class R<T> implements Serializable {
    private static final long serialVersionUID = -4577255781088498763L;
    private static final int OK = 0;
    private static final int FAIL = 1;
    private static final int UNAUTHORIZED = 2;

    private String success;
    private T obj; //服务端数据
    private int status = OK; //状态码
    private String msg = ""; //描述信息

    //APIS
    public static R isOk(){
        return new R();
    }
    public static R isFail(){
        return new R().status(FAIL);
    }
    public static R isFail(Throwable e){
        return isFail().msg(e);
    }
    public R msg(Throwable e){
        this.setMsg(e.toString());
        return this;
    }
    public R obj(T obj){
        this.setObj(obj);
        return this;
    }
    public R status(int status){
        this.setStatus(status);
        return this;
    }
    public R success(String success){
        this.setSuccess(success);
        return this;
    }


    //Constructors
    public R() {

    }

    //Getter&Setters

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
