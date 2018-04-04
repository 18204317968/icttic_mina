package com.bonc.core.service;

import com.bonc.core.entity.MinaHomeCarousel;
import com.bonc.core.mapper.MinaHomeCarouselMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页轮播图信息service
 * @author QinZhen
 * @Date 2017/11/22
 */
@Service
public class MinaHomeCarouselService {
    @Autowired
    private MinaHomeCarouselMapper minaHomeCarouselMapper;

    public List getHomeImgUrlList() {
        List<MinaHomeCarousel> minaHomeCarouselList = minaHomeCarouselMapper.selectImgList();
        return minaHomeCarouselList;
    }

    public List selectRealTimeDate() {
        List result = minaHomeCarouselMapper.selectRealTimeDate();
        return result;
        }
}
