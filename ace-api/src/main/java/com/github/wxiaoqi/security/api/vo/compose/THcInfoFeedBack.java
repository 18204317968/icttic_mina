package com.github.wxiaoqi.security.api.vo.compose;

import java.util.Date;

public class THcInfoFeedBack {
    private String pushId;

    private String warnId;

    private String infoDesc;

    private Date infoDate;

    private String policeTypeId;

    /**
     * @return INFO_ID
     */
    public String getPushId() {
        return pushId;
    }

    /**
     * @param infoId
     */
    public void setPushId(String infoId) {
        this.pushId = pushId;
    }

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
     * @return INFO_DESC
     */
    public String getInfoDesc() {
        return infoDesc;
    }

    /**
     * @param infoDesc
     */
    public void setInfoDesc(String infoDesc) {
        this.infoDesc = infoDesc;
    }

    /**
     * @return INFO_DATE
     */
    public Date getInfoDate() {
        return infoDate;
    }

    /**
     * @param infoDate
     */
    public void setInfoDate(Date infoDate) {
        this.infoDate = infoDate;
    }

    public String getPoliceTypeId() {
        return policeTypeId;
    }

    public void setPoliceTypeId(String policeTypeId) {
        this.policeTypeId = policeTypeId;
    }
}