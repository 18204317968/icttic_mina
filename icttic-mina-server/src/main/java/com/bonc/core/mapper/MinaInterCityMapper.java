package com.bonc.core.mapper;

import com.bonc.core.entity.MinaInterCity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface MinaInterCityMapper extends Mapper<MinaInterCity> {

    List<MinaInterCity> selectDiscount(@Param("cityCode") String cityCode);
    List<MinaInterCity> selectBasicFare(@Param("cityCode") String cityCode);

    MinaInterCity selectCardCount(@Param("cityName") String cityName);
    List<MinaInterCity> selectCity();
    //通过省市名称查询交通卡详情
    List<MinaInterCity> selectCardDetail(@Param("provinceCode") String provinceCode,
                                         @Param("cityName") String cityName);
}