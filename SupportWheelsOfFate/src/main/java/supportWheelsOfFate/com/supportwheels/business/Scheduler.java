package supportWheelsOfFate.com.supportwheels.business;
import supportWheelsOfFate.com.dao.Dao;
import supportWheelsOfFate.com.supportwheels.entity.Employee;
import org.hibernate.SessionFactory;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

public class Scheduler extends TimerTask {

    private Dao dao;

    public Scheduler(Dao dao){
        this.dao = dao;
    }

    public void run() {
        List<Employee> employeeLists = dao.getQualifiedEmployee();

        if(employeeLists.size()==0){
            return;
        }

        Employee assignedEmployee = getRandomEmployee(employeeLists);

        dao.updateStatusOfEmployee(assignedEmployee);
    }




    private Employee getRandomEmployee(List<Employee> employeeList){
        Random random = new Random();
        Employee randomEmp = employeeList.get(random.nextInt(employeeList.size()));
        return randomEmp;
    }

}
