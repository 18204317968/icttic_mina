package com.bonc.core.service;

import com.bonc.core.entity.MinaCardDisplay;
import com.bonc.core.entity.MinaInterCity;
import com.bonc.core.mapper.MinaCardDisplayMapper;
import com.bonc.core.mapper.MinaInterCityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 交通卡片展示
 * @author QinZhen
 * @Date 2017/11/22
 */
@Service
public class CardDisplayService {

    @Autowired
    private MinaCardDisplayMapper minaCardDisplayMapper;

    @Autowired
    private MinaInterCityMapper minaInterCityMapper;




    //查询全国交通卡
    public List<MinaCardDisplay> selectCards() {
        return minaCardDisplayMapper.selectAllCards();
    }
    //根据省省代码,市名查询交通卡
    public List<MinaCardDisplay> selectCardByPC(String provinceCode,String cityName) {
        List<MinaCardDisplay> list = minaCardDisplayMapper.selectCardByPC(provinceCode,cityName);
        //如果返回结果为0，则根据省代码查
        if(list.size() == 0) {
            list = minaCardDisplayMapper.selectCardByP(provinceCode);
        }
        return list;
    }
    //根据省代码,市名查询交通卡详情
    public List<MinaInterCity> selectInterCity(String provinceCode,String cityName) {
        List<MinaInterCity> list = minaInterCityMapper.selectCardDetail(provinceCode,cityName);
        return list;
    }

    //根据省代码,市名查询城市图片url(province_img_url)
    public List<MinaCardDisplay> selectImgUrl(String provinceCode,String cityName) {
        List<MinaCardDisplay> imgList = minaCardDisplayMapper.selectProvinceImgUrl(provinceCode,cityName);
        return imgList;
    }
}
