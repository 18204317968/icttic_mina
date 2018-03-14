package com.bonc.core.service;

import com.bonc.core.entity.MinaBuslines;
import com.bonc.core.mapper.MinaBuslinesMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.wxiaoqi.security.common.biz.BaseBiz;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公交线路
 *
 * @author zs
 */
@Service
public class MinaBuslinesService extends BaseBiz<MinaBuslinesMapper, MinaBuslines> {

    public Map selectNearbyBuslines(String provinceCode, String cityName, String buslineName) {
        Map result = mapper.selectNearbyBuslines(provinceCode, cityName, buslineName);
        return result;
    }

    public PageInfo<MinaBuslines> selectInterconnectedBuslines(String provinceCode, String cityName, Integer page, Integer size) {
        PageHelper.startPage(page == null ? 1 : page, size == null ? 10 : size, false);
        List<MinaBuslines> resultList = mapper.selectInterconnectedBuslines(provinceCode, cityName);
        PageInfo<MinaBuslines> pageInfo = new PageInfo<>(resultList);
        return pageInfo;
    }



    public Map selectBuslinesCount(String provinceCode) {
        Map resultMap = new HashMap();
        String totalBuslinesCount = mapper.selectTotalBuslinesCount(provinceCode);
        String interconnectedBuslinesCount = mapper.selectInterconnectedBuslinesCount(provinceCode);
        resultMap.put("totalBuslinesCount", totalBuslinesCount);
        resultMap.put("interconnectedBuslinesCount", interconnectedBuslinesCount);
        return resultMap;
    }

}
