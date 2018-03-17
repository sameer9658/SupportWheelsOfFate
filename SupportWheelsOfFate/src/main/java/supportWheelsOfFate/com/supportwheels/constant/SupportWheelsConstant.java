package supportWheelsOfFate.com.supportwheels.constant;

public class SupportWheelsConstant {
    public static final String DRIVER_CLASS_NAME="hibernate.connection.driver_class";
    public static final String CONNECTION_URL = "hibernate.connection.url";
    public static final String USER_NAME = "hibernate.connection.username";
    public static final String PASSWORD = "hibernate.connection.password";
    public static final String DIALECT = "hibernate.dialect";
    public static final String PROVIDER_CLASS = "hibernate.cache.provider_class";
    public static final String SHOW_SQL = "hibernate.show_sql";
    public static final String HBM_DDL_SHOW = "hibernate.hbm2ddl.auto";
    public static final String FETCH_QUALIFIED_EMPLOYEE = "from Employee \n" +
            "where (updatedDateTime is null or updatedDateTime<SYSDATE-2) and  countOfHourWorked<2";
    public static final String  TIME_GIVEN_FOR_NEXT_EMP_TO_START = "timeTOAssignNextEmp";
    public static final String TIME_GIVEN_TO_STOP_POLLER = "timeTOStopThePoller";
    public static final String FETCH_WORKING_EMPLOYEE_ON_SAME_DAY = "from Employee where trunc(UPDATED_DATE_TIME)=trunc(sysdate)";
}
