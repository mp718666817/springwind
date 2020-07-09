package com.cn.lamba;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class LambaTest {
	@Test
	public void a1() {
		String s1 = "jdjfsoe";
		Supplier<String> s = ()->s1.toUpperCase();
		Consumer<String> s2 = System.out::println;
		PrintStream ps = System.out;
		Consumer<String> s3 = ps::println;
		BiPredicate<String, String> bp = (string1,string2)->string1.equals(string2);
		BiPredicate<String,String> bp1 = String::equals;
		System.out.println(bp.test("hello", "Hello"));
	}
	@Test
	public void a2() {
		String string = new String("你好");
		Supplier<Employees> supplier = ()->new Employees();
		System.out.println(supplier.get());
		Supplier<Employees> supplier2 = Employees::new;
		System.out.println(supplier.get());
		Function<String, Employees> function = Employees::new;
		System.out.println(function.apply("1233"));
		Function<Integer, Integer[]> intFunction = (i)->new Integer[i];
		Integer[] aIntegers= intFunction.apply(10);
		System.out.println("------------------------------");
		System.out.println(aIntegers);
	}
	@Test
	public void a3() {
		Arrays.stream(new String[] {"aaa","bbb","ccc"}).map((e)->e.toUpperCase()).forEach(System.out::println);
		Arrays.stream(new String[] {"123","23","45"}).mapToDouble((w)->Double.parseDouble(w)).forEach(System.out::println);
		Arrays.stream(new String[] {"aaa","bbb","ccc"}).map(e->e.toCharArray()).forEach(System.out::println);
	}
	@Test
	public void a4() {
		List<Employees> list = new ArrayList<Employees>();
		list.add(new Employees("张五", 2000, 5));
		list.add(new Employees("李六", 2000, 6));	
		list.add(new Employees("王七",5000,3));
		list.add(new Employees("赵八",3400,4));
		list.add(new Employees("胡九",4000,7));
		Double collect = list.stream().map((e)->e.getSalary()).collect(Collectors.averagingInt((e)->e));
		Double collect2 = list.stream().collect(Collectors.averagingDouble((e)->(int)e.getSalary()));
		System.out.println(collect2);
	}
	@Test
	public void a5() {
		List<Transaction> transactions = null;
		Trader raoul = new Trader("Raoul", "Cambridge");
			Trader mario = new Trader("Mario", "Milan");
			Trader alan = new Trader("Alan", "Cambridge");
			Trader brian = new Trader("Brian", "Cambridge");
			
			transactions = Arrays.asList(
					new Transaction(brian, 2011, 300),
					new Transaction(raoul, 2012, 1000),
					new Transaction(raoul, 2011, 400),
					new Transaction(mario, 2012, 710),
					new Transaction(mario, 2012, 700),
					new Transaction(alan, 2012, 950)
			);
			transactions.stream().filter((e)->e.getYear()==2011).map((e)->e.getValue()).sorted().forEach(System.out::println);
			transactions.stream().map(e->e.getTrader()).map(e->e.getCity()).collect(Collectors.toSet()).forEach(System.out::println);
	}
}
