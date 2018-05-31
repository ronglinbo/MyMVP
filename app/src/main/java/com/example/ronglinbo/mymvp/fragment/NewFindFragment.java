package com.example.ronglinbo.mymvp.fragment;

import android.os.Bundle;

import com.example.ronglinbo.mymvp.R;
import com.example.ronglinbo.mymvp.okhttp.ResultHttpInfo;
import com.example.ronglinbo.mymvp.presenter.BasePresenter;
import com.example.ronglinbo.mymvp.presenter.CommonPresenter;
import com.example.ronglinbo.mymvp.view.IGirlView;

/**
 * Created by Administrator on 2018/5/24.
 */

public class NewFindFragment extends BaseFragment<IGirlView,CommonPresenter<IGirlView>> implements IGirlView {

    @Override
    public void showLoading() {

    }

    @Override
    public void showGirls(ResultHttpInfo info) {

    }

    @Override
    public void showError(ResultHttpInfo info) {

    }

    @Override
    protected CommonPresenter<IGirlView> createPresenter() {
        return new CommonPresenter<IGirlView>();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_new_find;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {

    }
}
