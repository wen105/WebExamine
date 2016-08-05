package com.shuyun.entity;

/**
 * Created by shuyun on 2016/8/4.
 * 上传资料表
 */
public class UserData {
    private int dataId;
    private int userId;
    private String dataTitle;
    private String dataContent;



    private String dataName;
    public UserData(){}

    public UserData(int dataId, int userId, String dataTitle, String dataContent, String dataName) {
        this.dataId = dataId;
        this.userId = userId;
        this.dataTitle = dataTitle;
        this.dataContent = dataContent;
        this.dataName = dataName;
    }

    public UserData(int userId, String dataTitle, String dataContent, String dataName) {
        this.userId = userId;
        this.dataTitle = dataTitle;
        this.dataContent = dataContent;
        this.dataName = dataName;
    }

    @Override
    public String toString() {
        return "Data{" +
                "dataId=" + dataId +
                ", userId=" + userId +
                ", dataTitle='" + dataTitle + '\'' +
                ", dataContent='" + dataContent + '\'' +
                ", dataName='" + dataName + '\'' +
                '}';
    }

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDataTitle() {
        return dataTitle;
    }

    public void setDataTitle(String dataTitle) {
        this.dataTitle = dataTitle;
    }
    public String getDataContent() {
        return dataContent;
    }
    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }
}
