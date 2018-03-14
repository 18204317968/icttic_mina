package com.bonc.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: ZhangShuo
 * @Description: OAUTH2配置类
 * @Date: Created in 17:37 2017/8/10
 * @Modified by:
 */

@Configuration
@EnableResourceServer //通告servlet，现在这个服务器是一个资源服务器
public class OAuth2ResourceServerConfiguration implements ResourceServerConfigurer {

    @Value("${oauth2.check.remote.client_id}")
    private String clientId;
    @Value("${oauth2.check.remote.client_secret}")
    private String clientSecret;
    @Value("${oauth2.check.remote.base}")
    private String oauth2BaseUrl;
    @Value("${oauth2.check.remote.endpoint}")
    private String oauth2EndPoint;
    @Value("${oauth2.skip.urls}")
    private String skipUrls;

    @Value("${oauth2.server.csrf.disable}")
    private Boolean disableCSRF;

    /**
     * 内置一个token服务工厂
     */
    private static class TokenServiceFactory {
        /**
         * 生成一个远程token验证服务
         *
         * @param clientId     客户端id
         * @param clientSecret 客户端密码
         * @param oauth2Url    oauth2的认证地址
         * @return 一个生成的token认证服务
         */
        private static ResourceServerTokenServices remoteTokenService(String clientId, String clientSecret, String oauth2Url) {
            RemoteTokenServices tokenServices = new RemoteTokenServices();
            tokenServices.setClientId(clientId);
            tokenServices.setClientSecret(clientSecret);
            tokenServices.setCheckTokenEndpointUrl(oauth2Url);
            return tokenServices;
        }

        /**
         * 创建一个token服务
         *
         * @param args 每种模式下的不同参数
         * @return
         */
        public static ResourceServerTokenServices create(final Object[] args) {
            return remoteTokenService((String) args[0], (String) args[1], (String) args[2]);
        }
    }

    /**
     * 配置资源服务器的安全配置环境 - 实际上就是配置一个token验证器来验证token
     *
     * @param resources
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        ArrayList<String> args = new ArrayList<>();
        /**
         * 填写客户端id
         */
        args.addAll(Arrays.asList(
                clientId,
                clientSecret,
                String.format("%s/%s", oauth2BaseUrl, oauth2EndPoint)
                )
        );
        /**
         * 设置服务器的token验证服务
         */
        resources.tokenServices(TokenServiceFactory.create(args.toArray()));
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        /**
         * 如果你需要关闭跨站请求防护，将oauth2.server.csrf.disable设置为true。
         * 跨站请求是允许恶意代码展开跨站攻击的原因之一，如果你根本不知道以下代码的真正含义，或只是为了单纯的能让浏览器来用ajax请求后台api
         * 那么我强烈建议你先阅读有关跨站攻击的危害，并在明确你确实需要开启跨站请求的前提下再去设置，否则就不要动它！
         * 有关跨站攻击，读：
         * https://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html
         */
        if (disableCSRF != null && disableCSRF) http.csrf().disable();
        /**
         * 允许所有http请求访问
         * 设置url授权规则
         */
        if (skipUrls != null && !skipUrls.equals("")) {
            if (skipUrls.contains(",")) {
                String[] skipUrl = skipUrls.split(",");
                http.authorizeRequests()
                        .antMatchers(skipUrl).permitAll()
                        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .and().authorizeRequests().anyRequest().authenticated();
            } else {
                http.authorizeRequests()
                        .antMatchers(skipUrls).permitAll()
                        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .and().authorizeRequests().anyRequest().authenticated();
            }
        } else {
            http.authorizeRequests()
                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                    .and().authorizeRequests().anyRequest().authenticated();
        }
    }
}
