package com.example.ronglinbo.mymvp.db.greendao.manager;

import android.content.Context;
import android.util.Log;


import com.example.ronglinbo.mymvp.db.greendao.dao.DaoSession;
import com.example.ronglinbo.mymvp.db.greendao.dao.LocalCacheDateInfoDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/8.
 */

public class BaseDao<T> {
    public static final String TAG = BaseDao.class.getSimpleName();
    public static final boolean DUBUG=true;
    private DbManager manager;
    public DaoSession daoSession;

    private Context mContext;

    public BaseDao(Context context){
        this.mContext=context.getApplicationContext();
        manager = DbManager.getInstance(mContext);
        daoSession=manager.getDaoSession(mContext);
        manager.setDebug(DUBUG);
    }


    public DaoSession getBdDaoSession(Context context){
        this.mContext=context.getApplicationContext();
        if(manager==null){
            getBdManager(mContext);
        }
        daoSession=manager.getDaoSession(mContext);
        return daoSession;
    }

    public DbManager getBdManager(Context context){
        this.mContext=context.getApplicationContext();
        manager = DbManager.getInstance(mContext);
        return manager;
    }



    /**************************数据库插入操作***********************/
    /**
     * 插入单个对象
     * @param object
     * @return
     */
    public boolean insertObject(T object){
        boolean flag = false;
        try {
            flag = getBdManager(mContext).getDaoSession(mContext).insert(object) != -1 ? true:false;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.toString());
        }
        return flag;
    }

    /**
     * 插入多个对象，并开启新的线程
     * @param objects
     * @return
     */
    public boolean insertMultObject(final List<T> objects){
        boolean flag = false;
        if (null == objects || objects.isEmpty()){
            return false;
        }
        try {
            getBdManager(mContext).getDaoSession(mContext).runInTx(new Runnable() {
                @Override
                public void run() {
                    for (T object : objects) {
                        getBdManager(mContext).getDaoSession(mContext).insertOrReplace(object);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            flag = false;
        }finally {
//            manager.CloseDataBase();
        }
        return flag;
    }

    /**************************数据库更新操作***********************/
    /**
     * 以对象形式进行数据修改
     * 其中必须要知道对象的主键ID
     * @param object
     * @return
     */
    public void  updateObject(T object){

        if (null == object){
            return ;
        }
        try {
            getBdManager(mContext).getDaoSession(mContext).update(object);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 批量更新数据
     * @param objects
     * @return
     */
    public void updateMultObject(final List<T> objects, Class clss){
        if (null == objects || objects.isEmpty()){
            return;
        }
        try {

            getBdDaoSession(mContext).getDao(clss).updateInTx(new Runnable() {
                @Override
                public void run() {
                    for(T object:objects){
                        getBdDaoSession(mContext).update(object);
                    }
                }
            });
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }


    /**************************数据库删除操作***********************/
    /**
     * 删除某个数据库表
     * @param clss
     * @return
     */
    public boolean deleteAll(Class clss){
        boolean flag = false;
        try {
            getBdManager(mContext).getDaoSession(mContext).deleteAll(clss);
            flag = true;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            flag = false;
        }
        return flag;
    }

//    /*
//    *
//    * 根据ID删除对象
//    * @param long
//    * @return
//    *
//    * */
//    public void deleteByKey(long id){
//        try{
//            DbManager.getDaoSession(mContext).getStudentDao(.deleteByKey(id);
//        }catch (Exception e){
//            Log.e(TAG,e.toString());
//        }
//    }


    /**
     * 删除某个对象
     * @param object
     * @return
     */
    public void deleteObject(T object){
        try {
            getBdDaoSession(mContext).delete(object);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 异步批量删除数据
     * @param objects
     * @return
     */
    public boolean deleteMultObject(final List<T> objects, Class clss){
        boolean flag = false;
        if (null == objects || objects.isEmpty()){
            return false;
        }
        try {

            getBdDaoSession(mContext).getDao(clss).deleteInTx(new Runnable() {
                @Override
                public void run() {
                    for(T object:objects){
                        getBdDaoSession(mContext).delete(object);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            flag = false;
        }
        return flag;
    }

    /**************************数据库查询操作***********************/

    /**
     * 获得某个表名
     * @return
     */
    public String getTablename(Class object){
        return getBdDaoSession(mContext).getDao(object).getTablename();
    }

    /**
     * 查询某个ID的对象是否存在
     * @param
     * @return
     */
    public boolean isExitObject(long id,Class object){
        QueryBuilder<T> qb = (QueryBuilder<T>) getBdDaoSession(mContext).getDao(object).queryBuilder();
        qb.where(LocalCacheDateInfoDao.Properties.Id.eq(id));
        long length = qb.buildCount().count();
        return length>0 ? true:false;
    }

    /**
     * 根据主键ID来查询
     * @param id
     * @return
     */
    public T QueryById(long id,Class object){
        return (T) getBdDaoSession(mContext).getDao(object).loadByRowId(id);
    }

    /**
     * 查询某条件下的对象
     * @param object
     * @return
     */
    public List<T> QueryObject(Class object, String where, String...params){
        Object obj = null;
        List<T> objects = null;
        try {
            obj = daoSession.getDao(object);
            if (null == obj){
                return null;
            }
            objects = getBdDaoSession(mContext).getDao(object).queryRaw(where,params);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }

        return objects;
    }
    /**
     * 查询所有对象
     * @param object
     * @return
     */
    public List<T> QueryAll(Class object){
        List<T> objects = null;
        try {
            objects = (List<T>) getBdDaoSession(mContext).getDao(object).loadAll();
        } catch (Exception e) {
            Log.e(TAG,e.toString());
        }
        return objects;
    }

    /***************************关闭数据库*************************/
    /**
     * 关闭数据库一般在Odestory中使用
     */
    public void closeDataBase(){
        getBdManager(mContext).closeConnection();
    }

}
