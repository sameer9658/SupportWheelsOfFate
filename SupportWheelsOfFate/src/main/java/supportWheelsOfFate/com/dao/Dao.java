package supportWheelsOfFate.com.dao;

import supportWheelsOfFate.com.supportwheels.entity.Employee;

import java.util.List;

public interface Dao {

    List<Employee> getEmployeesDetailsWorkingOnSameDay();
    List<Employee> getQualifiedEmployee();
    void updateStatusOfEmployee(Employee assignedEmployee);

}
