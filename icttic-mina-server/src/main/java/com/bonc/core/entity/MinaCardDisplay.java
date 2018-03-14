package com.bonc.core.entity;

import javax.persistence.*;

/**
 * 互联互通卡片展示
 * @author qinzhen
 * @Date 2017/11/22
 */
@Table(name = "mina_card_display")
public class MinaCardDisplay {
    /**
     * 交通卡名称
     */
    @Column(name = "card_name")
    private String cardName;

    /**
     * 交通卡图片url
     */
    @Column(name = "card_img_url")
    private String cardImgUrl;

    /**
     * 交通卡省名称
     */
    @Column(name = "card_province_name")
    private String cardProvinceName;

    /**
     * 交通卡省代码
     */
    @Column(name = "card_province_code")
    private String cardProvinceCode;

    /**
     * 交通卡市名称
     */
    @Column(name = "card_city_name")
    private String cardCityName;

    /**
     * 交通卡市代码
     */
    @Column(name = "card_city_code")
    private String cardCityCode;

    /**
     * 交通卡用途-公
     */
    @Column(name = "card_use_gong")
    private String cardUseGong;

    /**
     * 交通卡用途-地
     */
    @Column(name = "card_use_di")
    private String cardUseDi;

    /**
     * 交通卡用途-轮
     */
    @Column(name = "card_use_lun")
    private String cardUseLun;

    /**
     * 交通卡用途-自
     */
    @Column(name = "card_use_zi")
    private String cardUseZi;

    /**
     * 交通卡用途-出
     */
    @Column(name = "card_use_chu")
    private String cardUseChu;

    /**
     * 交通卡用途-停
     */
    @Column(name = "card_use_ting")
    private String cardUseTing;

    /**
     * 交通卡针对的省图片url
     */
    @Column(name = "card_province_img_url")
    private String cardProvinceImgUrl;

    @Column(name = "card_share_img_url")
    private String cardShareImgUrl;

    /**
     * 获取交通卡名称
     *
     * @return card_name - 交通卡名称
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * 设置交通卡名称
     *
     * @param cardName 交通卡名称
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * 获取交通卡图片url
     *
     * @return card_img_url - 交通卡图片url
     */
    public String getCardImgUrl() {
        return cardImgUrl;
    }

    /**
     * 设置交通卡图片url
     *
     * @param cardImgUrl 交通卡图片url
     */
    public void setCardImgUrl(String cardImgUrl) {
        this.cardImgUrl = cardImgUrl;
    }

    /**
     * 获取交通卡省名称
     *
     * @return card_province_name - 交通卡省名称
     */
    public String getCardProvinceName() {
        return cardProvinceName;
    }

    /**
     * 设置交通卡省名称
     *
     * @param cardProvinceName 交通卡省名称
     */
    public void setCardProvinceName(String cardProvinceName) {
        this.cardProvinceName = cardProvinceName;
    }

    /**
     * 获取交通卡省代码
     *
     * @return card_province_code - 交通卡省代码
     */
    public String getCardProvinceCode() {
        return cardProvinceCode;
    }

    /**
     * 设置交通卡省代码
     *
     * @param cardProvinceCode 交通卡省代码
     */
    public void setCardProvinceCode(String cardProvinceCode) {
        this.cardProvinceCode = cardProvinceCode;
    }

    /**
     * 获取交通卡市名称
     *
     * @return card_city_name - 交通卡市名称
     */
    public String getCardCityName() {
        return cardCityName;
    }

    /**
     * 设置交通卡市名称
     *
     * @param cardCityName 交通卡市名称
     */
    public void setCardCityName(String cardCityName) {
        this.cardCityName = cardCityName;
    }

    /**
     * 获取交通卡市代码
     *
     * @return card_city_code - 交通卡市代码
     */
    public String getCardCityCode() {
        return cardCityCode;
    }

    /**
     * 设置交通卡市代码
     *
     * @param cardCityCode 交通卡市代码
     */
    public void setCardCityCode(String cardCityCode) {
        this.cardCityCode = cardCityCode;
    }

    /**
     * 获取交通卡用途-公（0为不可用，1为可用）
     *
     * @return card_use_gong - 交通卡用途-公（0为不可用，1为可用）
     */
    public String getCardUseGong() {
        return cardUseGong;
    }

    /**
     * 设置交通卡用途-公（0为不可用，1为可用）
     *
     * @param cardUseGong 交通卡用途-公（0为不可用，1为可用）
     */
    public void setCardUseGong(String cardUseGong) {
        this.cardUseGong = cardUseGong;
    }

    /**
     * 获取交通卡用途-地（0为不可用，1为可用）
     *
     * @return card_use_di - 交通卡用途-地（0为不可用，1为可用）
     */
    public String getCardUseDi() {
        return cardUseDi;
    }

    /**
     * 设置交通卡用途-地（0为不可用，1为可用）
     *
     * @param cardUseDi 交通卡用途-地（0为不可用，1为可用）
     */
    public void setCardUseDi(String cardUseDi) {
        this.cardUseDi = cardUseDi;
    }

    /**
     * 获取交通卡用途-轮（0为不可用，1为可用）
     *
     * @return card_use_lun - 交通卡用途-轮（0为不可用，1为可用）
     */
    public String getCardUseLun() {
        return cardUseLun;
    }

    /**
     * 设置交通卡用途-轮（0为不可用，1为可用）
     *
     * @param cardUseLun 交通卡用途-轮（0为不可用，1为可用）
     */
    public void setCardUseLun(String cardUseLun) {
        this.cardUseLun = cardUseLun;
    }

    /**
     * 获取交通卡用途-自（0为不可用，1为可用）
     *
     * @return card_use_zi - 交通卡用途-自（0为不可用，1为可用）
     */
    public String getCardUseZi() {
        return cardUseZi;
    }

    /**
     * 设置交通卡用途-自（0为不可用，1为可用）
     *
     * @param cardUseZi 交通卡用途-自（0为不可用，1为可用）
     */
    public void setCardUseZi(String cardUseZi) {
        this.cardUseZi = cardUseZi;
    }

    /**
     * 获取交通卡用途-出（0为不可用，1为可用）
     *
     * @return card_use_chu - 交通卡用途-出（0为不可用，1为可用）
     */
    public String getCardUseChu() {
        return cardUseChu;
    }

    /**
     * 设置交通卡用途-出（0为不可用，1为可用）
     *
     * @param cardUseChu 交通卡用途-出（0为不可用，1为可用）
     */
    public void setCardUseChu(String cardUseChu) {
        this.cardUseChu = cardUseChu;
    }

    /**
     * 获取交通卡用途-停（0为不可用，1为可用）
     *
     * @return card_use_ting - 交通卡用途-停（0为不可用，1为可用）
     */
    public String getCardUseTing() {
        return cardUseTing;
    }

    /**
     * 设置交通卡用途-停（0为不可用，1为可用）
     *
     * @param cardUseTing 交通卡用途-停（0为不可用，1为可用）
     */
    public void setCardUseTing(String cardUseTing) {
        this.cardUseTing = cardUseTing;
    }

    /**
     * 获取交通卡针对的省图片url
     * @return
     */
    public String getCardProvinceImgUrl() {
        return cardProvinceImgUrl;
    }

    /**
     * 设置交通卡针对的省图片url
     * @param cardProvinceImgUrl
     */
    public void setCardProvinceImgUrl(String cardProvinceImgUrl) {
        this.cardProvinceImgUrl = cardProvinceImgUrl;
    }

    /**
     * 获取交通卡针对的分享图片url
     * @return
     */
    public String getCardShareImgUrl() {
        return cardShareImgUrl;
    }

    /**
     * 设置交通卡针对的分享图片url
     * @param cardShareImgUrl
     */
    public void setCardShareImgUrl(String cardShareImgUrl) {
        this.cardShareImgUrl = cardShareImgUrl;
    }
}