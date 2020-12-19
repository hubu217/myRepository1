package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class People {
 
	private String name;
	private String idCard;
	private String phoneNumber;
	
	
	public People(String name, String idCard, String phoneNumber) {
		super();
		this.name = name;
		this.idCard = idCard;
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
	
	
 
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		People p = (People) obj;
		return name.equals(p.name)&& idCard.equals(p.idCard) && phoneNumber.equals(p.phoneNumber);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		String str = name+idCard+phoneNumber;
		return str.hashCode();
	}
	
	
	
	
	@Override
	public String toString() {
		return "People [name=" + name + ", idCard=" + idCard + ", phoneNumber=" + phoneNumber + "]";
	}









	public static void main(String[] args) {
		
		
		List<People> listPeople = new ArrayList<People>();
		listPeople.add(new People("张一",  "1234561",  "18927465531"));
		listPeople.add(new People("张一",  "12345611",  "18927465531"));
		listPeople.add(new People("张二",  "1234562",  "18927465532"));
		listPeople.add(new People("张二",  "1234562",  "189274655322"));
		listPeople.add(new People("张三",  "1234563",  "18927465533"));
		listPeople.add(new People("张三",  "1234563",  "18927465533"));
		
		
		
		Set<People> setData = new HashSet<People>();
		setData.addAll(listPeople);
		
	/*	System.out.println("list- size----" + listPeople.size());
		System.out.println("list-----" + listPeople.toString());
		
		System.out.println("set- size----" + setData.size());
		System.out.println("set-----" + setData.toString());*/
		
		for(People pp : setData) {
			System.out.println("p--" + pp.toString());
		}

		
		
	}


}