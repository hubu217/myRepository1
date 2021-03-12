package sy.demo2.prox.cglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
* 可以类比于jdk动态代理中的InvocationHandler ，实际上被代理后重要的类，实际上后续执行的就是intercept里的方法，如果需要执行原来的方法，则调用 method.invoke(s, args);这里也加了一个aopMethod();
*/
class MthdInvoker implements MethodInterceptor {
	
	
	
    private CglibTestSon s;
    
    public MthdInvoker(CglibTestSon s) {
        this.s = s;
    }
    
    private void aopMethod() {
        System.out.println("i am aopMethod");
    }
    
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        aopMethod();
        Object a = method.invoke(s, args);
        return a;
    }
}
