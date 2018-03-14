package com.bonc.core.entity;

import javax.persistence.*;

@Table(name = "mina_inter_city")
public class MinaInterCity {
    /**
     * 交通卡所在的省名
     */
    @Column(name = "card_province_name")
    private String cardProvinceName;

    /**
     * 交通卡省（行政）代码
     */
    @Column(name = "card_province_code")
    private String cardProvinceCode;

    /**
     * 交通卡城市名
     */
    @Column(name = "card_city_name")
    private String cardCityName;

    /**
     * 交通卡市代码（区号）
     */
    @Column(name = "card_city_code")
    private String cardCityCode;

    /**
     * 发卡机构
     */
    @Column(name = "card_issuer")
    private String cardIssuer;

    /**
     * 全国互联互通线路
     */
    @Column(name = "busline_name")
    private String buslineName;

    /**
     * 售卡价格
     */
    @Column(name = "card_price")
    private String cardPrice;

    /**
     * 发卡卡种
     */
    @Column(name = "card_type")
    private String cardType;

    /**
     * 基准票价
     */
    @Column(name = "basic_fare")
    private String basicFare;

    /**
     * 异地优惠
     */
    @Column(name = "allopatry_discount")
    private String allopatryDiscount;

    /**
     * 官方网站
     */
    @Column(name = "official_site")
    private String officialSite;

    /**
     * 官方微信公众账号
     */
    @Column(name = "official_wechat_account")
    private String officialWechatAccount;

    /**
     * 热线电话
     */
    @Column(name = "phone_hotline")
    private String phoneHotline;

    /**
     * 发卡量
     */
    @Column(name = "card_num")
    private Integer cardNum;

    /**
     * 基础票价详情
     */
    @Column(name = "basic_fare_details")
    private String basicFareDetails;

    /**
     * 异地优惠详情
     */
    @Column(name = "allopatry_discount_detail")
    private String allopatryDiscountDetail;

    /**
     * 获取交通卡所在的省名
     *
     * @return card_province_name - 交通卡所在的省名
     */
    public String getCardProvinceName() {
        return cardProvinceName;
    }

    /**
     * 设置交通卡所在的省名
     *
     * @param cardProvinceName 交通卡所在的省名
     */
    public void setCardProvinceName(String cardProvinceName) {
        this.cardProvinceName = cardProvinceName;
    }

    /**
     * 获取交通卡省（行政）代码
     *
     * @return card_province_code - 交通卡省（行政）代码
     */
    public String getCardProvinceCode() {
        return cardProvinceCode;
    }

    /**
     * 设置交通卡省（行政）代码
     *
     * @param cardProvinceCode 交通卡省（行政）代码
     */
    public void setCardProvinceCode(String cardProvinceCode) {
        this.cardProvinceCode = cardProvinceCode;
    }

    /**
     * 获取交通卡城市名
     *
     * @return card_city_name - 交通卡城市名
     */
    public String getCardCityName() {
        return cardCityName;
    }

    /**
     * 设置交通卡城市名
     *
     * @param cardCityName 交通卡城市名
     */
    public void setCardCityName(String cardCityName) {
        this.cardCityName = cardCityName;
    }

    /**
     * 获取交通卡市代码（区号）
     *
     * @return card_city_code - 交通卡市代码（区号）
     */
    public String getCardCityCode() {
        return cardCityCode;
    }

    /**
     * 设置交通卡市代码（区号）
     *
     * @param cardCityCode 交通卡市代码（区号）
     */
    public void setCardCityCode(String cardCityCode) {
        this.cardCityCode = cardCityCode;
    }

    /**
     * 获取发卡机构
     *
     * @return card_issuer - 发卡机构
     */
    public String getCardIssuer() {
        return cardIssuer;
    }

    /**
     * 设置发卡机构
     *
     * @param cardIssuer 发卡机构
     */
    public void setCardIssuer(String cardIssuer) {
        this.cardIssuer = cardIssuer;
    }

    /**
     * 获取全国互联互通线路
     *
     * @return busline_name - 全国互联互通线路
     */
    public String getBuslineName() {
        return buslineName;
    }

    /**
     * 设置全国互联互通线路
     *
     * @param buslineName 全国互联互通线路
     */
    public void setBuslineName(String buslineName) {
        this.buslineName = buslineName;
    }

    /**
     * 获取售卡价格
     *
     * @return card_price - 售卡价格
     */
    public String getCardPrice() {
        return cardPrice;
    }

    /**
     * 设置售卡价格
     *
     * @param cardPrice 售卡价格
     */
    public void setCardPrice(String cardPrice) {
        this.cardPrice = cardPrice;
    }

    /**
     * 获取发卡卡种
     *
     * @return card_type - 发卡卡种
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * 设置发卡卡种
     *
     * @param cardType 发卡卡种
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /**
     * 获取基准票价
     *
     * @return basic_fare - 基准票价
     */
    public String getBasicFare() {
        return basicFare;
    }

    /**
     * 设置基准票价
     *
     * @param basicFare 基准票价
     */
    public void setBasicFare(String basicFare) {
        this.basicFare = basicFare;
    }

    /**
     * 获取异地优惠
     *
     * @return allopatry_discount - 异地优惠
     */
    public String getAllopatryDiscount() {
        return allopatryDiscount;
    }

    /**
     * 设置异地优惠
     *
     * @param allopatryDiscount 异地优惠
     */
    public void setAllopatryDiscount(String allopatryDiscount) {
        this.allopatryDiscount = allopatryDiscount;
    }

    /**
     * 获取官方网站
     *
     * @return official_site - 官方网站
     */
    public String getOfficialSite() {
        return officialSite;
    }

    /**
     * 设置官方网站
     *
     * @param officialSite 官方网站
     */
    public void setOfficialSite(String officialSite) {
        this.officialSite = officialSite;
    }

    /**
     * 获取官方微信公众账号
     *
     * @return official_wechat_account - 官方微信公众账号
     */
    public String getOfficialWechatAccount() {
        return officialWechatAccount;
    }

    /**
     * 设置官方微信公众账号
     *
     * @param officialWechatAccount 官方微信公众账号
     */
    public void setOfficialWechatAccount(String officialWechatAccount) {
        this.officialWechatAccount = officialWechatAccount;
    }

    /**
     * 获取热线电话
     *
     * @return phone_hotline - 热线电话
     */
    public String getPhoneHotline() {
        return phoneHotline;
    }

    /**
     * 设置热线电话
     *
     * @param phoneHotline 热线电话
     */
    public void setPhoneHotline(String phoneHotline) {
        this.phoneHotline = phoneHotline;
    }

    /**
     * 获取发卡量
     *
     * @return card_num - 发卡量
     */
    public Integer getCardNum() {
        return cardNum;
    }

    /**
     * 设置发卡量
     *
     * @param cardNum 发卡量
     */
    public void setCardNum(Integer cardNum) {
        this.cardNum = cardNum;
    }

    /**
     * 获取基础票价详情
     *
     * @return basic_fare_details - 基础票价详情
     */
    public String getBasicFareDetails() {
        return basicFareDetails;
    }

    /**
     * 设置基础票价详情
     *
     * @param basicFareDetails 基础票价详情
     */
    public void setBasicFareDetails(String basicFareDetails) {
        this.basicFareDetails = basicFareDetails;
    }

    /**
     * 获取异地优惠详情
     *
     * @return allopatry_discount_detail - 异地优惠详情
     */
    public String getAllopatryDiscountDetail() {
        return allopatryDiscountDetail;
    }

    /**
     * 设置异地优惠详情
     *
     * @param allopatryDiscountDetail 异地优惠详情
     */
    public void setAllopatryDiscountDetail(String allopatryDiscountDetail) {
        this.allopatryDiscountDetail = allopatryDiscountDetail;
    }

}