package test.aop.staticAop;

/**
 * 目标类
 * @author asus
 *
 */
public class SubjectImpl implements ISubject {
	
	
	
	
			  @Override
			  public void request() {
			    System.out.println("目标类 request() SubjectImpl.");
			  }
		
			@Override
			public void request2(String name) {
				System.out.println("目标类 request2(带参数) SubjectImpl. 参数="+name);
			}
	  
	  
	}