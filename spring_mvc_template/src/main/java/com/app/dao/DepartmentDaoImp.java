package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;
@Repository
public class DepartmentDaoImp implements DepartmentDao 
{
	//dependendency:Session Factory
    @Autowired
    private SessionFactory sf;
	@Override
	public List<Department> getallDepartmentDetails() 
	{
		return sf.getCurrentSession()
				.createQuery("select d from Department d",Department.class)
				.getResultList();
	}

}
