package thread;

public class Consumer extends Thread{
	private Person person;

	public Consumer(Person person) {
		super();
		this.person = person;
	}

	@Override
	public void run() {
		while (true) {
			person.getdata();
		}
	}
	
}
