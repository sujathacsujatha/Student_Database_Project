package com;

public class Emplyoee {
	String id;
	String name;
	static int count=101;   //1-> DECLARE A COUNTER VARIABLE
	public Emplyoee( String name) {
		this.id = "JSP"+count;  //INITIALIZE THE COUNTER VARIABLE
		this.name = name;
		count++;      //3-> INCREMENT THE COUNTER VARIABLE 
	}
	public static void main(String[] args) {
		Emplyoee e1=new Emplyoee("tom");
		System.out.println("Id: "+e1.id+"Name: "+e1.name);
		Emplyoee e2=new Emplyoee("rtt");
		System.out.println("Id: "+e2.id+"Name: "+e2.name);
		Emplyoee e3=new Emplyoee("tjerr");
		System.out.println("Id: "+e3.id+"Name: "+e3.name);
	}


}
