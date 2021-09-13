package test.aop.cglibAop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @see cglib代理: 代理类
 * @author asus
 *
 */
public class SafetyCheckCallback implements MethodInterceptor {
	
	
	
	@Override
	public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

			System.out.println("代理类-cglib代理-before safety check.");
			Object result = methodProxy.invokeSuper(o, args);
			System.out.println("代理类-cglib代理-after safety check.");
			return result;
	}
	
	
}