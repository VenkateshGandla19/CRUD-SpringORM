package com.spring.orm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.EmployeeDao;
import com.spring.orm.entities.Employee;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
       EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);
       
       //Insert using beans
       Employee employee = context.getBean("employee", Employee.class);
       employeeDao.insert(employee);
       System.out.println("Inserted: "+employee);
       
       //Insert using objects
       Employee employee1 = new Employee(101, "Venkatesh", "Senior Consultant");
       employeeDao.insert(employee1);
       System.out.println("Inserted: "+employee1);
       
       Employee employee2 = new Employee(102, "Anjali", "Software Engineer");
       employeeDao.insert(employee2);
       System.out.println("Inserted: "+employee2);

       Employee employee3 = new Employee(103, "Yash", "Senior Manager");
       employeeDao.insert(employee3);
       System.out.println("Inserted: "+employee3);
       
       //Get one Employee Details
       Employee getEmployee = employeeDao.getStudent(101);
       System.out.println(getEmployee);
       
       //Get all employee details
       List<Employee> getEmployees = employeeDao.getAllStudent();
       System.out.println(getEmployees);
       
       //delete an Employee
       String deleteEmployee = employeeDao.deleteEmployee(103);
       System.out.println(deleteEmployee);
       
       //update an employee
       Employee updateEmployee = new Employee(102, "Anjali", "Senior Software Engineer");
       String updateEmployee2 = employeeDao.updateEmployee(updateEmployee);
       System.out.println(updateEmployee2);
       
    }
}
