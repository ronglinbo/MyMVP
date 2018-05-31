package com.example.ronglinbo.mymvp.model;

import com.example.ronglinbo.mymvp.okhttp.ResultHttpInfo;
import com.example.ronglinbo.mymvp.utils.MyException;
import com.okhttplib.HttpInfo;

/**
 * Created by ronglinbo on 2018/4/15.
 * 用来加载数据
 */

public interface IGirlModel {
    void loadGirl(HttpInfo info,GirlOnLoadListener girlOnLoadListener);


    void myClear();

    // 设计一个一个内部回调接口
    interface GirlOnLoadListener{
        void onComplete(HttpInfo info) throws MyException;
    }



}
