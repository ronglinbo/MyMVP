package com.example.ronglinbo.mymvp.fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ronglinbo.mymvp.R;
import com.example.ronglinbo.mymvp.okhttp.ResultHttpInfo;
import com.example.ronglinbo.mymvp.presenter.BasePresenter;
import com.example.ronglinbo.mymvp.presenter.CommonPresenter;
import com.example.ronglinbo.mymvp.view.IGirlView;

/**
 * Created by ronglinbo on 2018/5/24.
 */

public class HomeFragment extends BaseFragment<IGirlView,CommonPresenter<IGirlView>> implements IGirlView{





    @Override
    protected CommonPresenter<IGirlView> createPresenter() {
        return new CommonPresenter<IGirlView>();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {

    }





    @Override
    public void showLoading() {
        Toast.makeText(getActivity(),"HomeFragment 开始请求",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showGirls(ResultHttpInfo info) {

    }

    @Override
    public void showError(ResultHttpInfo info) {

    }
}
