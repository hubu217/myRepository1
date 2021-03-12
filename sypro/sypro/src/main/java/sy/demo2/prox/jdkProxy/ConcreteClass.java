package sy.demo2.prox.jdkProxy;




/**
* 需要被代理的类，实现了顶层接口，非必须
*/
class ConcreteClass implements JavaProxyInterface {
	
	
	
    @Override
    public void gotoSchool() {
        System.out.println("gotoSchool");
        System.out.println();
    }
    
    @Override
    public void gotoWork() {
        System.out.println("gotoWork");
        System.out.println();
    }
    
    @Override
    public void oneDay() {
        gotoSchool();
        gotoWork();
    }
    
    @Override
    public final void oneDayFinal() {
        gotoSchool();
        gotoWork();
    }
}
