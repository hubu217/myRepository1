package sy.demo2.prox.cglibProxy;

/**
* 需要被代理的类，不需要实现顶层接口
*/


class CglibTestSon {
	
	
	
    public CglibTestSon() {
    	
    }
    
    public void gotoHome() {
        System.out.println("============gotoHome============");
    }
    
    public void gotoSchool() {
        System.out.println("===========gotoSchool============");
    }
    
    public void oneday() {
        gotoHome();
        gotoSchool();
    }
    
    public final void onedayFinal() {
        gotoHome();
        gotoSchool();
    }
}
