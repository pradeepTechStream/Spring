package com.dss.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dss.exception.EmployeeException;
import com.dss.model.Employee;
import com.dss.service.EmployeeService;
@Controller
public class EmployeeController {

    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(EmployeeController.class);

    public EmployeeController() {
	System.out.println("----Controller class gets call----------");
    }

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
	System.out.println("---------AllEmployee------");
	List<Employee> listEmployee = employeeService.getAllEmployees();
	model.addObject("listEmployee", listEmployee);
	model.setViewName("home");
	return model;
    }

    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
	System.out.println("---------newEmployee------");
	Employee employee = new Employee();
	model.addObject("employee", employee);
	model.setViewName("EmployeeForm");
	return model;
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
	System.out.println("---------saveEmployee------");
	if (employee.getId() == 0) {
	    if (employee.getName().trim().length() < 5) {
		throw new EmployeeException("Name should be greater then 5 character...");
	    } else {

		employeeService.addEmployee(employee);
	    }
	} else {
	    employeeService.updateEmployee(employee);
	}
	return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
	System.out.println("---------deleteEmployee------");
	int employeeId = Integer.parseInt(request.getParameter("id"));
	employeeService.deleteEmployee(employeeId);
	return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
	System.out.println("---------editEmployee------");
	int employeeId = Integer.parseInt(request.getParameter("id"));
	Employee employee = employeeService.getEmployee(employeeId);
	ModelAndView model = new ModelAndView("EmployeeForm");
	model.addObject("employee", employee);

	return model;
    }

}