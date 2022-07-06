package mvc.controller;

import mvc.dao.EmployeeDao;
import mvc.pojo.Employee;
import mvc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * @author Agiroy
 * @date 2022/5/30 10:06
 * @effect
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

//    @GetMapping("/employee")
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getEmployeeList(Model model){
        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("employeeList",employeeList);

        return "employee";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id")Integer id){

        employeeDao.delete(id);


        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){

        employeeDao.save(employee);

        return "redirect:/employee";

    }

    //跳转更新页面时附带Employee类
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);

        return "employee_update";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployeeById(Employee employee){
        employeeDao.save(employee);

        return "redirect:/employee";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1002,"admin","admin","男",23,"123@qq.com");
    }


}
