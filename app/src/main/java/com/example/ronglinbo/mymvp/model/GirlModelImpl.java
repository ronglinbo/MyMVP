package com.example.ronglinbo.mymvp.model;

import android.util.Log;

import com.example.ronglinbo.mymvp.okhttp.ResultHttpInfo;
import com.example.ronglinbo.mymvp.utils.MyException;
import com.okhttplib.HttpInfo;
import com.okhttplib.OkHttpUtil;
import com.okhttplib.callback.Callback;

import java.io.IOException;

/**
 * Created by ronglinbo on 2018/4/15.
 */

public class GirlModelImpl implements IGirlModel {

    private String requestTag;

    @Override
    public void loadGirl(HttpInfo info, final GirlOnLoadListener girlOnLoadListener) {

        requestTag=info.getUrl();


        OkHttpUtil.getDefault(info.getUrl()).doAsync(info, new Callback() {
            @Override
            public void onSuccess(HttpInfo info) throws IOException {
                Log.i("测试","onSuccess");
                try {
                    girlOnLoadListener.onComplete(info);
                } catch (MyException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(HttpInfo info) throws IOException {
                Log.i("测试","onFailure");
                try {
                    girlOnLoadListener.onComplete(info);
                } catch (MyException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void myClear() {
        OkHttpUtil.getDefault().cancelRequest(requestTag);
    }
}
