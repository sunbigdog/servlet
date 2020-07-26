package com.liu.servlet.controller;

import com.liu.servlet.tools.LiuBeanFactory;
import com.liu.servlet.tools.WebServiceFactory;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create By lius on 2020/7/25
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @PostMapping("/close")
    public void closeService(String beanName){
        WebServiceFactory webServiceFactory = (WebServiceFactory) LiuBeanFactory.getInstance().getBean("wbServiceFactory");
        EndpointImpl endpoint = webServiceFactory.getValue(beanName);
        try{
            endpoint.publish();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
