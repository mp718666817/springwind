package thread;

public class Test {
	public static void main(String[] args) {
		Person p =  new Person();
		Thread t1 = new Consumer(p);
		Thread t2 = new Producer(p);
		t1.start();
		t2.start();
	}
}
