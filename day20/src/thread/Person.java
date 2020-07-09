package thread;
/**
 * 这是一个person类
 * @author mp718
 * 
 */
public class Person {
	private String name;
	private int age;
	/*表示没有数据*/
	boolean flag = false;
	/*添加数据*/
	public synchronized void add(String a, int b) {
		/*没有数据则等待*/
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.age = b;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.name = a;
		flag = true;
		notifyAll();
	}
	public synchronized void getdata() {
		while (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("name:"+name+",age:"+age);
		flag = false;
		notifyAll();
	}
}
