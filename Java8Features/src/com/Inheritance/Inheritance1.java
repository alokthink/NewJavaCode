package com.Inheritance;
@FunctionalInterface
interface  M1 {
	public void m1();
}
interface M2 extends M1{
	public void  m1();
}
public class Inheritance1 {

	public static void main(String[] args) {
		M2 i=()->System.out.println("m1 method");
        i.m1();
	}

}
