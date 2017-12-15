package org.ruikar.rashmi.model;

import org.ruikar.rashmi.connection.B;

public class A {

	private static String str ="";
	
	public static void a()
	{
		A a1 = new A();
		B b1 = new B();
		a1.str = "Adkar";
		
		b1.b(a1);
		b1.c();
		System.out.println("Shardul");
	}
	public static void main(String[] args)
	{
		A a2 = new A();
		a2.a();
		//a2.str="Rohini";
		A a3 = new A();
		//String st1 = a3.str;
		System.out.println(str);
		//System.out.println(st1);
		
				
	}
}
