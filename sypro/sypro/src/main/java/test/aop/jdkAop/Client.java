package test.aop.jdkAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

import test.aop.staticAop.ISubject;
import test.aop.staticAop.SubjectImpl;

/**
 * JDK动态代理 客户端
 * @author asus
 *
 */

public class Client {
	
	
	
	  @Test
	  public void testDynamicProxy() {
		  
	    ISubject subject = new SubjectImpl();
	    
	    ClassLoader loader = Client.class.getClassLoader(); 
        Class<?>[] interfaces = new Class[]{ISubject.class};
        InvocationHandler h = new SafetyInvocationHandler(subject);
	    ISubject proxySubject = (ISubject) Proxy.newProxyInstance(loader, interfaces, h);
	    //proxySubject.request();
	    
	    proxySubject.request2("参数啊");
	   
	  }
	}