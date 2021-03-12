package sy.demo2.prox.jdkProxy;

import java.lang.reflect.Proxy;

@SuppressWarnings("restriction")
public class JavaProxyTest {
	
	
	
	public static void main(String[] args) throws Exception {
		
		JavaProxyInterface javaProxyInterface = new ConcreteClass();
		JavaProxyInterface newJavaProxyInterface = (JavaProxyInterface) Proxy.newProxyInstance(JavaProxyTest.class.getClassLoader(), new Class[] { JavaProxyInterface.class },new MyInvocationHandler(javaProxyInterface));
		
		// 这里可以看到这个类以及被代理，在执行方法前会执行aopMethod（）。这里需要注意的是oneDay（）方法和oneDayFinal（）的区别。oneDayFinal的方法aopMethod执行1次，oneDay的aopMethod执行1次
		newJavaProxyInterface.gotoSchool();
		newJavaProxyInterface.gotoWork();
		newJavaProxyInterface.oneDayFinal();
		newJavaProxyInterface.oneDay();
	}
}
