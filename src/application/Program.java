,package application;

import java.util.Date;
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

		System.out.println("\n=== Test 4 : seller insert ===");
		
		Seller newSeller = new Seller(null, "greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getid());

		System.out.println("\n=== Test 5 : seller Update ===");
		
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update Completed!");
	} 

}
