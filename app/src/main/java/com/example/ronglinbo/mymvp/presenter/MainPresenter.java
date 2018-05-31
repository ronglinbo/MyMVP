package com.example.ronglinbo.mymvp.presenter;

import android.util.Log;

import com.example.ronglinbo.mymvp.en.DateInfo;
import com.example.ronglinbo.mymvp.model.GirlModelImpl;
import com.example.ronglinbo.mymvp.model.IGirlModel;
import com.example.ronglinbo.mymvp.okhttp.ResultHttpInfo;
import com.example.ronglinbo.mymvp.view.IGirlView;
import com.google.gson.Gson;
import com.okhttplib.HttpInfo;


/**
 * Created by ronglinbo on 2018/4/15.
 * //表示层
 */

public class MainPresenter<T extends  IGirlView> extends BasePresenter<T>{


    String TAG="GirlPresenterTAG";

    //model 层的引用
    IGirlModel girlModel =new GirlModelImpl();

    //3.构造方法
    public MainPresenter(){
//        mViewRef=new WeakReference<T>(view);
    };

    //4.执行操作(Ui逻辑)
    public void fetch(HttpInfo httpInfo){
        if(mViewRef.get()!=null){
            mViewRef.get().showLoading();
            if(girlModel!=null){
                girlModel.loadGirl(httpInfo,new IGirlModel.GirlOnLoadListener() {
                    @Override
                    public void onComplete(HttpInfo info) {
                        if(mViewRef.get()!=null){
                            Log.i("测试","onComplete:"+info);
                            Gson gson=new Gson();
                            ResultHttpInfo<DateInfo> resultHttpInfo= new ResultHttpInfo<DateInfo>();
                            resultHttpInfo.setHttpInfo(info);
                            DateInfo info1= gson.fromJson(info.getRetDetail(), DateInfo.class);
                            resultHttpInfo.setResultData(info1);
                            mViewRef.get().showGirls(resultHttpInfo);
                        }
                    }
                });
            }
        }





    }


    @Override
    public void myClear() {
        super.myClear();
        girlModel.myClear();
        girlModel=null;
    }
}
