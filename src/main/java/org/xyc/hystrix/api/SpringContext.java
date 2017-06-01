//package org.xyc.hystrix.api;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Component;
//
///**
// * Created by IntelliJ IDEA.
// * Date: 2017/1/3
// */
//@Component
//public class SpringContext implements ApplicationContextAware{
//
//    private static ApplicationContext applicationContext;
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//
//    public static Object getBean(String id) {
//        try {
//            return applicationContext.getBean(id);
//        } catch (BeansException e) {
//        }
//        return null;
//    }
//
//    public static <T> T getBean(Class<T> clazz) {
//        try {
//            return applicationContext.getBean(clazz);
//        } catch (BeansException e) {
//        }
//        return null;
//    }
//}
