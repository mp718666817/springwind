package linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add("hello");
		linkedList.addFirst("c#");
		linkedList.addLast("javascript");
		System.out.println(linkedList);		
		Iterator iterator = linkedList.descendingIterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println("-------------------------");
		System.out.println(linkedList.element());
		System.out.println(linkedList.getFirst());
		System.out.println(linkedList.getLast());
		linkedList.offer("jquey");
		linkedList.offerFirst("spring");
		linkedList.offerLast("springmvc");
		System.out.println("--------------------------");	
	}
}
