package com.practice.hello.controller;

import com.practice.hello.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/employees" })
public class EmployeeController {

    private List<Employee> employees = createList();

    @GetMapping(produces = "application/json")
    public List<Employee> firstPage() {
        return employees;
    }


    @DeleteMapping("/{id}")
    public Employee delete(@PathVariable int id) {
        String eid = id+"";
        Employee deletedEmp = null;
        for (Employee emp : employees) {
            if (emp.getEmpId().equals(eid)) {
                employees.remove(emp);
                deletedEmp = emp;
                break;
            }
        }
        return deletedEmp;
    }

    @PostMapping
    public Employee create(@RequestBody Employee user){
        employees.add(user);
        System.out.println(user.getName());
        return user;
    }

    private static List<Employee> createList() {
        List<Employee> tempEmployees = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.setName("emp1");
        emp1.setDesignation("manager");
        emp1.setEmpId("1");
        emp1.setSalary(3000);

        Employee emp2 = new Employee();
        emp2.setName("emp2");
        emp2.setDesignation("developer");
        emp2.setEmpId("2");
        emp2.setSalary(3000);
        tempEmployees.add(emp1);
        tempEmployees.add(emp2);
        return tempEmployees;
    }

}
