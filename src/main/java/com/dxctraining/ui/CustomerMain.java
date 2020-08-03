package com.dxctraining.ui;
import com.dxctraining.service.CustomerService;
import com.dxctraining.service.CustomerServiceImpl;
import java.util.List;
import com.dxctraining.entities.Businesscustomer;
import com.dxctraining.entities.Customer;
import com.dxctraining.entities.Account;
import com.dxctraining.entities.Regularcustomer;
import com.dxctraining.exceptions.CustomerNotFoundException;
import com.dxctraining.exceptions.InvalidArgumentException;

public class CustomerMain {
	CustomerService service = new CustomerServiceImpl();

	public static void main(String[] args) {

		CustomerMain demo = new CustomerMain();
		demo.runApp();
	}

	public void runApp() {
		try {

			Account account1 = new Account("11111pan", 6666);
			Account account2 = new Account("12345pan", 9999);
			Account account3 = new Account("115674pan", 66566);
			Account account4 = new Account("1321345pan", 9879);


			Regularcustomer customer1 = new Regularcustomer("gopi", account1, "konabakkam");
			service.add(customer1);
			int id1 = customer1.getId();
			Regularcustomer customer2 = new Regularcustomer("subash", account2, "gnt");
			service.add(customer2);
			int id2 = customer2.getId();
			Businesscustomer customer3 = new Businesscustomer("ram", account3, "ong");
			service.add(customer3);
			int id3 = customer3.getId();
			Businesscustomer customer4 = new Businesscustomer("fayaz", account4, "Norway");
			service.add(customer4);
			int id4 = customer4.getId();
			//service.delete(id4);
              // service.updateName(id2, "sai");
               
			displayAll();

		} catch (InvalidArgumentException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	public void displayAll() {
		List<Customer> list = service.findAll();
		for (Customer customer : list) {
			display(customer);

			boolean isRegularCustomer = customer instanceof Regularcustomer;
			if (isRegularCustomer) {
				Regularcustomer ca = (Regularcustomer) customer;
				display(ca);
			}
			boolean isBusinessCustomer = customer instanceof Businesscustomer;
			if (isBusinessCustomer) {
				Businesscustomer ca = (Businesscustomer) customer;
				display(ca);
			}

		}
	}

	public void display(Customer customer) {
		String name = customer.getName();
		int id = customer.getId();
		System.out.println(name);
		System.out.println(id);
		Account account = customer.getAccount();
		System.out.println("  Customer  pursuing Account  balance -- : " + account.getBalance() + " Pancard Number -- "
				+ account.getPancard());

	}

	public void display(Regularcustomer customer) {

		System.out.println("address=" + customer.getHouseAddress());
	}

	public void display(Businesscustomer customer) {

		System.out.println("address=" + customer.getBusinessAddress());
	}
}


