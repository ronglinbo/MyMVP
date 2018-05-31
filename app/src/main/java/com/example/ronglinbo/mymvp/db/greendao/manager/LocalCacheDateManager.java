package com.example.ronglinbo.mymvp.db.greendao.manager;

import android.content.Context;

import com.example.ronglinbo.mymvp.db.greendao.dao.LocalCacheDateInfoDao;
import com.example.ronglinbo.mymvp.en.LocalCacheDateInfo;

import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.QueryBuilder;

/**
 * Created by Administrator on 2018/5/22.
 */

public class LocalCacheDateManager extends BaseDao<LocalCacheDateInfo> {

    public Context mContext;

    public LocalCacheDateManager(Context context) {
        super(context);
        mContext=context;
    }

    /**
     * 添加数据至数据库
     * @param cacheDate
     */
    public void insertData(LocalCacheDateInfo cacheDate){
        getBdDaoSession(mContext).getLocalCacheDateInfoDao().insert(cacheDate);
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param cacheDate
     */
    public void saveData(LocalCacheDateInfo cacheDate) {
//        getBdDaoSession(mContext).getLocalCacheDateInfoDao().save(cacheDate);

        QueryBuilder<LocalCacheDateInfo> qb=getBdDaoSession(mContext).getLocalCacheDateInfoDao().queryBuilder();
        qb.where(LocalCacheDateInfoDao.Properties.Id.eq(cacheDate.getId()));
        if(qb.list().size()>0){
            getBdDaoSession(mContext).getLocalCacheDateInfoDao().update(cacheDate);
        }else{
            getBdDaoSession(mContext).getLocalCacheDateInfoDao().insert(cacheDate);
        }
    }


    /**
     * 删除数据至数据库
     *
     * @param cacheDate 删除具体内容
     */
    public void deleteData(LocalCacheDateInfo cacheDate) {
        getBdDaoSession(mContext).getLocalCacheDateInfoDao().delete(cacheDate);
    }


    /**
     * 根据id删除数据至数据库
     *
     * @param id      删除具体内容
     */
    public void deleteByKeyData(String id) {
        getBdDaoSession(mContext).getLocalCacheDateInfoDao().deleteByKey(id);
    }


    /**
     * 删除全部数据
     *
     * @param context
     */
    public void deleteAllData(Context context) {
        getBdDaoSession(mContext).getLocalCacheDateInfoDao().deleteAll();
    }


    /**
     * 删除小于 level 的缓存
     * @param level
     */
    public void deleteByLevelData(int level){
        DeleteQuery<LocalCacheDateInfo> bd =getBdDaoSession(mContext).getLocalCacheDateInfoDao().queryBuilder().where(LocalCacheDateInfoDao.Properties.CacheLevel.lt(level)).buildDelete();
        bd.executeDeleteWithoutDetachingEntities();
    }



    /**
     * 根据ID查询数据
     * @param id
     * @return
     */
    public LocalCacheDateInfo queryByKeyData(String id){
        return getBdDaoSession(mContext).getLocalCacheDateInfoDao().load(id);
    }




}
