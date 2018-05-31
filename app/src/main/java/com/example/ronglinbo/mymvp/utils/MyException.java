package com.example.ronglinbo.mymvp.utils;

/**
 * Created by Administrator on 2018/5/24.
 */

public class MyException extends Exception {
    private String retCd;  //异常对应的返回码
    private String msgDes;  //异常对应的描述信息

    public MyException(){
        super();
    }

    public MyException(String message){
        super(message);
        msgDes=message;
    }


    public MyException(String retCd,String msgDes){
        super();
        this.retCd=retCd;
        this.msgDes=msgDes;
    }


    public String getRetCd() {
        return retCd;
    }

    public void setRetCd(String retCd) {
        this.retCd = retCd;
    }

    public String getMsgDes() {
        return msgDes;
    }

    public void setMsgDes(String msgDes) {
        this.msgDes = msgDes;
    }
}
