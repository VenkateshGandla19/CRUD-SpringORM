package com.spring.orm.dao;


import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Employee;

public class EmployeeDao {
	
	private HibernateTemplate hibernateTemplate;
	
	//Create
	@Transactional
	public int insert(Employee employee)
	{
		Integer i = (Integer) this.hibernateTemplate.save(employee);
		return i;
	}
	
	//Read one data
	public Employee getStudent(int employeeId)
	{
		Employee employee = this.hibernateTemplate.get(Employee.class, employeeId);
		return employee;
	}
	
	//Read all data
	public List<Employee> getAllStudent()
	{
		List<Employee> employees = this.hibernateTemplate.loadAll(Employee.class);
		return employees;
	}
	
	//delete
	@Transactional
	public String deleteEmployee(int employeeId)
	{
		Employee employee = this.hibernateTemplate.get(Employee.class, employeeId);
		this.hibernateTemplate.delete(employee);
		return "Deleted: "+employee;
	}
	
	//update
	@Transactional
	public String updateEmployee(Employee employee)
	{
		
		this.hibernateTemplate.update(employee);
		return "Updated: " +employee;
	}

	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


}
