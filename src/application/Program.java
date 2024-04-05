package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		//Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, depart);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		
		System.out.println("=== Test 1 : seller find by id ===");
		System.out.println(seller); 

		
		System.out.println("\n=== Test 2 : seller find by department ===");
		
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department); 
		for(Seller obj : list) {
			System.out.println(obj);
		}


		System.out.println("\n=== Test 3 : seller find All ===");
		
		 list = sellerDao.findAll(); 
		for(Seller obj : list) {
			System.out.println(obj);
		}
	}

}
