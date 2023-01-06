package com.spring.xml_based_config.bean_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.LinkedList;
import java.util.List;

public class CustomBeanPostProcessor implements BeanPostProcessor, BeanFactoryAware, DisposableBean {

    private BeanFactory beanFactory;

    private List<Object> prototypeBeans = new LinkedList<>();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // after start up, keeps track of the prototype scoped beans.
        // we will need to know who they are for later destruction
        if(beanFactory.isPrototype(beanName)) {
            synchronized (prototypeBeans) {
                prototypeBeans.add(bean);
            }
        }
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void destroy() throws Exception {

        // loop through the prototype beans and call the destroy() method on each one
        synchronized (prototypeBeans) {
            for(Object bean : prototypeBeans) {
                if(bean instanceof DisposableBean) {
                    DisposableBean disposableBean = (DisposableBean) bean;
                    try {
                        disposableBean.destroy();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            prototypeBeans.clear();
        }
    }
}
