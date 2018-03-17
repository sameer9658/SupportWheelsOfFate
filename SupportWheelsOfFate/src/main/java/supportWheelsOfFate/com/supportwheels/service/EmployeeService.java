package supportWheelsOfFate.com.supportwheels.service;

import supportWheelsOfFate.com.dao.Dao;
import supportWheelsOfFate.com.supportwheels.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private Dao dao;
    public EmployeeService(Dao dao){
        this.dao = dao;
    }

    public List<EmployeeResponseBean> getEmployeesDetailsWorkingOnSameDay(){
        List<Employee> employees =  dao.getEmployeesDetailsWorkingOnSameDay();
        List<EmployeeResponseBean> employeeResponseBeans = new ArrayList<EmployeeResponseBean>();
        for(Employee employee : employees){
            EmployeeResponseBean employeeResponseBean = new EmployeeResponseBean();
            employeeResponseBean.setEmpName(employee.getEmpName());
            employeeResponseBean.setCountOfHourWorked(employee.getCountOfHourWorked());
            employeeResponseBean.setUpdatedDateTime(employee.getUpdatedDateTime().toString());
            employeeResponseBeans.add(employeeResponseBean);
        }
        return employeeResponseBeans;
    }
}
