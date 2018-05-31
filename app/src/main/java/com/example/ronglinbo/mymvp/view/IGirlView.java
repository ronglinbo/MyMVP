package com.example.ronglinbo.mymvp.view;

import com.example.ronglinbo.mymvp.okhttp.ResultHttpInfo;

/**
 * Created by ronglinbo on 2018/4/15.
 * 定义出所有的UI逻辑
 */

public interface IGirlView  {

    void showLoading();
    //显示listView中的数据（使用回调的方式返回数据）
    void showGirls(ResultHttpInfo info);
    //报错
    void showError(ResultHttpInfo info);

}
