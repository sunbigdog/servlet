package com.liu.servlet.tools;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import java.net.URL;

/**
 * Create By lius on 2020/7/22
 */
@Component
public class PersonBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //加载jar包
        String path = "D:\\testservlet.jar";
        try {
            URL url = new URL("file:" + path);
            URL[] urls = new URL[]{url};
            //初始化类加载器并加载
            ModuleClassLoader moduleClassLoader = new ModuleClassLoader(urls,classLoader);
            Class cls = moduleClassLoader.loadClass("com.liu.testservlet.ITestService");
            Class implCls = moduleClassLoader.loadClass("com.liu.testservlet.impl.testServiceImpl");

            //注册Bean定义，容器根据定义返回bean
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(implCls);
            BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
            registry.registerBeanDefinition("testServiceImpl", builder.getBeanDefinition());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
