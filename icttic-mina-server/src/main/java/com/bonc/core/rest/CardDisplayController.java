package com.bonc.core.rest;

import com.bonc.core.entity.MinaCardDisplay;
import com.bonc.core.entity.MinaInterCity;
import com.bonc.core.service.CardDisplayService;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 交通卡片展示
 * @author QinZhen
 * @Date 2017/11/22
 */
@RestController
@RequestMapping("/api")
public class CardDisplayController {

    @Autowired
    private CardDisplayService cardDisplayService;

    /**
     * 查询所有交通卡
     * @return
     */
    @GetMapping("/selectCards")
    public ObjectRestResponse<List> selectCards(){
        List<MinaCardDisplay> list = cardDisplayService.selectCards();
        return new ObjectRestResponse<>().rel(true).data(list).msg("互联互通卡片展示");
    }

    /**
     * 根据省代码，市名查单个交通卡
     * @param provinceCode
     * @param cityName
     * @return
     */
    @GetMapping("/selectCardByPC")
    public ObjectRestResponse<List> selectCardByPC(@RequestParam(value = "provinceCode",required = false) String provinceCode,
                                                   @RequestParam(value = "cityName",required = false) String cityName) {
        List<MinaCardDisplay> result = cardDisplayService.selectCardByPC(provinceCode,cityName);
        return new ObjectRestResponse<>().rel(true).data(result).msg("城市交通卡");
    }

    /**
     * 根据省代码，市名查单个交通卡详情
     * @param provinceCode
     * @param cityName
     * @return
     */
    @GetMapping("/selectInterCity")
    public ObjectRestResponse<List> selectInterCity (@RequestParam(value = "provinceCode") String provinceCode,
                                                     @RequestParam(value = "cityName") String cityName) {
        List<MinaInterCity> result = cardDisplayService.selectInterCity(provinceCode,cityName);
        if(result.size() == 0) {
          MinaInterCity m = new MinaInterCity();
            m.setCardCityName(cityName);
            m.setCardProvinceCode(provinceCode);
            result.add(m);
        }
        return new ObjectRestResponse<>().rel(true).data(result).msg("互通城市-交通卡详情");
    }

    /**
     * 根据省代码，市名查交通卡城市图片url
     * @param provinceCode
     * @param cityName
     * @return
     */
    @GetMapping("/selectProvinceImg")
    public ObjectRestResponse<List> selectProvinceImgUrl (@RequestParam(value = "provinceCode") String provinceCode,
                                                       @RequestParam(value = "cityName") String cityName) {
        List<MinaCardDisplay> imgList = cardDisplayService.selectImgUrl(provinceCode, cityName);
        if(imgList.size() == 0) {
            MinaCardDisplay m = new MinaCardDisplay();
            m.setCardCityName(cityName);
            m.setCardProvinceCode(provinceCode);
            imgList.add(m);
        }
        return new ObjectRestResponse<>().rel(true).data(imgList).msg("交通卡所在城市图片");
    }
}
