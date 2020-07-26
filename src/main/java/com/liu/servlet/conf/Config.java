package com.liu.servlet.conf;

import com.liu.servlet.tools.LiuBeanFactory;
import com.liu.servlet.tools.WebServiceFactory;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource("classpath:META-INF/spring.xml")
public class Config {

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus(){
        return new SpringBus();
    }

    /*@Bean
    public Endpoint testEndPoint(){
        Object o = LiuBeanFactory.getInstance().getBean("testServiceImpl");

        EndpointImpl endpoint = new EndpointImpl(springBus(),o);
        endpoint.publish("/testWebService");
        return endpoint;
    }*/

    @Bean("wbServiceFactory")
    public WebServiceFactory getWebServiceFactory(){
        WebServiceFactory wsf = new WebServiceFactory();
        Object o = LiuBeanFactory.getInstance().getBean("testServiceImpl");
        EndpointImpl endpoint = new EndpointImpl(springBus(),o);
        endpoint.publish("/testWebService");
        wsf.setEndpointMap("testServiceImpl",endpoint);
        return wsf;
    }

}