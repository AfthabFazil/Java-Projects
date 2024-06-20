package com.ilp04.utility;
 
import java.util.ArrayList;
import java.util.Scanner;
 
import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImpl;
 
public class CustomerUtility {
 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char goToMainMenu;
		do
		{
			System.out.println("1.Display All Customers, 2.Insert, 3.Update");
			int mainChoice = scanner.nextInt();
			switch(mainChoice)
			{
			case 1:
				getAllCustomers();
				break;
			case 2: 
				insertIntoCustomer();
				break;
			case 3:
				//customerService.updateCustomer(customer);
				break;
			default : System.out.println("Invalid Input");
			}
			System.out.println("Go to main menu (y/n)");
			goToMainMenu = scanner.next().charAt(0);
		}	
		while(goToMainMenu == 'y');



 
	}
 
	private static void getAllCustomers() {
		CustomerService customerService = new CustomerServiceImpl();
		ArrayList<Customer> customerList = customerService.getAllCustomers();
		for(Customer customer : customerList)
			System.out.println(customer.getCustomerCode()+"   "+customer.getCustomerFirstname()+ "   "+customer.getCustomerLastname()+"    "+customer.getAddress()+"    "+customer.getPhNumber()+"    "+customer.getAadharNo());
	}
	private static void insertIntoCustomer() {
		int customerCode = 6;
		CustomerService customerService = new CustomerServiceImpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Customer First Name");
		String customerFirstName = scanner.nextLine();
		System.out.println("Enter Customer Last Name");
		String customerLastName = scanner.nextLine();
		System.out.println("Enter Customer Address");
		String Address = scanner.nextLine();
		System.out.println("Enter Customer Phone Number");
		long phNumber = scanner.nextLong();
		System.out.println("Enter Customer Aadhar Number");
		long aadharNo = scanner.nextLong();
		Customer customer = new Customer(customerCode,customerFirstName,customerLastName,Address,phNumber,aadharNo);
		int rowsInserted = customerService.insertIntoCustomer(customer);
		if(rowsInserted>0)
		{
			System.out.println("Customer inserted succesfully! : "+rowsInserted);
		}
		else {
			System.out.println("Failed to insert Customer");
		}

	}
 
}