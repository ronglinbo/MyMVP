package com.example.ronglinbo.mymvp.en;

import android.util.Log;

import com.example.ronglinbo.mymvp.db.greendao.manager.DaoFactory;
import com.example.ronglinbo.mymvp.utils.GsonUtils;

/**
 * Created by Administrator on 2018/5/10.
 */

public class DateInfo implements BaseInfo{

    public String success;
    public Result result;

    public static class Result{
        public String timestamp;
        public String datetime_1;
        public String datetime_2;
        public String week_1;
        public String week_2;
        public String week_3;
        public String week_4;

        @Override
        public String toString() {
            return "Result{" +
                    "timestamp='" + timestamp + '\'' +
                    ", datetime_1='" + datetime_1 + '\'' +
                    ", datetime_2='" + datetime_2 + '\'' +
                    ", week_1='" + week_1 + '\'' +
                    ", week_2='" + week_2 + '\'' +
                    ", week_3='" + week_3 + '\'' +
                    ", week_4='" + week_4 + '\'' +
                    '}';
        }

    }


//    /**
//     * 保存到数据库
//     */
//    public void saveToDb(){
//        String json= GsonUtils.classToString(this);
//        LocalCacheDateInfo localCacheDateInfo=new LocalCacheDateInfo();
//        localCacheDateInfo.setId(DateInfo.class.getName());
//        localCacheDateInfo.setCacheLevel(2);
//        localCacheDateInfo.setContent(json);
//        localCacheDateInfo.setStatus(0);
//        DaoFactory.getInstance().getLocalCacheDateManager().saveData(localCacheDateInfo);
//        DaoFactory.getInstance().closeLocalCacheDateManager();
//        Log.i("DateInfoTAg","json:"+json);
//    }
//
//    /**
//     * 从数据库获取信息
//     * @return
//     */
//    public static DateInfo builder(){
//        LocalCacheDateInfo localCacheDateInfo = DaoFactory.getInstance().getLocalCacheDateManager().queryByKeyData(DateInfo.class.getName());
//        if(localCacheDateInfo==null){
//            return null;
//        }
//        String json=localCacheDateInfo.getContent();
//        DaoFactory.getInstance().closeLocalCacheDateManager();
//        Log.i("DateInfoTAg2","json:"+json);
//        return GsonUtils.fromJson(json,DateInfo.class);
//    }



    /**
     * 保存到数据库
     */
    public boolean saveToDb(){
        try{
            String json= GsonUtils.classToString(this);
            LocalCacheDateInfo localCacheDateInfo=new LocalCacheDateInfo();
            localCacheDateInfo.setId(DateInfo.class.getName());
            localCacheDateInfo.setCacheLevel(2);
            localCacheDateInfo.setContent(json);
            localCacheDateInfo.setStatus(0);
            DaoFactory.getInstance().getLocalCacheDateManager().saveData(localCacheDateInfo);
            DaoFactory.getInstance().closeLocalCacheDateManager();
            Log.i("DateInfoTAg","json:"+json);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 从数据库获取信息
     * @return
     */
    public static DateInfo builder(){
        LocalCacheDateInfo localCacheDateInfo = DaoFactory.getInstance().getLocalCacheDateManager().queryByKeyData(DateInfo.class.getName());
        if(localCacheDateInfo==null){
            return null;
        }
        String json=localCacheDateInfo.getContent();
        DaoFactory.getInstance().closeLocalCacheDateManager();
        return GsonUtils.fromJson(json,DateInfo.class);
    }


}
