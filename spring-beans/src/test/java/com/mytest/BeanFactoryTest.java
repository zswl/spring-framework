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
 * ���ڲ���XmlBeanFactory�Ĳ����࣬
 * springԴ��ѧϰ��һ��
 * ѧϰĿ�꣺1.spring��������xml
 * 			2.spring��������bean
 * 			3.spring����ע��bean
 * 			4.spring��������ʵ����bean��
 * Created by zswl on 2015-10-26.
 */
public class BeanFactoryTest {
	@Test
	public void testSimpleLoad() {
		/**
		 * ʹ����Դ·������������xml�ļ�
		 */
		ClassPathResource classPathResource = new ClassPathResource("bean/beanFactoryTest.xml");
		/**
		 * ������Դ����bean����
		 */
		BeanFactory bf = new XmlBeanFactory(classPathResource);
		/**
		 * ʹ��bean����ʵ����bean
		 */
		MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
		/**
		 * Junitִ��ʵ������bean�෽��
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