package com.bonc.core.entity;

import javax.persistence.*;

@Table(name = "mina_home_yywd")
public class MinaHomeYywd {
    /**
     * 营业网点名称
     */
    @Column(name = "yywd_name")
    private String yywdName;

    /**
     * 经纬度
     */
    @Column(name = "yywd_location")
    private String yywdLocation;

    /**
     * 营业网点图片链接
     */
    @Column(name = "yywd_img_url")
    private String yywdImgUrl;

    /**
     * 营业网点省代码
     */
    @Column(name = "yywd_province_code")
    private String yywdProvinceCode;

    /**
     * 营业网点省名称
     */
    @Column(name = "yywd_province_name")
    private String yywdProvinceName;

    /**
     * 营业网点市代码
     */
    @Column(name = "yywd_city_code")
    private String yywdCityCode;

    /**
     * 营业网点市名称
     */
    @Column(name = "yywd_city_name")
    private String yywdCityName;

    /**
     * 营业网点区代码
     */
    @Column(name = "yywd_district_code")
    private String yywdDistrictCode;

    /**
     * 营业网点区名称
     */
    @Column(name = "yywd_district_name")
    private String yywdDistrictName;

    /**
     * 发卡充资
     */
    @Column(name = "yywd_fkcz")
    private String yywdFkcz;

    /**
     * 营业网点-退卡退资
     */
    @Column(name = "yywd_tktz")
    private String yywdTktz;

    /**
     * 营业网点-充值
     */
    @Column(name = "yywd_cz")
    private String yywdCz;

    /**
     * 获取营业网点名称
     *
     * @return yywd_name - 营业网点名称
     */
    public String getYywdName() {
        return yywdName;
    }

    /**
     * 设置营业网点名称
     *
     * @param yywdName 营业网点名称
     */
    public void setYywdName(String yywdName) {
        this.yywdName = yywdName;
    }

    /**
     * 获取经纬度
     *
     * @return yywd_location - 经纬度
     */
    public String getYywdLocation() {
        return yywdLocation;
    }

    /**
     * 设置经纬度
     *
     * @param yywdLocation 经纬度
     */
    public void setYywdLocation(String yywdLocation) {
        this.yywdLocation = yywdLocation;
    }

    /**
     * 获取营业网点图片链接
     *
     * @return yywd_img_url - 营业网点图片链接
     */
    public String getYywdImgUrl() {
        return yywdImgUrl;
    }

    /**
     * 设置营业网点图片链接
     *
     * @param yywdImgUrl 营业网点图片链接
     */
    public void setYywdImgUrl(String yywdImgUrl) {
        this.yywdImgUrl = yywdImgUrl;
    }

    /**
     * 获取营业网点省代码
     *
     * @return yywd_province_code - 营业网点省代码
     */
    public String getYywdProvinceCode() {
        return yywdProvinceCode;
    }

    /**
     * 设置营业网点省代码
     *
     * @param yywdProvinceCode 营业网点省代码
     */
    public void setYywdProvinceCode(String yywdProvinceCode) {
        this.yywdProvinceCode = yywdProvinceCode;
    }

    /**
     * 获取营业网点省名称
     *
     * @return yywd_province_name - 营业网点省名称
     */
    public String getYywdProvinceName() {
        return yywdProvinceName;
    }

    /**
     * 设置营业网点省名称
     *
     * @param yywdProvinceName 营业网点省名称
     */
    public void setYywdProvinceName(String yywdProvinceName) {
        this.yywdProvinceName = yywdProvinceName;
    }

    /**
     * 获取营业网点市代码
     *
     * @return yywd_city_code - 营业网点市代码
     */
    public String getYywdCityCode() {
        return yywdCityCode;
    }

    /**
     * 设置营业网点市代码
     *
     * @param yywdCityCode 营业网点市代码
     */
    public void setYywdCityCode(String yywdCityCode) {
        this.yywdCityCode = yywdCityCode;
    }

    /**
     * 获取营业网点市名称
     *
     * @return yywd_city_name - 营业网点市名称
     */
    public String getYywdCityName() {
        return yywdCityName;
    }

    /**
     * 设置营业网点市名称
     *
     * @param yywdCityName 营业网点市名称
     */
    public void setYywdCityName(String yywdCityName) {
        this.yywdCityName = yywdCityName;
    }

    /**
     * 获取营业网点区代码
     *
     * @return yywd_district_code - 营业网点区代码
     */
    public String getYywdDistrictCode() {
        return yywdDistrictCode;
    }

    /**
     * 设置营业网点区代码
     *
     * @param yywdDistrictCode 营业网点区代码
     */
    public void setYywdDistrictCode(String yywdDistrictCode) {
        this.yywdDistrictCode = yywdDistrictCode;
    }

    /**
     * 获取营业网点区名称
     *
     * @return yywd_district_name - 营业网点区名称
     */
    public String getYywdDistrictName() {
        return yywdDistrictName;
    }

    /**
     * 设置营业网点区名称
     *
     * @param yywdDistrictName 营业网点区名称
     */
    public void setYywdDistrictName(String yywdDistrictName) {
        this.yywdDistrictName = yywdDistrictName;
    }

    /**
     * 获取发卡充资
     *
     * @return yywd_fkcz - 发卡充资
     */
    public String getYywdFkcz() {
        return yywdFkcz;
    }

    /**
     * 设置发卡充资
     *
     * @param yywdFkcz 发卡充资
     */
    public void setYywdFkcz(String yywdFkcz) {
        this.yywdFkcz = yywdFkcz;
    }

    /**
     * 获取营业网点-退卡退资
     *
     * @return yywd_tktz - 营业网点-退卡退资
     */
    public String getYywdTktz() {
        return yywdTktz;
    }

    /**
     * 设置营业网点-退卡退资
     *
     * @param yywdTktz 营业网点-退卡退资
     */
    public void setYywdTktz(String yywdTktz) {
        this.yywdTktz = yywdTktz;
    }

    /**
     * 获取营业网点-充值
     *
     * @return yywd_cz - 营业网点-充值
     */
    public String getYywdCz() {
        return yywdCz;
    }

    /**
     * 设置营业网点-充值
     *
     * @param yywdCz 营业网点-充值
     */
    public void setYywdCz(String yywdCz) {
        this.yywdCz = yywdCz;
    }
}