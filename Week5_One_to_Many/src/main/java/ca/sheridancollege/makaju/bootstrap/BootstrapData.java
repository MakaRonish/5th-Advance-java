package ca.sheridancollege.makaju.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.makaju.Repositories.EmployeeRepository;
import ca.sheridancollege.makaju.Repositories.StoreRepository;
import ca.sheridancollege.makaju.beans.Employee;
import ca.sheridancollege.makaju.beans.Store;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

	
	private EmployeeRepository empRepo;
	private StoreRepository storeRepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Employees
		Employee e1  = Employee.builder().name("Ronish").build();
		Employee e2  = Employee.builder().name("Priya").build();
		Employee e3  = Employee.builder().name("Rey").build();
		Employee e4  = Employee.builder().name("Ashim").build();
		Employee e5  = Employee.builder().name("Kushal").build();
		Employee e6  = Employee.builder().name("Bikesh").build();
		Employee e7  = Employee.builder().name("Aarav").build();
		Employee e8  = Employee.builder().name("Nisha").build();
		Employee e9  = Employee.builder().name("Suman").build();
		Employee e10 = Employee.builder().name("Ritika").build();

		// Stores
		Store s1 = Store.builder().name("Store 1").build();
		Store s2 = Store.builder().name("Store 2").build();
		Store s3 = Store.builder().name("Store 3").build();
		Store s4 = Store.builder().name("Store 4").build();
		Store s5 = Store.builder().name("Store 5").build();

		// Save stores first (best practice)
		storeRepo.save(s1);
		storeRepo.save(s2);
		storeRepo.save(s3);
		storeRepo.save(s4);
		storeRepo.save(s5);

		// Assign employees to stores
		e1.setStore(s1);
		e2.setStore(s1);
		e3.setStore(s1);   // Store 1 → 3 employees

		e4.setStore(s2);   // Store 2 → 1 employee

		e5.setStore(s3);
		e6.setStore(s3);
		e7.setStore(s3);
		e8.setStore(s3);   // Store 3 → 4 employees

		e9.setStore(s4);   // Store 4 → 1 employee

		// Store 5 → no employees (empty store)

		// Save employees
		empRepo.save(e1);
		empRepo.save(e2);
		empRepo.save(e3);
		empRepo.save(e4);
		empRepo.save(e5);
		empRepo.save(e6);
		empRepo.save(e7);
		empRepo.save(e8);
		empRepo.save(e9);
		empRepo.save(e10); // employee without store (optional case)

	}

}
