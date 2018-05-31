package com.example.ronglinbo.mymvp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ronglinbo.mymvp.api.API;
import com.example.ronglinbo.mymvp.databinding.ActivityMainBinding;
import com.example.ronglinbo.mymvp.en.CommonPresenterInfo;
import com.example.ronglinbo.mymvp.en.DateInfo;
import com.example.ronglinbo.mymvp.listener.OKListener;
import com.example.ronglinbo.mymvp.okhttp.ResultHttpInfo;
import com.example.ronglinbo.mymvp.presenter.CommonPresenter;
import com.example.ronglinbo.mymvp.presenter.MainPresenter;
import com.example.ronglinbo.mymvp.utils.MyException;
import com.example.ronglinbo.mymvp.view.IGirlView;

public class MainActivity extends BaseActivity<IGirlView,CommonPresenter<IGirlView>> implements IGirlView,OKListener{

    String TAG="MainActivityTAG";
    
    ActivityMainBinding binding;

    int clickNumber=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setListener(this);

    }

    @Override
    protected CommonPresenter<IGirlView> createPresenter() {
        return new CommonPresenter<IGirlView>();
    }


    @Override
    public void showLoading() {
        Toast.makeText(this,"开始请求",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGirls(ResultHttpInfo info ) {
        DateInfo dateInfo=(DateInfo)info.getResultData();
        Log.i(TAG,"DateInfo:"+dateInfo.result.toString());
        dateInfo.saveToDb();
        binding.setDateInfo(dateInfo);
        
    }

    @Override
    public void showError(ResultHttpInfo info) {

    }

    @Override
    public void onClickOk(View view) {
        int vId=view.getId();
        switch (vId){
            case R.id.btGetDate:
                clickNumber++;
                try {
                    girlPresenter.fetch(API.getDateHttpInfo(),new CommonPresenterInfo().setGson(true).setGsonClass(DateInfo.class));
                } catch (MyException e) {
                    e.printStackTrace();
                }
                binding.tvTest.setText("点击的次数："+clickNumber);
                break;
            case R.id.btGetData:
//                  DateInfo dateInfo= DateInfo.builder();
//                  Log.i(TAG,"获取本地数据库时间："+dateInfo.toString());
                  Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                  startActivity(intent);
                break;
        }


    }
}




