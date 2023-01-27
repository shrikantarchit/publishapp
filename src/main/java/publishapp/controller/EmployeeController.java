package publishapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import publishapp.dao.EmployeeMapper;
import publishapp.entity.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeMapper employeeMapper;

	@RequestMapping("/displayUpdateForm")
	public String showUpdateForm() {
		System.out.println("Records " + employeeMapper.getAllEmployees());
		return "list";
	}

	@RequestMapping("/listOfEmployee")
	public String showListOfEmployees(Model model) {
		System.out.println("Records " + employeeMapper.getAllEmployees());
		model.addAttribute("employeeList", employeeMapper.getAllEmployees());
		return "list";
	}

	@RequestMapping(value = "/saveProcess", method = RequestMethod.POST)
	public void saveEmployee(@RequestBody Employee employee) {

		employeeMapper.saveEmployee(employee);

	}

}