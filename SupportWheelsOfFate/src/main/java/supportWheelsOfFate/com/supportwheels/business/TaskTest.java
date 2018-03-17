package supportWheelsOfFate.com.supportwheels.business;

import supportWheelsOfFate.com.dao.Dao;
import supportWheelsOfFate.com.supportwheels.constant.SupportWheelsConstant;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

public class TaskTest {

    private Properties properties;
    private Dao dao;
    public TaskTest(Properties properties,Dao dao){
        this.properties = properties;
        this.dao = dao;
    }
    public void startJob() throws IOException {

        TimerTask timerTask = new Scheduler(dao);
        Timer timer = new Timer(true);
        long time = Long.parseLong(properties.getProperty(SupportWheelsConstant.TIME_GIVEN_FOR_NEXT_EMP_TO_START));
        timer.scheduleAtFixedRate(timerTask,0, time);
        try {
            Thread.sleep(Long.parseLong(properties.getProperty(SupportWheelsConstant.TIME_GIVEN_TO_STOP_POLLER)));

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("TimerTask cancelled! :" + new Date());
        try {
            Thread.sleep(30000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

