package course.jse.jdbc.project;

import java.util.List;

public class Service {

	public static void main(String[] args) {
		
		Customer newCustomer = new Customer("Vorst OÜ", "5265664", "USA154856", 
											"Wall st 10", "WA", "WA", "USA", "4554", 
											"business@business.com", "+55645454", 15);
//		
		CustomerDao myCustomer = new CustomerDao();
//		myCustomer.createCustomer(newCustomer);
		
		// 2 edit customer information 
//		myCustomer.editCustomer(newCustomer, 2);
		
		// 3 show all customers in List
//		List <Customer> foundCustomer = myCustomer.showCustomers();
//		for (Customer element : foundCustomer) {
//			System.out.println(element);
//		};
		
		// 4 create new customer with prepare statement
//		myCustomer.createUserPrepStatement();
		
		// 5 edit customer with prepare statement
		myCustomer.updateUserPrepStatement(newCustomer, 3);
		
	}
	
}
