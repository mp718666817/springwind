
public class TestStack {

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push("hello");
		s.push("java");
		s.push("springmvc");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
