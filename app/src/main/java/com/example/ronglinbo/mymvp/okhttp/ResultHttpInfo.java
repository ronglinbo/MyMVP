package com.example.ronglinbo.mymvp.okhttp;

import com.okhttplib.HttpInfo;

/**
 * Created by Administrator on 2018/5/9.
 */

public class ResultHttpInfo<T>{

    private HttpInfo httpInfo;

    private T resultData;

    public HttpInfo getHttpInfo() {
        return httpInfo;
    }

    public void setHttpInfo(HttpInfo httpInfo) {
        this.httpInfo = httpInfo;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }
}
