package set;
import java.util.*;
public class SetDemo {

	public static void main(String[] args) {
		Set hashSet = new HashSet();
		hashSet.add("001");
		hashSet.add("002");
		hashSet.add(new Teacher("001",12));
		System.out.println(hashSet);
		System.out.println("----------");
		Set<Teacher> set1 = new HashSet<Teacher>();
		set1.add(new Teacher("23",12));
		set1.add(new Teacher("23",13));
		Set<Person> set2 = new HashSet<Person>();
		set2.add(new Person("24",12));
		//set2.addAll(set1);
		System.out.println(set2);
		System.out.println("---------------");
		//set1.addAll(set2);
		System.out.println(set1);
		System.out.println("-------------");
		HashSet<Teacher> set3 = new HashSet<>();
		set3.add(new Teacher("23",12));
		set3.add(new Teacher("23",13));
		System.out.println(set1);
		System.out.println(set3);
		System.out.println("------------------");
		System.out.println(set1.containsAll(set3));
		System.out.println("----------------");
		Iterator<Teacher> it1 = set1.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		for(Teacher teacher1:set1)
		{
			System.out.println(teacher1);
		}
		}
}
