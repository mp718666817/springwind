import com.example.dao.IAccountDao;
import com.example.domain.Account;
import com.example.jdbc.jdbcTemplete;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao iAccountDao = ac.getBean("accountdao", IAccountDao.class);
        Account byId = iAccountDao.findById(1);
        System.out.println(byId);
    }
}
