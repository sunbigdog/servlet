package com.liu.servlet.tools;

import org.apache.cxf.jaxws.EndpointImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Create By lius on 2020/7/25
 */
public class WebServiceFactory {

    private Map<String, EndpointImpl> endpointMap;

    public WebServiceFactory(){
        endpointMap = new HashMap<>();
    }

    public void setEndpointMap(String key,EndpointImpl value){
        endpointMap.put(key,value);
    }

    public EndpointImpl getValue(String key){
        return endpointMap.get(key);
    }

}
