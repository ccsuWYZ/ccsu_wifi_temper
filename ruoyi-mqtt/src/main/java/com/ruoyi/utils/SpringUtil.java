package com.ruoyi.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

/**
 * @author lee
 * @date 2022-11-15 15:52:10
 * @description
 */
@Component
public class SpringUtil extends ApplicationObjectSupport {
    public static ApplicationContext context;

    public static Object getBean(String serviceName){
        return context.getBean(serviceName);
    }

    @Override
    protected void initApplicationContext(ApplicationContext context) throws BeansException {
        super.initApplicationContext(context);
        SpringUtil.context = context;
    }
}

