package thread;
public class Producer extends Thread{
	private Person person;
	public Producer(Person person) {
		super();
		this.person = person;
	}
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			if (i%2==0) {
				person.add("小名", 50);
			}
			else {
				person.add("小红", 18);
			}
		}

	}
	
}
