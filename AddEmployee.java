package com.intellect.employee.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.intellect.employee.bean.Employee;

public class AddEmployee {

	public static void main(String[] args) {
		boolean Status=false;
		Session session=null;
		Transaction tx=null;
		Scanner sc=new Scanner(System.in);
		Employee emp=new Employee();
		System.out.print("Enter Employee Id:");
		emp.setEmpId(sc.nextInt());
		System.out.print("Enter First Name:");
		emp.setEmpFirstName(sc.next());
		System.out.print("Enter Last Name:");
		emp.setEmpLastName(sc.next());
		System.out.print("Enter Email_Id:");
		emp.setEmpEmailId(sc.next());
		System.out.print("Enter Salary:");
		emp.setEmpSalary(sc.nextFloat());
		int rec=0;
		try{
			Configuration configObj = new Configuration();
	        configObj.configure("hibernate.cfg.xml");
	 
	        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
	        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
            // Creating Hibernate SessionFactory Instance
	        SessionFactory sessionfactory = configObj.buildSessionFactory(serviceRegistryObj);
	        session = sessionfactory.openSession();
	        tx=session.beginTransaction();
	        session.save(emp);
	        tx.commit();
	        Status=true;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(Status){
				System.err.println("Employee Record Added...");
			}else{
				System.err.println("Employee Record Not Added...");
			}
		}

	}

}
