package com.liao.springmvc.controller;

import com.liao.springmvc.dao.DepartmentDao;
import com.liao.springmvc.dao.EmployeeDao;
import com.liao.springmvc.entities.Department;
import com.liao.springmvc.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    private EmployeeDao dao;
    @Autowired
    private DepartmentDao departmentDao;
    @RequestMapping("/emps")
    public String getAll(Model model){
        Collection<Employee> employees = dao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @RequestMapping("/emp")
    public String toAdd(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

//    添加
    @PostMapping("/emp")
    public String add(Employee employee){
        dao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/emp/{id}")
    public String toModify(Model model, @PathVariable("id") Integer id){
        Collection<Department> departments = departmentDao.getDepartments();
        Employee employee = dao.get(id);
        model.addAttribute("depts",departments);
        model.addAttribute("emp",employee);
        return "emp/add";
    }

//    修改
    @PutMapping("emp")
    public String Modify(Employee employee){
        dao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("emp/{id}")
    public String delete(@PathVariable("id")Integer id){
        dao.delete(id);
        return "redirect:/emps";
    }
}
