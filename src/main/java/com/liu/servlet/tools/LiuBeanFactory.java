package com.liu.servlet.tools;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Create By lius on 2020/7/23
 */
@Service
public class LiuBeanFactory implements ApplicationContextAware {
    private static ApplicationContext context;

    private static LiuBeanFactory factoryInstace;

    public static LiuBeanFactory getInstance() {
        if (null == factoryInstace) {
            factoryInstace = new LiuBeanFactory();
        }
        return factoryInstace;
    }

    private LiuBeanFactory() {
    }

    public Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public <T> T getBean(Class<T> requiredType) {
        return context.getBean(requiredType);
    }

    /**
     * 尝试根据beanName和对象类型加载对象的实例
     *
     * @param beanName     beanName
     * @param requiredType 对象类型
     * @return 对象的实例
     */
    public <T> T getBean(String beanName, Class<T> requiredType) {
        return context.getBean(beanName, requiredType);
    }

    /**
     * 尝试根据对象类型，获取所有对象实例
     *
     * @param type 对象类型
     * @return 指定类型的对象map，key为beanName，value为对象实例
     */
    public <T> Map<String, T> getBeansOfType(Class<T> type) {
        return context.getBeansOfType(type);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LiuBeanFactory.context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
