package com.easyenglish.dto;

import java.util.Date;

public class Question {
    private Integer qId;

    private Integer testId;

    private Integer questionNumber;

    private Integer questionType;

    private String subject;

    private Integer type;

    private Integer grade;

    private Integer textbook;

    private String fillInAnswer;

    private String optionAnswer;

    private Integer trueFalseAnswer;

    private String imgUrl;

    private Date createTime;

    private String createAdmin;

    private Date updateTime;

    private Integer status;

    private String remark;

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
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

    public String getFillInAnswer() {
        return fillInAnswer;
    }

    public void setFillInAnswer(String fillInAnswer) {
        this.fillInAnswer = fillInAnswer == null ? null : fillInAnswer.trim();
    }

    public String getOptionAnswer() {
        return optionAnswer;
    }

    public void setOptionAnswer(String optionAnswer) {
        this.optionAnswer = optionAnswer == null ? null : optionAnswer.trim();
    }

    public Integer getTrueFalseAnswer() {
        return trueFalseAnswer;
    }

    public void setTrueFalseAnswer(Integer trueFalseAnswer) {
        this.trueFalseAnswer = trueFalseAnswer;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateAdmin() {
        return createAdmin;
    }

    public void setCreateAdmin(String createAdmin) {
        this.createAdmin = createAdmin == null ? null : createAdmin.trim();
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