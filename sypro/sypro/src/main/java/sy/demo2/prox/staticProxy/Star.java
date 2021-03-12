package sy.demo2.prox.staticProxy;



/**
* 真实实现，一个歌星
*/



class Star implements Singer {
	
	
	
    @Override
    public void sing() {
        System.out.println("Star Singing~~~");
    }
}
