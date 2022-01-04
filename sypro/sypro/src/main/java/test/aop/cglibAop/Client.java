package test.aop.cglibAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import test.aop.staticAop.ISubject;
import test.aop.staticAop.SubjectImpl;

/**
 * CGLIB动态代理 客户端
 * @author asus
 *
 */

public class Client {
	
	
	
	
	 @Test
	  public void testCglibProxy() {
		     Enhancer enhancer = new Enhancer();
		    enhancer.setSuperclass(Suject.class);
		    Callback callback = new SafetyCheckCallback();
		    enhancer.setCallback(callback);
		    Suject proxy = (Suject) enhancer.create();
		    proxy.request();
	  }
	  
	
	
	}