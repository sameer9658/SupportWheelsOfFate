package supportWheelsOfFate.com.supportwheels.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "SUPPORT_WHEELS_OF_FATE")
public class Employee {

    @Id
    @Column(name="EMP_NAME")
    private String empName;

    @Column(name="UPDATED_DATE_TIME")
    private Date updatedDateTime;

    @Column(name=" WORK_HOUR_COUNT")
    private int countOfHourWorked;

    public Employee(){

    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(Date updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public int getCountOfHourWorked() {
        return countOfHourWorked;
    }

    public void setCountOfHourWorked(int countOfHourWorked) {
        this.countOfHourWorked = countOfHourWorked;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", updatedDateTime=" + updatedDateTime +
                ", countOfHourWorked=" + countOfHourWorked +
                '}';
    }
}
