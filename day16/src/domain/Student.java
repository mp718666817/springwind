package domain;

/**
 * @author mp718
 *
 */
public class Student {
	private String stuName;
	private Integer stuAge;
	 
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String stuName, Integer stuAge) {
		super();
		this.stuName = stuName;
		this.stuAge = stuAge;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Integer getStuAge() {
		return stuAge;
	}

	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}

	public static void main(String[] args) {
		
	}

	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuAge=" + stuAge + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stuAge == null) ? 0 : stuAge.hashCode());
		result = prime * result + ((stuName == null) ? 0 : stuName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (stuAge == null) {
			if (other.stuAge != null)
				return false;
		} else if (!stuAge.equals(other.stuAge))
			return false;
		if (stuName == null) {
			if (other.stuName != null)
				return false;
		} else if (!stuName.equals(other.stuName))
			return false;
		return true;
	}
	

}
