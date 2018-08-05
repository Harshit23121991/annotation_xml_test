package com.cluster;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Xml_And_Annotations_Demo {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setEname("sub");
		employee.setEmail("sub@gmail.com");

		Department department = new Department();
		department.setDname("HR");

		Set<Employee> employees = new HashSet<Employee>();
		employees.add(employee);
		
		department.setEmployees(employees);
		
		employee.setDepartment(department);
		
		SessionFactory sessionFactory = MyHibernateDBUtil.getSessionFactory();
		
		Session openSession = sessionFactory.openSession();
		
		Transaction transaction = openSession.getTransaction();
		
		
		transaction.begin();
		
		openSession.save(department);
		openSession.flush();
		
		transaction.commit();
	}

}
