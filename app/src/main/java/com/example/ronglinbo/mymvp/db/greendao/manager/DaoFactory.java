package com.example.ronglinbo.mymvp.db.greendao.manager;

import com.example.ronglinbo.mymvp.MyApplication;

/**
 * Created by ronglinbo on 2018/5/22.
 */

public class DaoFactory {

    private static DaoFactory mInstance=null;

    private LocalCacheDateManager localCacheDateManager=null;

    public static DaoFactory getInstance(){
        if(mInstance==null){
            synchronized (DaoFactory.class){
                if(mInstance ==null){
                    mInstance=new DaoFactory();
                }
            }
        }
        return mInstance;
    }


    /**
     * 获取本地缓存数据操作db
     * @return
     */
    public LocalCacheDateManager getLocalCacheDateManager(){
        if(localCacheDateManager==null){
            localCacheDateManager=new LocalCacheDateManager(MyApplication.appContext);
        }
        return localCacheDateManager;
    }


    /**
     * 关闭缓存数据库db
     */
    public void closeLocalCacheDateManager(){
        if(localCacheDateManager!=null){
            localCacheDateManager.closeDataBase();
            localCacheDateManager=null;
        }
    }


}
