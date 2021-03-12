package sy.demo2.prox.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
* InvocationHandler 的一个实现，实际上处理代理的逻辑在这里
*/
class MyInvocationHandler implements InvocationHandler {
	
	
	
    JavaProxyInterface javaProxy;
    
    public MyInvocationHandler(JavaProxyInterface javaProxy) {
        this.javaProxy = javaProxy;
    }
    
    private void aopMethod() {
        System.out.println("before method");
    }
    
	//继承方法，代理时实际执行的犯法，如果要实现原方法，则需要调用method.invoke(javaProxy, args)，这里还调用了一个aopMethod(),可以类比于Spring中的切面before注解。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        aopMethod();
        return method.invoke(javaProxy, args);
    }
}
