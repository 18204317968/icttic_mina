package com.bonc.core.rest;

import com.bonc.core.entity.MinaBuslines;
import com.bonc.core.entity.MinaHomeYywd;
import com.bonc.core.entity.MinaInterCity;
import com.bonc.core.service.MinaBuslinesService;
import com.bonc.core.service.OpenApiService;
import com.github.pagehelper.PageInfo;
//import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.bonc.core.msg.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/openapi")
public class OpenApiController {

    @Autowired
    private OpenApiService openApiService;


    @Value("${oauth2.check.remote.base}")
    private String oauth2BaseUrl;
    @Value("${oauth2.check.remote.access_token_uri}")
    private String oauth2TokenUri;
    /**
     * 自攻自受拿token
     *
     * @return
     */
    @RequestMapping(value = "/getToken", method = RequestMethod.GET)
    public Object getAccessToken(@RequestParam(value = "appKey") String appKey,@RequestParam(value = "appSecret") String appSecret) {

        Map<String, Object> resultMap = new HashMap();

        //创建一个client_credentials类型的客户端对象
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setClientId(appKey);
        details.setClientSecret(appSecret);
        details.setAccessTokenUri(oauth2BaseUrl + oauth2TokenUri);

        //调用OAuth2RestTemplate 获取token
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(details);

        OAuth2AccessToken access_token = restTemplate.getAccessToken();

        resultMap.put("token", access_token.toString());

        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
    /**
     * 查询互联互通线路
     *
     * @param cityCode
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/interconnectedBuslines")
    public ObjectRestResponse<List<MinaBuslines>> interconnectedBuslines(@RequestParam(value = "cityCode") String cityCode,
                                                                         Integer page, Integer size) {
        if(size!=null&&size>20){
            return new ObjectRestResponse<>().failed().msg("size不能大于20");

        }
        try {
            PageInfo<MinaBuslines> buslinesDetails = openApiService.selectInterconnectedBuslines(cityCode, page, size);
            return new ObjectRestResponse<>().success().msg("互联互通线路信息").data(buslinesDetails.getList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ObjectRestResponse<>().failed().msg(e.getMessage());
        }
    }

    /**
     * 互联互通城市
     * @return
     */
    @GetMapping("/queryCity")
    public ObjectRestResponse<List> queryCity(){
        List<MinaInterCity> list = openApiService.selectCity();
        return new ObjectRestResponse<>().success().data(list).msg("互联互通城市");
    }

    /**
     * 某城市发卡量
     * @param cityCode
     * @return
     */
    @GetMapping("/queryCardCount")
    public ObjectRestResponse<List> queryCardCount( @RequestParam(value = "cityCode") String cityCode){
        MinaInterCity m=this.openApiService.selectCardNum(cityCode);
        return new ObjectRestResponse<>().success().data(m).msg(m.getCardCityName()+"的发卡量");

    }

    /**
     * 各地优惠政策
     * @param cityCode
     * @return
     */
    @GetMapping("/queryDiscount")
    public ObjectRestResponse<List> queryDiscount(@RequestParam(value = "cityCode",required = false) String cityCode){
        List<MinaInterCity> list =this.openApiService.selectDiscount(cityCode);
        return new ObjectRestResponse<>().success().data(list).msg("各地优惠政策");

    }

    /**
     * 各地基础票价
     * @param cityCode
     * @return
     */
    @GetMapping("/queryBasicFare")
    public ObjectRestResponse<List> queryBasicFare(@RequestParam(value = "cityCode",required = false) String cityCode){
        List<MinaInterCity> list =this.openApiService.selectBasicFare(cityCode);
        return new ObjectRestResponse<>().success().data(list).msg("各地基准票价");

    }

    /**
     * 互联互通服务网点位置
     * @param name
     * @return
     */
    @GetMapping("/queryQualificationsByName")
    public ObjectRestResponse<List> queryQualificationsByName(@RequestParam(value = "name",required = false) String name){
        List<MinaHomeYywd> list =this.openApiService.selectQualificationsByName(name);
        return new ObjectRestResponse<>().success().data(list).msg("互联互通服务网点位置");

    }
}
