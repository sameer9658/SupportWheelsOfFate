package supportWheelsOfFate.com.supportwheels.startup;
import org.springframework.context.annotation.ComponentScan;
import supportWheelsOfFate.com.dao.Dao;
import supportWheelsOfFate.com.dao.DaoImpl;
import supportWheelsOfFate.com.supportwheels.business.TaskTest;
import supportWheelsOfFate.com.supportwheels.utils.DBConnectionUtil;
import org.hibernate.SessionFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import java.io.FileInputStream;
import java.util.Properties;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class StartSupportWheelsOfFateApp implements CommandLineRunner{

    private static SessionFactory sessionFactory = null;
    private static Properties properties;
    public static Dao dao;

    public static void main(String[] args) throws Exception {
        properties = new Properties();
        FileInputStream in = new FileInputStream("resources.properties");
        properties.load(in);
        sessionFactory = DBConnectionUtil.getSessionFactory(properties);
        dao = new DaoImpl(sessionFactory);

        SpringApplication.run(StartSupportWheelsOfFateApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        TaskTest taskTest = new TaskTest(properties,dao);
        taskTest.startJob();
    }

}
