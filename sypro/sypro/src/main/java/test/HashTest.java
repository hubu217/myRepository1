package test;

import java.util.HashSet;
import java.util.Set;

public class HashTest {
	
	
	

	public final static void main(String[] args) {
		
		HashTest a = new HashTest();
		HashTest b = new HashTest();
		
		a.setI(15);
		b.setI(15);
		
		Set<HashTest> set = new HashSet<HashTest>();
		set.add(a);
		set.add(b);
		
		System.out.println("a-hashcode="+a.hashCode());
		System.out.println("b-hashcode="+b.hashCode());
		
		System.out.println(a.hashCode() == b.hashCode());
		System.out.println(a.equals(b));
		System.out.println(set);
	}
	
	
	
	
	
	
	

	private int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int hashCode() {
		return i % 10;
	}
	
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (object == this) {
			return true;
		}
		if (!(object instanceof HashTest)) {
			return false;
		}
		HashTest other = (HashTest) object;
		if (other.getI() == this.getI()) {
			return true;
		}
		return false;
	}


	
	
	
}
