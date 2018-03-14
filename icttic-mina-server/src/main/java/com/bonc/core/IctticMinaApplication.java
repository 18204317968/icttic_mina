package com.bonc.core;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;

/**
 * ${DESCRIPTION}
 *
 * @author zs
 * @create 2017-05-25 12:44
 */
//@EnableDiscoveryClient  //激活eureka中的DiscoveryClient实现
//@EnableEurekaClient
//@EnableCircuitBreaker
//@EnableAsync
@SpringBootApplication
@ServletComponentScan("com.bonc.core.config.druid")
//@EnableRedisHttpSession
public class IctticMinaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(IctticMinaApplication.class).web(true).run(args);
    }

    // 用于处理编码问题
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    //处理跨域问题
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowCredentials(true)
                        .allowedHeaders("*")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD");
            }
        };
    }

}
