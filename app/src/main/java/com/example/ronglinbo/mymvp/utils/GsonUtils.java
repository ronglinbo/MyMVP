package com.example.ronglinbo.mymvp.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Administrator on 2018/5/22.
 */

public class GsonUtils {
    /** 默认的 {@code JSON} 日期/时间字段的格式化模式。 */
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";



    /**
     * 将给定的 {@code JSON} 字符串转换成指定的类型对象。
     *
     * @param json 给定的 {@code JSON} 字符串。
     * @param clazz 类模板。
     * @return 给定的 {@code JSON} 字符串表示的指定的类型对象。
     * @since 1.01
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat(DEFAULT_DATE_PATTERN);
        Gson gson = builder.create();
        return gson.fromJson(json, clazz);
    }


    /**
     * 对象转json
     * @param obj  需要转换成json的对象
     * @return
     */
    public static String classToString(Object obj){
        Gson gson = new Gson();
        String data = gson.toJson(obj);
        return data;
    }
}
