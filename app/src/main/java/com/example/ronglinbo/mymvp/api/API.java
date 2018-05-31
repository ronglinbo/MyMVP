package com.example.ronglinbo.mymvp.api;

import com.okhttplib.HttpInfo;
import com.okhttplib.annotation.RequestType;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/5/9.
 */

public class API {

    private static final String url = "http://api.k780.com:88/?app=life.time&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";

    /*
    *
    * 获取时间信息
    *
    * */
    public static HttpInfo getDateHttpInfo(){
        return HttpInfo.Builder().setUrl(url)
                .setRequestType(RequestType.GET)
                .addHead("head","test")
                .addParam("param","test")
//                .setNeedResponse(true)
//                .setDelayExec(1, TimeUnit.SECONDS)
                .build();
    }

}
