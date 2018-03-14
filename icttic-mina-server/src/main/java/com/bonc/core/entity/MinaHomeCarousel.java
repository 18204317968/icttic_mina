package com.bonc.core.entity;

import javax.persistence.*;

/**
 * 首页轮播图信息
 * @author qinzhen
 * @date 2017/11/22
 */
@Table(name = "mina_home_carousel")
public class MinaHomeCarousel {
    /**
     * 图片id
     */
    @Id
    @Column(name = "img_id")
    private Integer imgId;

    /**
     * 图片名称
     */
    @Column(name = "img_name")
    private String imgName;

    /**
     * 图片链接
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 图片使用状态
     */
    @Column(name = "img_state")
    private String imgState;

    /**
     * 获取图片id
     *
     * @return img_id - 图片id
     */
    public Integer getImgId() {
        return imgId;
    }

    /**
     * 设置图片id
     *
     * @param imgId 图片id
     */
    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    /**
     * 获取图片名称
     *
     * @return img_name - 图片名称
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * 设置图片名称
     *
     * @param imgName 图片名称
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    /**
     * 获取图片链接
     *
     * @return img_url - 图片链接
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置图片链接
     *
     * @param imgUrl 图片链接
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 获取图片使用状态
     *
     * @return img_state - 图片使用状态
     */
    public String getImgState() {
        return imgState;
    }

    /**
     * 设置图片使用状态
     *
     * @param imgState 图片使用状态
     */
    public void setImgState(String imgState) {
        this.imgState = imgState;
    }
}