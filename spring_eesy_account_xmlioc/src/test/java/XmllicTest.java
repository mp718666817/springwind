import com.example.domain.Account;
import com.example.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class XmllicTest {
    @Test
    public void test() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountservice = (AccountService)ac.getBean("accountservice");
        /*List<Account> all = accountservice.findAll();
        System.out.println(all);*/
        Account byId = accountservice.findById(3);
        System.out.println(byId);

    }
}
