package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);
		
	
	
	DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	Department dep = departmentDao.findById(10);
	
	System.out.println(dep);

	
	System.out.println("===== teste insert  =======");
	
	Department newDepartment = new Department(10,"Music");
	//departmentDao.insert(newDepartment);
	System.out.println("Inserted! new id = " + newDepartment.getId());
	
	
	System.out.println("===== teste find all  =======");
	
	List<Department> list = departmentDao.findAll();
	
	for(Department obj : list) {
		System.out.println(obj);
	}

	System.out.println("===== teste update  =======");
	
	
	dep = departmentDao.findById(1);
	dep.setName("Computer");
	departmentDao.update(dep);
	System.out.println("Update Completed!");
	
	
	System.out.println("===== teste DELETE  =======");
	
	System.out.println("Insert ID for Delete Department: ");
	int id = sc.nextInt();
	departmentDao.deleteById(id);
	
	System.out.println("Deleted By success");
	
	
		sc.close();
		
		
	} 
	
	
	


}
