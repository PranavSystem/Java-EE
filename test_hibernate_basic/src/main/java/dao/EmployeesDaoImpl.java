package dao;

import pojos.Employees;
import static utils.HibernateUtils.getFactory;
import org.hibernate.Session;
import org.hibernate.*;

public class EmployeesDaoImpl implements EmployeesDao {
	
	@Override
	public String inserEmployeeDetails(Employees emp) {
		String mesg="Failure !!!";
		//get session from sessionfactory
		Session session=getFactory().openSession();
		//begin a transaction
		Transaction tx=session.beginTransaction();
		try {
			session.save(emp);
			tx.commit();
			mesg="Succesful !!! "+emp.getEmpId();
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		} finally {
			if(session!=null)
				session.close();
			System.out.println("session closed");
		}
		
		return mesg;
	}

}
