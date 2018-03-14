package com.bonc.core.mapper;

import com.bonc.core.entity.MinaCardDisplay;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 交通卡片展示
 * @author qinzhen
 * @date 2017/11/22
 */
public interface MinaCardDisplayMapper extends Mapper<MinaCardDisplay> {
    //查询所有交通卡
    List<MinaCardDisplay> selectAllCards();

    //通过省市名称查询交通卡
    List<MinaCardDisplay> selectCardByPC(@Param("provinceCode") String provinceCode,
                                         @Param("cityName") String cityName);

    //通过省名称查询交通卡
    List<MinaCardDisplay> selectCardByP(@Param(("provinceCode")) String provinceCode);

    //通过省市名称查询城市图片
    List<MinaCardDisplay> selectProvinceImgUrl(@Param("provinceCode") String provinceCode,
                                               @Param("cityName") String cityName);

}