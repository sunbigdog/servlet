package com.liu.servlet.service;

import org.springframework.stereotype.Service;

/**
 * Create By lius on 2020/7/25
 */
@Service
public class TestService {

    public void sayHello(){
        System.out.println("Hello!");
    }

    public void closeService(String publishName){
        System.out.println(publishName);
    }

}
