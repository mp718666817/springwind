import com.example.service.AccountServiece;
import com.example.service.impl.AccountserviceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountServiece accountServiece = (AccountServiece)ac.getBean("accountservice");
        accountServiece.findAll();
    }
}
