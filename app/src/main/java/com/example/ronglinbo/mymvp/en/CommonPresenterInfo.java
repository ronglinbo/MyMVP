package com.example.ronglinbo.mymvp.en;

/**
 * Created by Administrator on 2018/5/24.
 */

public class CommonPresenterInfo<T> {

    private boolean isGson;
    private Class gsonClass=null;
    private int saveToWhere;     //0 不保存到本地  1保存到grrenDao  2,保存到首选项
    private boolean isShowLoading=true;


    public boolean isGson() {
        return isGson;
    }

    public CommonPresenterInfo setGson(boolean gson) {
        isGson = gson;
        return this;
    }

    public CommonPresenterInfo setGsonClass(Class gsonClass) {
        this.gsonClass = gsonClass;
        return this;
    }

    public Class getGsonClass() {
        return gsonClass;
    }

    public int getSaveToWhere() {
        return saveToWhere;
    }

    public CommonPresenterInfo setSaveToWhere(int saveToWhere) {
        this.saveToWhere = saveToWhere;
        return this;
    }

    public boolean isShowLoading() {
        return isShowLoading;
    }

    public CommonPresenterInfo setShowLoading(boolean showLoading) {
        isShowLoading = showLoading;
        return this;
    }
}
