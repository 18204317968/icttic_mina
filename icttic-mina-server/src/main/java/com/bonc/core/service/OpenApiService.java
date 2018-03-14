package com.bonc.core.service;

import com.bonc.core.entity.MinaBuslines;
import com.bonc.core.entity.MinaHomeYywd;
import com.bonc.core.entity.MinaInterCity;
import com.bonc.core.mapper.MinaBuslinesMapper;
import com.bonc.core.mapper.MinaHomeYywdMapper;
import com.bonc.core.mapper.MinaInterCityMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class OpenApiService {
    @Autowired
    private MinaInterCityMapper minaInterCityMapper;
    @Autowired
    private MinaBuslinesMapper minaBuslinesMapper;
    @Autowired
    private MinaHomeYywdMapper minaHomeYywdMapper;

    public List<MinaHomeYywd>  selectQualificationsByName(String name){
        return this.minaHomeYywdMapper.selectQualificationsByName(name);
    }

    public PageInfo<MinaBuslines> selectInterconnectedBuslines(String cityCode, Integer page, Integer size) {
        PageHelper.startPage(page == null ? 1 : page, size == null ? 10 : size, false);
        List<MinaBuslines> resultList = minaBuslinesMapper.selectInterconnectedBuslinesCityCode(cityCode);
        PageInfo<MinaBuslines> pageInfo = new PageInfo<>(resultList);
        return pageInfo;
    }

    public List<MinaInterCity> selectDiscount(String cityCode){
        return this.minaInterCityMapper.selectDiscount(cityCode);
    }
    public List<MinaInterCity> selectBasicFare(String cityCode){
        return this.minaInterCityMapper.selectBasicFare(cityCode);
    }

    public MinaInterCity selectCardNum(String cityName){

        return this.minaInterCityMapper.selectCardCount(cityName);
    }

    public List<MinaInterCity> selectCity(){

        return minaInterCityMapper.selectCity();
    }
}
