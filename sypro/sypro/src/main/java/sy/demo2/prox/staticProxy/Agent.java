package sy.demo2.prox.staticProxy;



/**
* 代理实现，代理了歌星，唱歌的时候 会先在歌手唱歌之前收钱，然后再唱歌
*/

class Agent implements Singer {
	
	
	
    Star s;
    
    public Agent(Star s) {
        super();
        this.s = s;
    }
    
    
    @Override
    public void sing() {
        System.out.println("在歌手唱歌之前收钱....");
        s.sing();
    }
}
