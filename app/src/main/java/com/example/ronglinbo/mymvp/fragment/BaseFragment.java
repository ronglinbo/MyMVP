package com.example.ronglinbo.mymvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ronglinbo.mymvp.presenter.BasePresenter;

/**
 * Created by Administrator on 2018/5/24.
 */

public abstract class BaseFragment<V,T extends BasePresenter<V>> extends Fragment {

    //表示层的引用
    public T girlPresenter;


    protected View mRootView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        girlPresenter=createPresenter();
        girlPresenter.attachView((V)this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        girlPresenter.detachView();
    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(null == mRootView){
            mRootView=inflater.inflate(getLayoutId(),container,false);
        }

        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        afterCreate(savedInstanceState);
    }


    protected abstract T createPresenter();

    protected abstract int getLayoutId();

    protected abstract void afterCreate(Bundle  savedInstanceState);

}
