import java.util.LinkedList;

/*
 * 栈
 */
public class Stack {
	private LinkedList list;
	public Stack() {
		list = new LinkedList();
	}
	//推入数据
	public void push(Object obj)
	{
		list.push(obj);
	}
	public Object pop() {
		return list.pop();
	}
}
