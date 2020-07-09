package jdbccon;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import domain.Item;
import utils.DButils;
public class DButilsTest {
	@Test
	public void run() throws SQLException {
//		boolean b = DButils.executeUpdate("update depts set name=? where deptId=?", new Object []{"销售部",1});
//		System.out.println(b);
//		List<Map<String, Object>> list=DButils.query("select* from employees",null);
//		for (Map<String, Object> map : list) {
//			System.out.println(map);
//		}
		List<Item> list = DButils.executeBean("select* from item",null,Item.class);
		for (Item item : list) {
			System.out.println(item);
		}
	}
}
