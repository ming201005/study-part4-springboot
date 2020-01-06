package com.springboot.demo01.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 描述：手工获取bean
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-13 11:49
 * @see
 */
@Component
public class CallBean implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext=applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

}
