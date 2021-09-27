package com.intellect.employee.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.intellect.employee.bean.Employee;


public class DisplayAllEmployees {

	public static void main(String[] args) {
		Session session=null;
		Employee emp=null;
		List employees=null;
		int rec=0;
		try{
			Configuration configObj = new Configuration();
	        configObj.configure("hibernate.cfg.xml");
	 
	        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
	        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
            // Creating Hibernate SessionFactory Instance
	        SessionFactory sessionfactory = configObj.buildSessionFactory(serviceRegistryObj);
	        session = sessionfactory.openSession();
//	        employees=(Employee)session.load(Employee.class, 222);
//			System.out.print(emp);
	        employees=session.createQuery("from Employee").list();
	        for(Iterator itr=employees.iterator();itr.hasNext();rec++){
	        	emp=(Employee)itr.next();
	        	System.out.println(emp);
	        }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
