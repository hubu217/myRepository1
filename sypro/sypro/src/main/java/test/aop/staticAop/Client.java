package test.aop.staticAop;

import org.junit.Test;

/**
 * 目标类
 * @author asus
 *
 */

public class Client {
	
	
	
	@Test
	public void testStaticProxy() {
		ISubject subject = new SubjectImpl();
		ISubject proxy = new SubjectProxy(subject);
		proxy.request();
	}
	
	
	
}