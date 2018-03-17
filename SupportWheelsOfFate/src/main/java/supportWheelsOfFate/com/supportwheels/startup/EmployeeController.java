package supportWheelsOfFate.com.supportwheels.startup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import supportWheelsOfFate.com.dao.Dao;
import supportWheelsOfFate.com.supportwheels.service.EmployeeResponseBean;
import supportWheelsOfFate.com.supportwheels.service.EmployeeService;

import java.util.List;
@Controller
public class EmployeeController {
    @RequestMapping(value="/getEmpDetails",method = RequestMethod.GET)
    @ResponseBody
    public List<EmployeeResponseBean> home() {
        EmployeeService employeeService = new EmployeeService(StartSupportWheelsOfFateApp.dao);
        return employeeService.getEmployeesDetailsWorkingOnSameDay();
    }
}
