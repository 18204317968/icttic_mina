package com.bonc.core.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZhangShuo
 * @Description:
 * @Date: Created in 17:45 2017/8/15
 * @Modified by:
 */
@RestController
@RequestMapping("/api/bonc")
public class AccessTokenController {

    @Value("${oauth2.check.remote.client_id}")
    private String clientId;
    @Value("${oauth2.check.remote.client_secret}")
    private String clientSecret;
    @Value("${oauth2.check.remote.base}")
    private String oauth2BaseUrl;
    @Value("${oauth2.check.remote.access_token_uri}")
    private String oauth2TokenUri;

    /**
     * 自攻自受拿token
     *
     * @return
     */
    @RequestMapping(value = "/inPursuitOfTreasure", method = RequestMethod.GET)
    public Object getAccessToken() {

        Map<String, Object> resultMap = new HashMap();

        //创建一个client_credentials类型的客户端对象
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(oauth2BaseUrl + oauth2TokenUri);

        //调用OAuth2RestTemplate 获取token
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(details);

        OAuth2AccessToken access_token = restTemplate.getAccessToken();

        resultMap.put("howdoudo", access_token.toString());

        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}
