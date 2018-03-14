//package com.bonc.core.config;
//
///**
// * ${DESCRIPTION}
// *
// * @author wanghaobin
// * @create 2017-06-01 8:12
// */
//
//import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//
////@Configuration
//public class HystrixConfig {
//
////    @Bean
//    public HystrixMetricsStreamServlet hystrixMetricsStreamServlet(){
//        return new HystrixMetricsStreamServlet();
//    }
//
////    @Bean
//    public ServletRegistrationBean registration(HystrixMetricsStreamServlet servlet){
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
//        registrationBean.setServlet(servlet);
//        registrationBean.setEnabled(true);//是否启用该registrationBean
//        registrationBean.addUrlMappings("/hystrix.stream");
//        return registrationBean;
//    }
//}
