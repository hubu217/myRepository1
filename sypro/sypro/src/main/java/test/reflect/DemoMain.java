package test.reflect;

import java.net.URL;

public class DemoMain {
	
	
	
	
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

				Show2();
		}
	
	
	
	
	
	/**
	 * @ClassName: Main
	 * @Description:
	 * @author adamjwh
	 * @date 2018年5月28日
	 *
	 */


	   
	    

	/**
	 * @see  JAVA中 绝对路径问题 和相对路径问题
	 * @throws Exception
	 */
	public static void Show3() throws Exception {
	        	
		URL url = DemoMain.class.getResource("/masmgc.sdk.sms-0.0.1-SNAPSHOT.jar");
		System.out.println("url="+url);
	        	
	 }
	
	
	
	/**
	 * @see 反射类的成员属性 和成员方法
	 * @throws Exception
	 */
	public static void Show2() throws Exception {
		
		String jar = "libs/masmgc.sdk.sms-0.0.1-SNAPSHOT.jar";
		
		
		ReflexDemo.getJar(jar);
		
	}
	

	public static void Show1() throws Exception {
		Customer customer = new Customer();
		customer.setId(10L);
		customer.setName("adam");
		customer.setAge(3);
		
		ReflectTester rt = new ReflectTester();
		Object object = rt.copy(customer);
		System.out.println("object="+object);
	}
	
	
	
	
	

}
