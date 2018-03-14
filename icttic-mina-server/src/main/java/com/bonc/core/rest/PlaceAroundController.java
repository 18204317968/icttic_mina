package com.bonc.core.rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bonc.core.entity.MinaBuslines;
import com.bonc.core.entity.MinaHomeYywd;
import com.bonc.core.service.MinaBuslinesService;
import com.bonc.core.service.MinaHomeYywdService;
import com.github.pagehelper.PageInfo;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;


/**
 * @Author: ZhangShuo
 * @Description: 周边搜索Controller
 * @Date: Created in 15:09 2017/11/22
 * @Modified by:
 */
@RestController
@RequestMapping("/api")
public class PlaceAroundController {

    // LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceAroundController.class);

    @Value("${place.around.url}")
    private String placeAroundUrl;

    @Value("${amap.key}")
    private String amapKey;

    @Value("${onecard.keyword}")
    private String oneCard;

    @Value("${busline.keyword}")
    private String buslineKeyword;

    @Value("${busline.type}")
    private String buslineType;

    @Autowired
    MinaHomeYywdService minaHomeYywdService;

    @Autowired
    MinaBuslinesService minaBuslinesService;

    /**
     * 一卡通搜索
     *
     * @param location 自身坐标
     * @param radius   搜索半径
     * @return
     */
    @GetMapping(value = "/oneCardSearch")
    public ObjectRestResponse<List> oneCardSearch(@RequestParam(value = "location") String location,
                                                  @RequestParam(value = "radius", required = false) String radius,
                                                  @RequestParam(value = "yywdFkcz", required = false) String yywdFkcz,
                                                  @RequestParam(value = "yywdTktz", required = false) String yywdTktz,
                                                  @RequestParam(value = "yywdCz", required = false) String yywdCz,
                                                  @RequestParam(value = "page", required = false) String page,
                                                  @RequestParam(value = "size", required = false) String size) {

        List resultList = new ArrayList();

        JSONObject onecardJson = rpc(placeAroundUrl, amapKey, location, oneCard, "", radius, size, page);

        JSONArray branches = onecardJson.getJSONArray("pois");

        //处理返回结果
        for (int i = 0; i < branches.size(); i++) {
            JSONObject branch = branches.getJSONObject(i);
            String branchName = branch.getString("name");
            String distance = branch.getString("distance");
            //比对数据库
            Map resultMap = minaHomeYywdService.selectQualifications(branchName, yywdFkcz, yywdTktz, yywdCz);
            //如果结果为空，将json中的数据放到结果中
            if (resultMap == null) {
                resultMap = new HashMap();
                String yywd_location = branch.getString("location");
                JSONArray photos = branch.getJSONArray("photos");
                String yywd_img_url = photos.size() > 0 ? photos.getJSONObject(0).getString("url") : "";
                resultMap.put("yywdName", branchName);
                resultMap.put("yywdLocation", yywd_location);
                resultMap.put("yywdImgUrl", yywd_img_url);
                resultMap.put("yywdCz", "1");
                if (branchName.contains("地铁站")) {
                    resultMap.put("yywdFkcz", "1");
                } else if (branchName.contains("发卡/充值")) {
                    resultMap.put("yywdFkcz", "1");
                } else resultMap.put("yywdFkcz", "0");
                resultMap.put("yywdTktz", "0");
                if (!yywdFkcz.equals("") && !yywdFkcz.equals("0")) {
                    String flag = (String) resultMap.get("yywdFkcz");
                    if (!yywdFkcz.equals(flag)) {
                        continue;
                    }
                }
                if (!yywdTktz.equals("") && !yywdTktz.equals("0")) {
                    String flag = (String) resultMap.get("yywdTktz");
                    if (!yywdTktz.equals(flag)) {
                        continue;
                    }
                }
                if (!yywdCz.equals("") && !yywdCz.equals("0")) {
                    String flag = (String) resultMap.get("yywdCz");
                    if (!yywdCz.equals(flag)) {
                        continue;
                    }
                }
            }
            resultMap.put("distance", distance);
            resultList.add(resultMap);
        }

        return new ObjectRestResponse<>().data(resultList).rel(true).msg("您附近的营业网点");
    }

    /**
     * 根据省或直辖市名字查询网点总数
     *
     * @param provinceCode
     * @param cityName
     * @return
     */
    @GetMapping(value = "/selectYywdCount")
    public ObjectRestResponse<Map> selectYywdCount(@RequestParam(value = "provinceCode") String provinceCode,
                                                   @RequestParam(value = "cityName") String cityName) {

        Map resultMap = minaHomeYywdService.selectYywdCount(provinceCode, cityName);

        return new ObjectRestResponse<>().data(resultMap).rel(true).msg("各营业网点数量");
    }

    /**
     * 查询公交线路数量
     *
     * @param provinceCode
     * @return
     */
    @GetMapping(value = "/selectBuslinesCount")
    public ObjectRestResponse<Map> selectBuslinesCount(@RequestParam(value = "provinceCode") String provinceCode) {

        Map resultMap = minaBuslinesService.selectBuslinesCount(provinceCode);

        return new ObjectRestResponse<>().data(resultMap).rel(true).msg("公交线路数量");
    }

    /**
     * 根据省code市name查询网点信息
     *
     * @param provinceCode
     * @param cityName
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/selectYywdByPCD")
    public ObjectRestResponse<List<MinaHomeYywd>> selectYywdByPCD(@RequestParam(value = "provinceCode") String provinceCode,
                                                                  @RequestParam(value = "cityName") String cityName,
                                                                  @RequestParam(value = "districtName", required = false) String districtName,
                                                                  @RequestParam(value = "yywdFkcz", required = false) String yywdFkcz,
                                                                  @RequestParam(value = "yywdTktz", required = false) String yywdTktz,
                                                                  @RequestParam(value = "yywdCz", required = false) String yywdCz,
                                                                  Integer page, Integer size) {
        try {
            PageInfo<MinaHomeYywd> yywdDetails = minaHomeYywdService.selectYywdByPCD(provinceCode, cityName, districtName, yywdFkcz, yywdTktz, yywdCz, page, size);
            return new ObjectRestResponse<>().rel(true).data(yywdDetails).msg("各区域网点信息");
        } catch (Exception e) {
            e.printStackTrace();
            return new ObjectRestResponse<>().rel(false).msg(e.getMessage());
        }
    }

    /**
     * 获取附近公交线路的详细信息
     *
     * @param location     自身坐标
     * @param radius       搜索半径
     * @param page         页数
     * @param size         个数
     * @param provinceCode 省代码
     * @param cityName     市名字
     * @return
     */
    @GetMapping(value = "/nearbyBuslines")
    public ObjectRestResponse<List> nearbyBuslines(@RequestParam(value = "location") String location,
                                                   @RequestParam(value = "radius", required = false) String radius,
                                                   @RequestParam(value = "page", required = false) String page,
                                                   @RequestParam(value = "size", required = false) String size,
                                                   @RequestParam(value = "provinceCode") String provinceCode,
                                                   @RequestParam(value = "cityName") String cityName) {

        List resultList = new ArrayList();
        Set<String> buslineSet = new HashSet();

        JSONObject buslineJson = rpc(placeAroundUrl, amapKey, location, buslineKeyword, buslineType, radius, size, page);

        JSONArray branches = buslineJson.getJSONArray("pois");

        //处理返回结果 获得公交线路集合
        for (int i = 0; i < branches.size(); i++) {
            JSONObject branch = branches.getJSONObject(i);
            String address = branch.getString("address");
            String[] buslines = address.split(";");
            for (String busline : buslines) {
                buslineSet.add(busline);
            }
        }

        //根据每个线路名获得线路详细信息
        for (String buslineName : buslineSet) {
            Map buslineMap = minaBuslinesService.selectNearbyBuslines(provinceCode, cityName, buslineName);
            if (buslineMap != null)
                resultList.add(buslineMap);
            else {
                Map tempMap = new HashMap();
                tempMap.put("busline_name", buslineName);
                tempMap.put("first_front_name", "");
                tempMap.put("first_terminal_name", "");
                tempMap.put("first_start_time", "");
                tempMap.put("first_end_time", "");
                tempMap.put("second_front_name", "");
                tempMap.put("second_terminal_name", "");
                tempMap.put("second_start_time", "");
                tempMap.put("second_end_time", "");
                resultList.add(tempMap);
            }
        }

        return new ObjectRestResponse<>().data(resultList).rel(true).msg("您附近的公交线路");
    }

    /**
     * 查询互联互通线路
     *
     * @param provinceCode
     * @param cityName
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/interconnectedBuslines")
    public ObjectRestResponse<List<MinaBuslines>> interconnectedBuslines(@RequestParam(value = "provinceCode") String provinceCode,
                                                                         @RequestParam(value = "cityName") String cityName,
                                                                         Integer page, Integer size) {
        try {
            PageInfo<MinaBuslines> buslinesDetails = minaBuslinesService.selectInterconnectedBuslines(provinceCode, cityName, page, size);
            return new ObjectRestResponse<>().rel(true).data(buslinesDetails).msg("互联互通线路信息");
        } catch (Exception e) {
            e.printStackTrace();
            return new ObjectRestResponse<>().rel(false).msg(e.getMessage());
        }
    }

    /**
     * 封装远程调用方法
     *
     * @param templateUrl 模版url
     * @param key         高德地图开发者key
     * @param location    坐标
     * @param keyword     关键词
     * @param type        类型
     * @param radius      搜索半径 默认2公里
     * @param size        每页个数 默认25个
     * @param page        第几页 默认第一页
     * @return
     */
    private JSONObject rpc(String templateUrl, String key, String location, String keyword, String type, String radius, String size, String page) {

        radius = radius == null ? "2000" : radius;
        page = page == null ? "1" : page;
        size = size == null ? "25" : size;

        //拼接远程调用url
        String remoteUrl = String.format(templateUrl, key, location, keyword, type, radius, size, page);

        RestTemplate restTemplate = new RestTemplate();

        String jsonMessage = restTemplate.getForObject(remoteUrl, String.class);

        JSONObject jsonObject = JSON.parseObject(jsonMessage);

        return jsonObject;
    }
}
