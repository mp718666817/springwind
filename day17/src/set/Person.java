package set;

public class Person {
	private String pName;
	private int pAge;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String pName, int pAge) {
		super();
		this.pName = pName;
		this.pAge = pAge;
	}
	@Override
	public String toString() {
		return "Person [pName=" + pName + ", pAge=" + pAge + "]";
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpAge() {
		return pAge;
	}
	public void setpAge(int pAge) {
		this.pAge = pAge;
	}
	
	
}
