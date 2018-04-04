package com.bonc.core.rest;

import com.bonc.core.entity.MinaHomeCarousel;
import com.bonc.core.service.MinaHomeCarouselService;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页轮播图信息controller
 * @author QinZhen
 * @Date 2017/11/22
 */
@RestController
@RequestMapping("/api")
public class MinaHomeCarouselController {

    @Autowired
    private MinaHomeCarouselService minaHomeCarouselService;

    /**
     * 轮播图url查询
     * @return url 的 List
     */
    @RequestMapping(value = "/imgUrl",method = RequestMethod.GET)
    public ObjectRestResponse<List> findImgUrl() {
        List<MinaHomeCarousel> imgList = minaHomeCarouselService.getHomeImgUrlList();
        return new ObjectRestResponse<>().rel(true).data(imgList).msg("mina_home_carousel");
    }

    @RequestMapping(value = "/realTimeDate",method = RequestMethod.GET)
    public ObjectRestResponse<List> selectRealTimeDate() {
        try {
            List result = minaHomeCarouselService.selectRealTimeDate();
            return new ObjectRestResponse<>().data(result).rel(true).msg("实时数据");
        } catch (Exception e) {
            e.printStackTrace();
            return new ObjectRestResponse<>().rel(false).msg(e.getMessage());
        }
    }

}
