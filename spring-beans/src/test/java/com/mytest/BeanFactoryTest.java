package com.mytest;

import com.mytest.bean.MyTestBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import static org.junit.Assert.assertEquals;

/**
 * 用于测试XmlBeanFactory的测试类，
 * spring源码学习第一步
 * 学习目标：1.spring怎样加载xml
 * 			2.spring怎样解析bean
 * 			3.spring怎样注册bean
 * 			4.spring怎样反射实例化bean类
 * Created by zswl on 2015-10-26.
 */
public class BeanFactoryTest {
	@Test
	public void testSimpleLoad() {
		/**
		 * 使用资源路径加载器加载xml文件
		 */
		ClassPathResource classPathResource = new ClassPathResource("bean/beanFactoryTest.xml");
		/**
		 * 根据资源创建bean工厂
		 */
		BeanFactory bf = new XmlBeanFactory(classPathResource);
		/**
		 * 使用bean反射实例化bean
		 */
		MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
		/**
		 * Junit执行实例化的bean类方法
		 */
		assertEquals("testStr", bean.getTestStr());
	}

	@Test
	public void testDefaultListableBeanFactory(){
		ClassPathResource classPathResource = new ClassPathResource("bean/beanFactoryTest.xml");
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
		MyTestBean myTestBean = (MyTestBean)defaultListableBeanFactory.getBean("myTestBean");
		System.out.println(myTestBean.getTestStr());
	}


}