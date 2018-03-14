package com.bonc.core.mapper;

import com.bonc.core.entity.MinaBuslines;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface MinaBuslinesMapper extends Mapper<MinaBuslines> {

    Map<String, String> selectNearbyBuslines(@Param("provinceCode") String provinceCode,
                                             @Param("cityName") String cityName,
                                             @Param("buslineName") String buslineName);

    LinkedList<MinaBuslines> selectInterconnectedBuslines(@Param("provinceCode") String provinceCode,
                                                          @Param("cityName") String cityName);
    LinkedList<MinaBuslines> selectInterconnectedBuslinesCityCode(@Param("cityCode") String cityName);

    String selectTotalBuslinesCount(@Param("provinceCode") String provinceCode);

    String selectInterconnectedBuslinesCount(@Param("provinceCode") String provinceCode);

    List<Map<String, String>> selectCmsNodeId();

    List<Map<String, String>> selectCmsInfo(@Param("nodeId") String nodeId);

    List<Map<String, String>> selectCmsInfoDetail(@Param("infoId") String infoId);
}