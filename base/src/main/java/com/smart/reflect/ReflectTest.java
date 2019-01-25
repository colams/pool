package com.smart.reflect;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionStoreException;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

public class ReflectTest {
    public void main(String[] args){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    }

    public void loadResource(){
        try {
            String path = "D:/masterSpring/code/chapter4/src/main/resource/conf/file1.txt";
            WritableResource res1 = new PathResource(path);

            Resource res2 = new ClassPathResource("conf/file1.txt");

            // BeanFactory
            // XmlBeanFactory.
            // XmlBeanDefinitionReader
            // XmlBeanDefinitionStoreException
            // DefaultListableBeanFactory
            // AnnotationConfigApplicationContext






        } catch (Exception e){

        }
    }
}
