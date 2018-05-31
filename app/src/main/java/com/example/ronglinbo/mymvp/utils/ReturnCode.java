package com.example.ronglinbo.mymvp.utils;

/**
 * Created by Administrator on 2018/5/24.
 */

public class ReturnCode {

    public static final int mvpViewError = 1024001;
    public static final int mvpModelError = 1024002;



    public static String getMessage(int code){
        String message="";
        switch (code){
            case mvpViewError:
                   message = "MVP的View层为null";
                break;
            case mvpModelError:
                   message = "MVP的Model层为null";
                break;
            default:
                   message = "未知";
                break;
        }
        return message;
    }

}
