package supportWheelsOfFate.com.supportwheels.service;

import java.util.Date;

public class EmployeeResponseBean {

    private String empName;
    private String updatedDateTime;
    private int countOfHourWorked;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(String updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public int getCountOfHourWorked() {
        return countOfHourWorked;
    }

    public void setCountOfHourWorked(int countOfHourWorked) {
        this.countOfHourWorked = countOfHourWorked;
    }
}
