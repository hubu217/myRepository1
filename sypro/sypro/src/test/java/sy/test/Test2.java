package sy.test;

import java.util.regex.Pattern;

public class Test2 {

	
	
	public static void main(String[] args) {





		
		
		String str="AI2133132TETEST123ABCGQ";
		System.out.println(Pattern.matches("[^a-z]*",str));
		
		
		boolean flag = str.matches("^[A-Z0-9]+$");
		System.out.println("flag="+flag);
	}
}
