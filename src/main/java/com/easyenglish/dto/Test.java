package com.easyenglish.dto;

import java.util.Date;

public class Test {
    private Integer testId;

    private String name;

    private Integer type;

    private Integer grade;

    private Integer textbook;

    private Float totalMark;

    private Integer doCount;

    private Integer readCount;

    private Integer likeCount;

    private Integer handInCount;

    private Integer needTime;

    private Float passedMark;

    private Date createTime;

    private Date publishTime;

    private Integer testStatus;

    private Integer needPoint;

    private Integer getPoint;

    private String coverUrl;

    private String imageUrl;

    private Date updateTime;

    private Integer status;

    private String remark;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getTextbook() {
        return textbook;
    }

    public void setTextbook(Integer textbook) {
        this.textbook = textbook;
    }

    public Float getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(Float totalMark) {
        this.totalMark = totalMark;
    }

    public Integer getDoCount() {
        return doCount;
    }

    public void setDoCount(Integer doCount) {
        this.doCount = doCount;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getHandInCount() {
        return handInCount;
    }

    public void setHandInCount(Integer handInCount) {
        this.handInCount = handInCount;
    }

    public Integer getNeedTime() {
        return needTime;
    }

    public void setNeedTime(Integer needTime) {
        this.needTime = needTime;
    }

    public Float getPassedMark() {
        return passedMark;
    }

    public void setPassedMark(Float passedMark) {
        this.passedMark = passedMark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(Integer testStatus) {
        this.testStatus = testStatus;
    }

    public Integer getNeedPoint() {
        return needPoint;
    }

    public void setNeedPoint(Integer needPoint) {
        this.needPoint = needPoint;
    }

    public Integer getGetPoint() {
        return getPoint;
    }

    public void setGetPoint(Integer getPoint) {
        this.getPoint = getPoint;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl == null ? null : coverUrl.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}