package sy.demo2.prox.staticProxy;

public class StaticProxy {
	
	
    public static void main(String[] args) {
        Singer singer = new Agent(new Star());
        singer.sing();
    }
}
