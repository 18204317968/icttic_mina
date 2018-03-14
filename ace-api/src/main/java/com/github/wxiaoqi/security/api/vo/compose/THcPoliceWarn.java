package com.github.wxiaoqi.security.api.vo.compose;

import java.util.Date;

public class THcPoliceWarn {
    private String warnId;

    private String caseTypeId;

    private String caseTypeName;

    private String description;

    private Date caseTime;

    private Date insertTime;

    private Long warnLevel;
    private String processStatus;
    private String caseStatus;

    private Date endTime;
    private String policeTypeId;
    private String caseName;
    private String startUser;

    private String policeTypeName;
    private String feedBack;

    private String rOrientId;

    /**
     * 推送警种Id
     */
    private String pushPoliceId;
    /**
     * 推送警种名称
     */
    private String pushPoliceName;

    /**
     * 处理状态描述
     */
    private String processStatusDesc;

    /**
     * 案件状态描述
     */
    private String caseStatusDesc;


    /**
     * @return WARN_ID
     */
    public String getWarnId() {
        return warnId;
    }

    /**
     * @param warnId
     */
    public void setWarnId(String warnId) {
        this.warnId = warnId;
    }

    /**
     * @return CASE_TYPE_ID
     */
    public String getCaseTypeId() {
        return caseTypeId;
    }

    /**
     * @param caseTypeId
     */
    public void setCaseTypeId(String caseTypeId) {
        this.caseTypeId = caseTypeId;
    }


    public String getCaseTypeName() {
        return caseTypeName;
    }

    public void setCaseTypeName(String caseTypeName) {
        this.caseTypeName = caseTypeName;
    }

    /**
     * @return DESCRIPTION
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return CASE_TIME
     */
    public Date getCaseTime() {
        return caseTime;
    }

    /**
     * @param caseTime
     */
    public void setCaseTime(Date caseTime) {
        this.caseTime = caseTime;
    }

    /**
     * @return INSERT_TIME
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Long getWarnLevel() {
        return warnLevel;
    }

    public void setWarnLevel(Long warnLevel) {
        this.warnLevel = warnLevel;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPoliceTypeId() {
        return policeTypeId;
    }

    public void setPoliceTypeId(String policeTypeId) {
        this.policeTypeId = policeTypeId;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getStartUser() {
        return startUser;
    }

    public void setStartUser(String startUser) {
        this.startUser = startUser;
    }

    public String getPushPoliceId() {
        return pushPoliceId;
    }

    public void setPushPoliceId(String pushPoliceId) {
        this.pushPoliceId = pushPoliceId;
    }

    public String getPushPoliceName() {
        return pushPoliceName;
    }

    public void setPushPoliceName(String pushPoliceName) {
        this.pushPoliceName = pushPoliceName;
    }

    public String getProcessStatusDesc() {
        return processStatusDesc;
    }

    public void setProcessStatusDesc(String processStatusDesc) {
        this.processStatusDesc = processStatusDesc;
    }

    public String getCaseStatusDesc() {
        return caseStatusDesc;
    }

    public void setCaseStatusDesc(String caseStatusDesc) {
        this.caseStatusDesc = caseStatusDesc;
    }

    public String getPoliceTypeName() {
        return policeTypeName;
    }

    public void setPoliceTypeName(String policeTypeName) {
        this.policeTypeName = policeTypeName;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getrOrientId() {
        return rOrientId;
    }

    public void setrOrientId(String rOrientId) {
        this.rOrientId = rOrientId;
    }
}