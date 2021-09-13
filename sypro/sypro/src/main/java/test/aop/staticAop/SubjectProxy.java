package test.aop.staticAop;

/**
 * 代理类
 * @author asus
 *
 */
public class SubjectProxy implements ISubject {
	
	
	
	private ISubject target;

	public SubjectProxy(ISubject target) {
		this.target = target;
	}

	
	@Override
	public void request() {
		System.out.println("代理类 before safety check.");
		target.request();
		System.out.println("代理类 after safety check.");
	}


	@Override
	public void request2(String name) {

			System.out.println("代理类 before safety check.");
			target.request2(name);
			System.out.println("代理类 after safety check.");
	}
	
}