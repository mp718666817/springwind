package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class CardDemo {
	public static void main(String[] args) {
		TreeSet<String> arrayList2 = new TreeSet<String>();
		Character[] character = new Character[] {'♠','♥','♣','♦'};
		Character[] character1 = new Character[] {'2','K','Q','J','1','9','8','7','6','5','4','3','2','A','大','小'};
		for (int i = 0; i < character.length; i++) {
			for (int j = 0; j < character1.length; j++) {
				if (character1[j]=='大'||character1[j]=='小') {
					arrayList2.add(character1[j]+"");
				}
				else {
					arrayList2.add(character[i]+""+character1[j]);
				}
			}
		}
		Iterator iterator = arrayList2.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
