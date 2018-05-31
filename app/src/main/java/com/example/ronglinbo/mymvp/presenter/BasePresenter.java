package com.example.ronglinbo.mymvp.presenter;

import com.example.ronglinbo.mymvp.utils.MyException;
import com.example.ronglinbo.mymvp.utils.ReturnCode;

import java.lang.ref.WeakReference;

/**
 * Created by ronglinbo on 2018/4/15.
 */

public class BasePresenter<T> {

    //view 层的引用
//    IGirlView girlView;
    protected WeakReference<T> mViewRef;

    //进行绑定
    public void attachView(T view){
        mViewRef=new WeakReference<T>(view);
    }


    public T getViewRef() throws MyException {
        if(mViewRef.get()==null){
            throw new MyException(String.valueOf(ReturnCode.mvpViewError),ReturnCode.getMessage(ReturnCode.mvpViewError));
        }
        return mViewRef.get();
    }


    //进行解绑
    public void detachView(){
        mViewRef.clear();
        myClear();
    }


    //清除缓存
    public void myClear(){

    };


}
