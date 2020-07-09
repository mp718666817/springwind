package arrayList;

import java.util.ArrayList;

import domain.Student;

public class ArrayListDemo {

	public static void main(String[] args) { 
		ArrayList arrayList1 = new ArrayList();
		arrayList1.add("001");
		arrayList1.add("002");
		Student s1 = new Student("00x",23);
		arrayList1.add(s1);
		ArrayList arrayList3 = new ArrayList();
		arrayList3.add("001");
		arrayList3.add("002");
		arrayList3.add(s1);
		System.out.println(arrayList1.equals(arrayList3));
		String s3 = "001";
		String s2 = "001";
		System.out.println(s2==s3);
		System.out.println(s3.equals(s2));
		System.out.println(s3.hashCode());
		System.out.println(s2.hashCode());
		
	}
 
}
