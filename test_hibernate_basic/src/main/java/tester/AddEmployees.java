package tester;

import org.hibernate.*;

import dao.*;
import pojos.Employees;
import pojos.EmployeesType;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;
public class AddEmployees {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)) {
			EmployeesDao dao=new EmployeesDaoImpl();
			System.out.println(
					"Enter emp details : firstName,  lastName,  email,  "
					+ "password,  confirmPassword, joinDate,  type,  salary");
			Employees emps=new Employees(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), 
					LocalDate.parse(sc.next()), EmployeesType.valueOf(sc.next().toUpperCase()), sc.nextDouble());
			System.out.println(dao.inserEmployeeDetails(emps));
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}

}
