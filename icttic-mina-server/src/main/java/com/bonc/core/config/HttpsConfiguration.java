package com.bonc.core.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ZhangShuo
 * @Description: Https配置类
 * 默认情况下Spring Boot内嵌的Tomcat服务器会在8080端口启动HTTP服务，Spring Boot允许在application.properties中配置HTTP或HTTPS，
 * 但是不可同时配置，如果两个都启动，至少有一个要以编程的方式配置，Spring Boot官方文档建议在application.properties中配置HTTPS，
 * 因为HTTPS比HTTP更复杂一些，可以参考spring-boot-sample-tomcat-multi-connectors的实例
 * @Date: Created in 16:24 2017/11/23
 * @Modified by:
 */

@Configuration
public class HttpsConfiguration {

    @Value("${tomcat.port}")
    private int tomcatPort;

    @Value("${tomcat.connector}")
    private String tomcatConnector;

    @Value("${server.port}")
    private int httpsPort;

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {

        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {

            @Override
            protected void postProcessContext(Context context) {

                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
        return tomcat;
    }

    private Connector initiateHttpConnector() {

        Connector connector = new Connector(tomcatConnector);
        connector.setScheme("http");
        connector.setPort(tomcatPort);
        connector.setSecure(false);
        connector.setRedirectPort(httpsPort);
        return connector;
    }
}
