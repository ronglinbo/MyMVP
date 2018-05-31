package com.example.ronglinbo.mymvp.fragment;

/**
 * Created by ronglinbo on 2018/5/24.
 * 主界面4个Fragment 工厂
 */

public class FragmentFactory {
    static FragmentFactory mInstance;

    private FragmentFactory(){

    }


    public static FragmentFactory getmInstance(){
        if(mInstance==null){
            synchronized (FragmentFactory.class){
                if(mInstance==null){
                    mInstance=new FragmentFactory();
                }
            }
        }
        return mInstance;
    }


    private HomeFragment homeFragment;
    private NewServiceFragment newServiceFragment;
    private NewFindFragment newFindFragment;
    private NewMyFragment newMyFragment;


    public HomeFragment getHomeFragment(){
        if(homeFragment==null){
           synchronized (FragmentFactory.class){
               if(homeFragment==null){
                   homeFragment = new HomeFragment();
               }
           }
        }
        return homeFragment;
    }

    public NewServiceFragment getNewServiceFragment(){
        if(newServiceFragment==null){
            synchronized (FragmentFactory.class){
                if(newServiceFragment==null){
                    newServiceFragment = new NewServiceFragment();
                }
            }
        }
        return newServiceFragment;
    }



    public NewFindFragment getNewFindFragment(){
        if(newFindFragment==null){
            synchronized (FragmentFactory.class){
                if(newFindFragment==null){
                    newFindFragment = new NewFindFragment();
                }
            }
        }
        return newFindFragment;
    }

    public NewMyFragment getNewMyFragment(){
        if(newMyFragment==null){
            synchronized (FragmentFactory.class){
                if(newMyFragment==null){
                    newMyFragment = new NewMyFragment();
                }
            }
        }
        return newMyFragment;
    }


}
