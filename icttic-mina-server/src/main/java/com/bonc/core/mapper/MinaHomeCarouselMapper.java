package com.bonc.core.mapper;

import com.bonc.core.entity.MinaHomeCarousel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 首页轮播图Mapper
 * @author qinzhen
 * @Date 2017/11/22
 */
public interface MinaHomeCarouselMapper extends Mapper<MinaHomeCarousel> {

    /**
     * 查询轮播图url信息
     * @return
     */
    List<MinaHomeCarousel> selectImgList();

}