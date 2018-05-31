package com.example.ronglinbo.mymvp.db.greendao.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import com.example.ronglinbo.mymvp.db.greendao.dao.DaoMaster;
import com.example.ronglinbo.mymvp.db.greendao.dao.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * Created by Administrator on 2018/4/8.
 */

public class DbManager {

    //是否加密
    public static final boolean ENCRYPTED = true;

    //数据库名
    private static final String DB_NAME = "leavemessage.db";

    private static DbManager mDbManager;

    private static DaoMaster.DevOpenHelper mDevOpenHelper;

    private static DaoMaster mDaoMaster;

    private static DaoSession mDaoSession;

    private Context mContext;


    private DbManager(Context context){
        this.mContext=context.getApplicationContext();
        //初始化数据库信息
        mDevOpenHelper = new DaoMaster.DevOpenHelper(this.mContext,DB_NAME);
        getDaoMaster(this.mContext);
        getDaoSession(this.mContext);

    }


    public static DbManager getInstance(Context context) {
        if (null == mDbManager) {
            synchronized (DbManager.class) {
                if (null == mDbManager) {
                    mDbManager = new DbManager(context);
                }
            }
        }
        return mDbManager;
    }



    /**
     * 获取可读数据库
     *
     * @param context
     * @return
     */
    public static SQLiteDatabase getReadableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }
        return mDevOpenHelper.getReadableDatabase();
    }

    /**
     * 获取可写数据库
     *
     * @param context
     * @return
     */
    public static SQLiteDatabase getWritableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }

        return mDevOpenHelper.getWritableDatabase();
    }

    /**
     * 获取DaoMaster
     *
     * @param context
     * @return
     */
    public static DaoMaster getDaoMaster(Context context) {
        if (null == mDaoMaster) {
            synchronized (DbManager.class) {
                if (null == mDaoMaster) {
                    mDaoMaster = new DaoMaster(getWritableDatabase(context));
                }
            }
        }
        return mDaoMaster;
    }


    /**
     * 获取DaoSession
     *
     * @param context
     * @return
     */
    public static DaoSession getDaoSession(Context context) {
        if (null == mDaoSession) {
            synchronized (DbManager.class) {
                if(null==mDaoSession){
                    mDaoSession = getDaoMaster(context).newSession();
                }
            }
        }
//        setDebug(true);
        return mDaoSession;
    }

    /**
     * 打开输出日志的操作,默认是关闭的
     */
    public static void setDebug(boolean flag) {
        QueryBuilder.LOG_SQL = flag;
        QueryBuilder.LOG_VALUES = flag;
    }

    /**
     * 关闭所有的操作,数据库开启的时候，使用完毕了必须要关闭
     */
    public void closeConnection() {
        mDbManager=null;
        mDaoMaster=null;
        closeHelper();
        closeDaoSession();
    }

    public void closeHelper() {
        if (mDevOpenHelper != null) {
            mDevOpenHelper.close();
            ;
            mDevOpenHelper = null;
        }
    }

    public void closeDaoSession() {
        if (mDaoSession != null) {
            mDaoSession.clear();
            ;
            mDaoSession = null;
        }
    }






}

