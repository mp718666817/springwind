package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.junit.jupiter.api.Test;

import javafx.css.StyleConverter.StringStore;

public class StringBufferDemo {
	public static void main(String[] args) {
		String string  = "123";
		String string2 = new String("123");
		String string4 = "123";
		String string5 = "123123";
		String string3 = string+string2;
		String string6 = string+string4;
		String string7 = "123"+"123";
		String string8 = new String("123123");
		System.out.println(string8==string7);
		System.out.println(string7=="123123");
		System.out.println(string8==string6);
		System.out.println(string8.equals(string6));
		List<String> list = new ArrayList<String>();
		list.add("123");
		list.add("1235");
		list.add("1236");
		list.add("1237");
		list.add("1238");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		ListIterator<String> strIterator = list.listIterator();
		int []a = new int[] {12,23,43,54,64,234,999};
		List<Integer> list2 = new LinkedList<Integer>();
		for (int i = 0; i < a.length; i++) {
			list2.add(a[i]);
		}
		list2.remove(4);
		int  bc = 99;
		for (int i = 0; i < list2.size(); i++) {
			if (bc<list2.get(i)) {
				list2.add(i, 99);
				break;
			}
		}
		for (Integer integer : list2) {
			System.out.println(integer);
		}
		List<Integer> list3 = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			list3.add(a[i]);
		}
		System.out.println(System.currentTimeMillis());
		list3.add(5, bc);
		System.out.println(System.currentTimeMillis());
		for (Integer integer : list3) {
			System.out.println(integer);
		}
		String string9 = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
		String string10 = "12458492246";
		System.out.println(string10.matches(string9));
	}
	/*
	 * @Test public void test() { String string = "123"; String string2 = new
	 * String("123"); String string4 = "123"; String string5 = "123123"; String
	 * string3 = string+string2; System.out.println(string3.hashCode());
	 * System.out.println("123123".hashCode());
	 * System.out.println(string5==(string+string4)); System.out.println(""); }
	 */
}
