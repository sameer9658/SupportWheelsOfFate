package supportWheelsOfFate.com.dao;

import supportWheelsOfFate.com.supportwheels.constant.SupportWheelsConstant;
import supportWheelsOfFate.com.supportwheels.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class DaoImpl implements Dao {
    private SessionFactory sessionFactory;
    public DaoImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    public List<Employee> getEmployeesDetailsWorkingOnSameDay() {
        Session session = sessionFactory.openSession();
        String hql = SupportWheelsConstant.FETCH_WORKING_EMPLOYEE_ON_SAME_DAY;
        Query query = session.createQuery(hql);
        List<Employee> results = query.list();
        session.close();
        return results!=null?results:null;
    }
    @Override
    public List<Employee> getQualifiedEmployee(){
        Session session = sessionFactory.openSession();
        String hql = SupportWheelsConstant.FETCH_QUALIFIED_EMPLOYEE;
        Query query = session.createQuery(hql);
        List<Employee> results = query.list();
        session.close();
        return results;
    }

    @Override
    public void updateStatusOfEmployee(Employee assignedEmployee){
        Session session = sessionFactory.openSession();
        Employee employee = new Employee();
        employee.setEmpName(assignedEmployee.getEmpName());
        if(assignedEmployee.getCountOfHourWorked()>=1){
            employee.setCountOfHourWorked(2);
        }else employee.setCountOfHourWorked(1);
        employee.setUpdatedDateTime(new Date());
        session.beginTransaction();
        session.saveOrUpdate(employee);
        session.getTransaction().commit();
        session.close();
    }

}
