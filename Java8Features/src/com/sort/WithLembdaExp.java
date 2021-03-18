package com.sort;

import java.util.ArrayList;
import java.util.Collections;

public class WithLembdaExp {

	public static void main(String[] args) {
		ArrayList<Integer> i =new ArrayList<>(); 
		i.add(10);
		i.add(20);
		i.add(30);
		i.add(5);
		Collections.sort(i);
		System.out.println(i);
		Collections.sort(i,(I1,I2)->(I1>I2)?-1:(I1<I2)?1:0);
		System.out.println(i);
		

	}

}
