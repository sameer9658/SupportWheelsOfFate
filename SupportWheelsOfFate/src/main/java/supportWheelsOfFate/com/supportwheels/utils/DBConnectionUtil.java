package supportWheelsOfFate.com.supportwheels.utils;

import supportWheelsOfFate.com.supportwheels.constant.SupportWheelsConstant;
import supportWheelsOfFate.com.supportwheels.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.io.IOException;
import java.util.Properties;

public class DBConnectionUtil {

    private static SessionFactory sessionFactory;

    private static Configuration configuration;

    private static ServiceRegistry serviceRegistry;

    public static SessionFactory getSessionFactory(Properties properties) throws IOException {
        if (configuration == null) {

            configuration = new Configuration();

            configuration.setProperty(SupportWheelsConstant.DRIVER_CLASS_NAME, properties.getProperty(SupportWheelsConstant.DRIVER_CLASS_NAME));
            configuration.setProperty(SupportWheelsConstant.CONNECTION_URL, properties.getProperty(SupportWheelsConstant.CONNECTION_URL));
            configuration.setProperty(SupportWheelsConstant.USER_NAME, properties.getProperty(SupportWheelsConstant.USER_NAME));
            configuration.setProperty(SupportWheelsConstant.PASSWORD, properties.getProperty(SupportWheelsConstant.PASSWORD));
            configuration.setProperty(SupportWheelsConstant.DIALECT, properties.getProperty(SupportWheelsConstant.DIALECT));
            configuration.setProperty(SupportWheelsConstant.PROVIDER_CLASS, properties.getProperty(SupportWheelsConstant.PROVIDER_CLASS));
            configuration.setProperty(SupportWheelsConstant.SHOW_SQL, properties.getProperty(SupportWheelsConstant.SHOW_SQL));
            configuration.setProperty(SupportWheelsConstant.HBM_DDL_SHOW, properties.getProperty(SupportWheelsConstant.HBM_DDL_SHOW));
            configuration.addAnnotatedClass(Employee.class);
        }
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

}
