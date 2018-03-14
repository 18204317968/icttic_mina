package com.bonc.core.mapper;

import com.bonc.core.entity.MinaHomeYywd;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface MinaHomeYywdMapper extends Mapper<MinaHomeYywd> {

    List<MinaHomeYywd> selectQualificationsByName(@Param("name") String name);

    Map<String, String> selectQualifications(@Param("name") String name,
                                             @Param("yywdFkcz") String yywdFkcz,
                                             @Param("yywdTktz") String yywdTktz,
                                             @Param("yywdCz") String yywdCz);

    String selectYywdCount(@Param("provinceCode") String provinceCode,
                           @Param("cityName") String cityName);

    String selectFkczCount(@Param("provinceCode") String provinceCode,
                           @Param("cityName") String cityName);

    String selectTktzCount(@Param("provinceCode") String provinceCode,
                           @Param("cityName") String cityName);

    String selectCzCount(@Param("provinceCode") String provinceCode,
                         @Param("cityName") String cityName);

    List<MinaHomeYywd> selectYywdByPCD(@Param("provinceCode") String provinceCode,
                                       @Param("cityName") String cityName,
                                       @Param("districtName") String districtName,
                                       @Param("yywdFkcz") String yywdFkcz,
                                       @Param("yywdTktz") String yywdTktz,
                                       @Param("yywdCz") String yywdCz);

    List<MinaHomeYywd> selectYywdName(@Param("provinceCode") String provinceCode,
                                      @Param("cityName") String cityName);

    int updateYywdName(@Param("newYywdName") String newYywdName,
                       @Param("location") String location,
                       @Param("yywdImgUrl") String yywdImgUrl,
                       @Param("oldYywdName") String oldYywdName,
                       @Param("provinceCode") String provinceCode,
                       @Param("cityName") String cityName);
}