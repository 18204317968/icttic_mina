package com.bonc.core.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bonc.core.entity.MinaHomeYywd;
import com.bonc.core.mapper.MinaHomeYywdMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.wxiaoqi.security.common.biz.BaseBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 营业网点
 *
 * @author zs
 */
@Service
public class MinaHomeYywdService extends BaseBiz<MinaHomeYywdMapper, MinaHomeYywd> {

    // LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(MinaHomeYywdService.class);

    @Value("${update.yywdName.url}")
    private String updateNameUrl;

    @Value("${amap.key}")
    private String amapKey;

    RestTemplate restTemplate = new RestTemplate();

    public Map selectQualifications(String name, String yywdFkcz, String yywdTktz, String yywdCz) {
        Map<String, String> branchMap = mapper.selectQualifications(name, yywdFkcz, yywdTktz, yywdCz);
        return branchMap;
    }

    public Map selectYywdCount(String provinceCode, String cityName) {
        Map resultMap = new HashMap();
        String yywdsl = mapper.selectYywdCount(provinceCode, cityName);
        String fkczsl = mapper.selectFkczCount(provinceCode, cityName);
        String tktzsl = mapper.selectTktzCount(provinceCode, cityName);
        String czsl = mapper.selectCzCount(provinceCode, cityName);
        resultMap.put("yywdsl", yywdsl);
        resultMap.put("fkczsl", fkczsl);
        resultMap.put("tktzsl", tktzsl);
        resultMap.put("czsl", czsl);
        return resultMap;
    }

    public PageInfo<MinaHomeYywd> selectYywdByPCD(String provinceCode, String cityName, String districtName, String yywdFkcz, String yywdTktz, String yywdCz, Integer page, Integer size) {
        PageHelper.startPage(page == null ? 1 : page, size == null ? 10 : size, false);
        List<MinaHomeYywd> resultList = mapper.selectYywdByPCD(provinceCode, cityName, districtName, yywdFkcz, yywdTktz, yywdCz);
        PageInfo<MinaHomeYywd> pageInfo = new PageInfo<>(resultList);
        return pageInfo;
    }

    public int updateYywdName(String provinceCode, String cityName) {

        int num = 0;

        List<MinaHomeYywd> resultList = mapper.selectYywdName(provinceCode, cityName);

        for (MinaHomeYywd yywdName : resultList) {

            String oldYywdName = yywdName.getYywdName();
            String yywd_district_name = yywdName.getYywdDistrictName();
            //拼接远程调用url
            String remoteUrl = String.format(updateNameUrl, amapKey, oldYywdName, cityName);

            String jsonMessage = restTemplate.getForObject(remoteUrl, String.class);

            JSONObject jsonObject = JSON.parseObject(jsonMessage);

            JSONArray branches = jsonObject.getJSONArray("pois");

            //处理返回结果
            try {
                JSONObject branch = branches.getJSONObject(0);
                String newYywdName = branch.getString("name");
                String location = branch.getString("location");
                String adname = branch.getString("adname");
                if (!oldYywdName.contains("号线")) {
                    if (!adname.equals(yywd_district_name)) {
                        LOGGER.info("[" + oldYywdName + "]结果不匹配，跳过！");
                        continue;
                    }
                }
                JSONArray photos = branch.getJSONArray("photos");
                String yywdImgUrl = photos.size() > 0 ? photos.getJSONObject(0).getString("url") : "";
                int i = mapper.updateYywdName(newYywdName, location, yywdImgUrl, oldYywdName, provinceCode, cityName);
                num += i;
                LOGGER.info("[" + oldYywdName + "]成功修改为[" + newYywdName + "]");
            } catch (IndexOutOfBoundsException e) {
                LOGGER.info("[" + oldYywdName + "]未找到对应结果！");
                continue;
            }
        }

        return num;
    }
}
