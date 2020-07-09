package set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		set.add(2);
		set.add(2);
		set.add(5);
		set.add(3);
		set.add(4);
		set.add(8);
		set.add(9);
		set.add(1);
		for (Integer integer : set) {
			System.out.println(integer);
		}
	}
}
