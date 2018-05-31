package com.example.ronglinbo.mymvp.presenter;

import android.util.Log;

import com.example.ronglinbo.mymvp.en.BaseInfo;
import com.example.ronglinbo.mymvp.en.CommonPresenterInfo;
import com.example.ronglinbo.mymvp.en.DateInfo;
import com.example.ronglinbo.mymvp.model.GirlModelImpl;
import com.example.ronglinbo.mymvp.model.IGirlModel;
import com.example.ronglinbo.mymvp.okhttp.ResultHttpInfo;
import com.example.ronglinbo.mymvp.utils.MyException;
import com.example.ronglinbo.mymvp.utils.ReturnCode;
import com.example.ronglinbo.mymvp.view.IGirlView;
import com.google.gson.Gson;
import com.okhttplib.HttpInfo;

/**
 * Created by Administrator on 2018/5/24.
 */

public class CommonPresenter<T extends IGirlView> extends BasePresenter<T> {

    private String TAG="CommonPresenterTAG";

    //model 层的引用
    IGirlModel girlModel =new GirlModelImpl();


    //4.执行操作(Ui逻辑)
    public void fetch(HttpInfo httpInfo, final CommonPresenterInfo commonPresenterInfo)throws MyException{

       if(commonPresenterInfo.isShowLoading()){
           getViewRef().showLoading();
       }

       if(girlModel==null){
           throw  new MyException(String.valueOf(ReturnCode.mvpModelError),ReturnCode.getMessage(ReturnCode.mvpModelError));
       }

       girlModel.loadGirl(httpInfo,new IGirlModel.GirlOnLoadListener() {
            @Override
            public void onComplete(HttpInfo info) throws MyException {
                    Log.i("测试","onComplete:"+info);
                    if(info.getRetCode()!=HttpInfo.SUCCESS){
                        ResultHttpInfo resultHttpInfo= new ResultHttpInfo();
                        resultHttpInfo.setHttpInfo(info);
                        getViewRef().showError(resultHttpInfo);
                    } else {
                        if(commonPresenterInfo.isGson()){
                            Gson gson=new Gson();
                            ResultHttpInfo resultHttpInfo= new ResultHttpInfo();
                            resultHttpInfo.setHttpInfo(info);
                            Object info1= gson.fromJson(info.getRetDetail(),commonPresenterInfo.getGsonClass());
                            switch (commonPresenterInfo.getSaveToWhere()){
                                case 0:
                                    break;
                                case 1:
                                    ((BaseInfo)info1).saveToDb();
                                    break;
                                case 2:
                                    break;
                            }
                            resultHttpInfo.setResultData(info1);
                            getViewRef().showGirls(resultHttpInfo);
                        }else{
                            ResultHttpInfo resultHttpInfo= new ResultHttpInfo();
                            resultHttpInfo.setHttpInfo(info);
                            getViewRef().showGirls(resultHttpInfo);
                        }
                    }
            }
       });

    }


    @Override
    public void myClear() {
        super.myClear();
        girlModel.myClear();
        girlModel=null;
    }
}
