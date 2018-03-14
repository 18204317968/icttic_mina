package com.bonc.core.entity;

import javax.persistence.*;

@Table(name = "mina_buslines")
public class MinaBuslines {
    private String id;

    /**
     * 公交线路名称
     */
    @Column(name = "busline_name")
    private String buslineName;

    /**
     * 第一个起始站站名
     */
    @Column(name = "first_front_name")
    private String firstFrontName;

    /**
     * 第一个终点站站名
     */
    @Column(name = "first_terminal_name")
    private String firstTerminalName;

    /**
     * 第一个首车时间
     */
    @Column(name = "first_start_time")
    private String firstStartTime;

    /**
     * 第一个末车时间
     */
    @Column(name = "first_end_time")
    private String firstEndTime;

    /**
     * 第二个始发站
     */
    @Column(name = "second_front_name")
    private String secondFrontName;

    /**
     * 第二个终点站
     */
    @Column(name = "second_terminal_name")
    private String secondTerminalName;

    /**
     * 第二个首车时间
     */
    @Column(name = "second_start_time")
    private String secondStartTime;

    /**
     * 第一个末车时间
     */
    @Column(name = "second_end_time")
    private String secondEndTime;

    /**
     * 公交线路省代码
     */
    @Column(name = "busline_province_code")
    private String buslineProvinceCode;

    /**
     * 公交线路省名称
     */
    @Column(name = "busline_province_name")
    private String buslineProvinceName;

    /**
     * 公交线路市代码
     */
    @Column(name = "busline_city_code")
    private String buslineCityCode;

    /**
     * 公交线路市名称
     */
    @Column(name = "busline_city_name")
    private String buslineCityName;

    /**
     * 是否互联互通(0不通,1通)
     */
    private String interconnected;

    /**
     * 长度
     */
    private String length;

    /**
     * 站点
     */
    private Object stations;

    /**
     * 所属公司
     */
    private String company;

    /**
     * 基本价格
     */
    @Column(name = "basic_price")
    private String basicPrice;

    /**
     * 总体价格
     */
    @Column(name = "total_price")
    private String totalPrice;

    /**
     * x坐标群
     */
    private String xs;

    /**
     * y坐标群
     */
    private String ys;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取公交线路名称
     *
     * @return busline_name - 公交线路名称
     */
    public String getBuslineName() {
        return buslineName;
    }

    /**
     * 设置公交线路名称
     *
     * @param buslineName 公交线路名称
     */
    public void setBuslineName(String buslineName) {
        this.buslineName = buslineName;
    }

    /**
     * 获取第一个起始站站名
     *
     * @return first_front_name - 第一个起始站站名
     */
    public String getFirstFrontName() {
        return firstFrontName;
    }

    /**
     * 设置第一个起始站站名
     *
     * @param firstFrontName 第一个起始站站名
     */
    public void setFirstFrontName(String firstFrontName) {
        this.firstFrontName = firstFrontName;
    }

    /**
     * 获取第一个终点站站名
     *
     * @return first_terminal_name - 第一个终点站站名
     */
    public String getFirstTerminalName() {
        return firstTerminalName;
    }

    /**
     * 设置第一个终点站站名
     *
     * @param firstTerminalName 第一个终点站站名
     */
    public void setFirstTerminalName(String firstTerminalName) {
        this.firstTerminalName = firstTerminalName;
    }

    /**
     * 获取第一个首车时间
     *
     * @return first_start_time - 第一个首车时间
     */
    public String getFirstStartTime() {
        return firstStartTime;
    }

    /**
     * 设置第一个首车时间
     *
     * @param firstStartTime 第一个首车时间
     */
    public void setFirstStartTime(String firstStartTime) {
        this.firstStartTime = firstStartTime;
    }

    /**
     * 获取第一个末车时间
     *
     * @return first_end_time - 第一个末车时间
     */
    public String getFirstEndTime() {
        return firstEndTime;
    }

    /**
     * 设置第一个末车时间
     *
     * @param firstEndTime 第一个末车时间
     */
    public void setFirstEndTime(String firstEndTime) {
        this.firstEndTime = firstEndTime;
    }

    /**
     * 获取第二个始发站
     *
     * @return second_front_name - 第二个始发站
     */
    public String getSecondFrontName() {
        return secondFrontName;
    }

    /**
     * 设置第二个始发站
     *
     * @param secondFrontName 第二个始发站
     */
    public void setSecondFrontName(String secondFrontName) {
        this.secondFrontName = secondFrontName;
    }

    /**
     * 获取第二个终点站
     *
     * @return second_terminal_name - 第二个终点站
     */
    public String getSecondTerminalName() {
        return secondTerminalName;
    }

    /**
     * 设置第二个终点站
     *
     * @param secondTerminalName 第二个终点站
     */
    public void setSecondTerminalName(String secondTerminalName) {
        this.secondTerminalName = secondTerminalName;
    }

    /**
     * 获取第二个首车时间
     *
     * @return second_start_time - 第二个首车时间
     */
    public String getSecondStartTime() {
        return secondStartTime;
    }

    /**
     * 设置第二个首车时间
     *
     * @param secondStartTime 第二个首车时间
     */
    public void setSecondStartTime(String secondStartTime) {
        this.secondStartTime = secondStartTime;
    }

    /**
     * 获取第一个末车时间
     *
     * @return second_end_time - 第一个末车时间
     */
    public String getSecondEndTime() {
        return secondEndTime;
    }

    /**
     * 设置第一个末车时间
     *
     * @param secondEndTime 第一个末车时间
     */
    public void setSecondEndTime(String secondEndTime) {
        this.secondEndTime = secondEndTime;
    }

    /**
     * 获取公交线路省代码
     *
     * @return busline_province_code - 公交线路省代码
     */
    public String getBuslineProvinceCode() {
        return buslineProvinceCode;
    }

    /**
     * 设置公交线路省代码
     *
     * @param buslineProvinceCode 公交线路省代码
     */
    public void setBuslineProvinceCode(String buslineProvinceCode) {
        this.buslineProvinceCode = buslineProvinceCode;
    }

    /**
     * 获取公交线路省名称
     *
     * @return busline_province_name - 公交线路省名称
     */
    public String getBuslineProvinceName() {
        return buslineProvinceName;
    }

    /**
     * 设置公交线路省名称
     *
     * @param buslineProvinceName 公交线路省名称
     */
    public void setBuslineProvinceName(String buslineProvinceName) {
        this.buslineProvinceName = buslineProvinceName;
    }

    /**
     * 获取公交线路市代码
     *
     * @return busline_city_code - 公交线路市代码
     */
    public String getBuslineCityCode() {
        return buslineCityCode;
    }

    /**
     * 设置公交线路市代码
     *
     * @param buslineCityCode 公交线路市代码
     */
    public void setBuslineCityCode(String buslineCityCode) {
        this.buslineCityCode = buslineCityCode;
    }

    /**
     * 获取公交线路市名称
     *
     * @return busline_city_name - 公交线路市名称
     */
    public String getBuslineCityName() {
        return buslineCityName;
    }

    /**
     * 设置公交线路市名称
     *
     * @param buslineCityName 公交线路市名称
     */
    public void setBuslineCityName(String buslineCityName) {
        this.buslineCityName = buslineCityName;
    }

    /**
     * 获取是否互联互通(0不通,1通)
     *
     * @return interconnected - 是否互联互通(0不通,1通)
     */
    public String getInterconnected() {
        return interconnected;
    }

    /**
     * 设置是否互联互通(0不通,1通)
     *
     * @param interconnected 是否互联互通(0不通,1通)
     */
    public void setInterconnected(String interconnected) {
        this.interconnected = interconnected;
    }

    /**
     * 获取长度
     *
     * @return length - 长度
     */
    public String getLength() {
        return length;
    }

    /**
     * 设置长度
     *
     * @param length 长度
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * 获取站点
     *
     * @return stations - 站点
     */
    public Object getStations() {
        return stations;
    }

    /**
     * 设置站点
     *
     * @param stations 站点
     */
    public void setStations(Object stations) {
        this.stations = stations;
    }

    /**
     * 获取所属公司
     *
     * @return company - 所属公司
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置所属公司
     *
     * @param company 所属公司
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取基本价格
     *
     * @return basic_price - 基本价格
     */
    public String getBasicPrice() {
        return basicPrice;
    }

    /**
     * 设置基本价格
     *
     * @param basicPrice 基本价格
     */
    public void setBasicPrice(String basicPrice) {
        this.basicPrice = basicPrice;
    }

    /**
     * 获取总体价格
     *
     * @return total_price - 总体价格
     */
    public String getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置总体价格
     *
     * @param totalPrice 总体价格
     */
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取x坐标群
     *
     * @return xs - x坐标群
     */
    public String getXs() {
        return xs;
    }

    /**
     * 设置x坐标群
     *
     * @param xs x坐标群
     */
    public void setXs(String xs) {
        this.xs = xs;
    }

    /**
     * 获取y坐标群
     *
     * @return ys - y坐标群
     */
    public String getYs() {
        return ys;
    }

    /**
     * 设置y坐标群
     *
     * @param ys y坐标群
     */
    public void setYs(String ys) {
        this.ys = ys;
    }
}