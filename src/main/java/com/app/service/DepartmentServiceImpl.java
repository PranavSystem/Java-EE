package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DepartmentDao;
import com.app.pojos.Department;

@Service 	//mandatory annotation to tell SC following spring bean contains B.L
@Transactional		//mandatory annotation tell SC to manage the transactions automatically
public class DepartmentServiceImpl implements DepartmentService {
	//dependency : dao layer interface
	@Autowired		//byType:field level D.I
	private DepartmentDao deptDao;
	
	@Override
	public List<Department> getAllDepts() {
		
		return deptDao.getAllDepartments();
	}

}
