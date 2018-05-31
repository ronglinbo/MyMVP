package com.example.ronglinbo.mymvp.en;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Administrator on 2018/5/22.
 */
@Entity
public class LocalCacheDateInfo {
    @Id
    private String id;

    private int cacheLevel;   //缓存等级

    private String content;   //缓存内容

    private String cacheType;   //缓存类型

    private int status;          //缓存状态

    @Generated(hash = 553452345)
    public LocalCacheDateInfo(String id, int cacheLevel, String content,
                              String cacheType, int status) {
        this.id = id;
        this.cacheLevel = cacheLevel;
        this.content = content;
        this.cacheType = cacheType;
        this.status = status;
    }

    @Generated(hash = 1130623621)
    public LocalCacheDateInfo() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCacheLevel() {
        return this.cacheLevel;
    }

    public void setCacheLevel(int cacheLevel) {
        this.cacheLevel = cacheLevel;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCacheType() {
        return this.cacheType;
    }

    public void setCacheType(String cacheType) {
        this.cacheType = cacheType;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
