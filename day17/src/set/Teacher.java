package set;

public class Teacher extends Person {
	private String tchName;
	private int tchAge;
	public Teacher(String tchName, int tchAge) {
		super();
		this.tchName = tchName;
		this.tchAge = tchAge;
	}
	public Teacher() {
		super();
	}
	public String getTchName() {
		return tchName;
	}
	public void setTchName(String tchName) {
		this.tchName = tchName;
	}
	public int getTchAge() {
		return tchAge;
	}
	public void setTchAge(int tchAge) {
		this.tchAge = tchAge;
	}
	@Override
	public String toString() {
		return "tchName=" + tchName + ", tchAge=" + tchAge ;
	}
//	public boolean equals(Object obj) 
//	{
//		Teacher teacher = (Teacher)obj;
//		if (this==obj) {
//			return true;
//		}
//		else if (obj==null) {
//			return false;
//		}
//		else if(getpAge()==teacher.getpAge()&&getpName()==teacher.getpName()){
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
//	@Override
//	public int hashCode() {
//		return 31;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Teacher other = (Teacher) obj;
//		if (tchAge != other.tchAge)
//			return false;
//		if (tchName == null) {
//			if (other.tchName != null)
//				return false;
//		} else if (!tchName.equals(other.tchName))
//			return false;
//		return true;
//	}
	
}
