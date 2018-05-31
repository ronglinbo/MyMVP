package com.example.ronglinbo.mymvp;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ronglinbo.mymvp.adapter.CommonFragmentPagerAdapter;
import com.example.ronglinbo.mymvp.databinding.ActivityFragmentBinding;
import com.example.ronglinbo.mymvp.fragment.BaseFragment;
import com.example.ronglinbo.mymvp.fragment.FragmentFactory;
import com.example.ronglinbo.mymvp.fragment.HomeFragment;
import com.example.ronglinbo.mymvp.fragment.NewFindFragment;
import com.example.ronglinbo.mymvp.fragment.NewMyFragment;
import com.example.ronglinbo.mymvp.listener.OKListener;
import com.example.ronglinbo.mymvp.okhttp.ResultHttpInfo;
import com.example.ronglinbo.mymvp.presenter.CommonPresenter;
import com.example.ronglinbo.mymvp.view.IGirlView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronglinbo on 2018/5/24.
 */

public class HomeActivity extends BaseFragmentActivity<IGirlView,CommonPresenter<IGirlView>> implements IGirlView,OKListener,ViewPager.OnPageChangeListener{

    String TAG="HomeActivityTAG";

    public Context mContext;

    ActivityFragmentBinding binding;


    private List<BaseFragment> mFragmentList = new ArrayList<>(4);

    @Override
    protected CommonPresenter<IGirlView> createPresenter() {
        return new CommonPresenter<IGirlView>();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_fragment);
        binding.setListener(this);
        mContext=this;

        initView();

    }

    /**
     * 初始化组件
     */
    private void initView(){

        binding.vpContent.setOffscreenPageLimit(3);

        mFragmentList.add(FragmentFactory.getmInstance().getHomeFragment());
        mFragmentList.add(FragmentFactory.getmInstance().getNewServiceFragment());
        mFragmentList.add(FragmentFactory.getmInstance().getNewFindFragment());
        mFragmentList.add(FragmentFactory.getmInstance().getNewMyFragment());

        binding.vpContent.setAdapter(new CommonFragmentPagerAdapter(getSupportFragmentManager(),mFragmentList));

        binding.vpContent.addOnPageChangeListener(this);

        binding.vpContent.setCurrentItem(0,false);
        modifyButtonState(binding.bottom.firstpager);
    }


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
    public void onClickOk(View view) {
        int vId=view.getId();
        switch (vId){
            case R.id.message_paper:
            case R.id.firstpager:
                   Log.i(TAG,"点击了消息");
                   modifyButtonState(binding.bottom.firstpager);
                   binding.vpContent.setCurrentItem(0,false);
                break;
            case R.id.service_paper:
            case R.id.service:
                   Log.i(TAG,"点击了应用");
                   modifyButtonState(binding.bottom.service);
                   binding.vpContent.setCurrentItem(1,false);
                break;
            case R.id.friend_paper:
            case R.id.friend:
                   Log.i(TAG,"点击了活动");
                   modifyButtonState(binding.bottom.friend);
                   binding.vpContent.setCurrentItem(2,false);
                break;
            case R.id.setting_pager:
            case R.id.setting:
                  Log.i(TAG,"点击了我");
                  modifyButtonState(binding.bottom.setting);
                  binding.vpContent.setCurrentItem(3,false);
                break;
        }

    }

    private void modifyButtonState(Button button) {
        binding.bottom.firstpager.setSelected(false);
        binding.bottom.firstpager.setTextColor(getResources().getColor(R.color.font_darkgray));

        binding.bottom.service.setSelected(false);
        binding.bottom.service.setTextColor(getResources().getColor(R.color.font_darkgray));

        binding.bottom.friend.setSelected(false);
        binding.bottom.friend.setTextColor(getResources().getColor(R.color.font_darkgray));

        binding.bottom.setting.setSelected(false);
        binding.bottom.setting.setTextColor(getResources().getColor(R.color.font_darkgray));

        button.setSelected(true);
        button.setTextColor(getResources().getColor(R.color.font_darkblue));

    }


    /**
     * ViewPager 滑动事件
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
       switch (position){
           case 0:
                modifyButtonState(binding.bottom.firstpager);
                binding.vpContent.setCurrentItem(0,false);
               break;
           case 1:
                modifyButtonState(binding.bottom.service);
                binding.vpContent.setCurrentItem(1,false);
               break;
           case 2:
                modifyButtonState(binding.bottom.friend);
                binding.vpContent.setCurrentItem(2,false);
               break;
           case 3:
                modifyButtonState(binding.bottom.setting);
                binding.vpContent.setCurrentItem(3,false);
               break;
       }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
