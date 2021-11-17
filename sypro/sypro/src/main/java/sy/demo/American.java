package sy.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class American implements IHuman{

	
	
	@Override
	public void chifan() {

		System.out.println("美国人吃饭");
	}

	@Override
	public void shuijiao() {

		System.out.println("美国人睡觉");
	}


	public static void main(String[] args) {

		int x = 1<<4;
		//System.out.println("x="+x);

		Map<String, String> map = new HashMap<String, String>(16);
		System.out.println(1 << 16);

	}

}
