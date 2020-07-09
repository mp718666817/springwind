package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class listDemo {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(0,"小明");
		list.add(1,"阿美");
		list.add(1,"催化");
		//根据元素并返回该元素
		Object object = list.remove(0);
		System.out.println(object);
		System.out.println(list.size());
		System.out.println(list.get(0)+":"+list.get(1));
		System.out.println("-------------------------------");
//		while(iL.hasNext())
//		{
//			System.out.println(iL.next());
//		}
		List l1 = new ArrayList();
		l1.add("001");
		l1.add("002");
		List l2 = new ArrayList();
		l2.add("001");
		l2.add("002");
		System.out.println(l1.equals(l2));
	}

}
