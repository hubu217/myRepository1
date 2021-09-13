package test.aop.jdkAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @see JDK代理类
 * @author asus
 *
 */

public class SafetyInvocationHandler implements InvocationHandler {
	
	
	
	private Object target;

	public SafetyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("JDK代理类 before safety check.");
		
		String methodName = method.getName();
		Class<? extends Method> classed = method.getClass();
		Class<?> declaringClass = method.getDeclaringClass();
		
		Object result = method.invoke(target, args);
		System.out.println("JDK代理类 after safety check.");
		return result;
	}
	
	
}