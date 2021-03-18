package com.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyComprator implements Comparator<Integer>{

	@Override
	public int compare(Integer I1, Integer I2) {
		return (I1>I2)?-1:(I1<I2)?1:0;
	}
	
}
public class SortingList {

	public static void main(String[] args) {
		ArrayList<Integer> i =new ArrayList<>(); 
		i.add(10);
		i.add(20);
		i.add(30);
		i.add(5);
		System.out.println("before sorting list");
		System.out.println(i);
		Collections.sort(i,new MyComprator());
		System.out.println(i);

	}

}
