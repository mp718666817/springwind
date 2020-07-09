package vector;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

import domain.Student;

public class VectorDemo {
	public static void main(String[] args) {
		Vector vector = new Vector();
		vector.addElement("Hello");
		vector.addElement("java");
		Object[] objs = new Object[5];
		vector.copyInto(objs);
		System.out.println(Arrays.toString(objs));
		System.out.println(vector.elementAt(0));
		//迭代vector
		Enumeration element = vector.elements();
		while(element.hasMoreElements())
		{
			System.out.println(element.nextElement());
		}
		System.out.println("--------------------------");
		vector.insertElementAt("c#", 1);
		System.out.println(vector);
		System.out.println("--------------------------");
		Vector vector2 = new Vector();
		vector2.add(new Student("001",12));
		vector2.add(new Student("002",12));
		vector2.remove(new Student("002",12));
		System.out.println(vector2);
	}
 
}
