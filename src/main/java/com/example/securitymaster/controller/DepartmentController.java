package com.example.securitymaster.controller;

import com.example.securitymaster.dao.DepartmentDao;
import com.example.securitymaster.dao.EmployeeDao;
import com.example.securitymaster.ds.Department;
import com.example.securitymaster.ds.Employee;
import com.example.securitymaster.security.annotation.department.DepartmentsCreate;
import com.example.securitymaster.security.annotation.department.DepartmentsDelete;
import com.example.securitymaster.security.annotation.employees.EmployeesCreate;
import com.example.securitymaster.security.annotation.employees.EmployeesDelete;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/departments")
    public ModelAndView listAllEmployee() {
        return new ModelAndView("departments", "departments", departmentDao.findAll());
    }

    @DepartmentsCreate
    @GetMapping("/department-form")
    public String departmentForm(Model model) {
        model.addAttribute("department", new Department());
        return "departmentform";
    }

    @PostMapping("/department-form")
    public String departmentCreate(@Valid Department department, BindingResult result) {
        if (result.hasErrors()) {
            return "departmentform";
        }
        departmentDao.save(department);
        return "redirect:/department/departments";
    }

    @DepartmentsDelete
    @GetMapping("/delete")
    public String departmentCustomer(@RequestParam int id){
        departmentDao.deleteById(id);
        return "redirect:/department/departments";
    }
}
