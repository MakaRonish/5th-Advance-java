package ca.sheridancollege.makaju.bootstrap;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.makaju.Repositories.EmployeeRepository;
import ca.sheridancollege.makaju.Repositories.StoreRepository;
import ca.sheridancollege.makaju.Repositories.VideogameRepository;
import ca.sheridancollege.makaju.beans.Employee;
import ca.sheridancollege.makaju.beans.Store;
import ca.sheridancollege.makaju.beans.Videogame;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

	
	private EmployeeRepository empRepo;
	private StoreRepository storeRepo;
	private VideogameRepository videoRepo;
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
		
		//Videogame
		Videogame v1= Videogame.builder().title("PUBG").price(100).build();
		Videogame v2 = Videogame.builder().title("Call of Duty").price(90).build();
		Videogame v3 = Videogame.builder().title("FIFA 24").price(80).build();
		Videogame v4 = Videogame.builder().title("GTA V").price(70).build();
		Videogame v5 = Videogame.builder().title("Minecraft").price(40).build();
		Videogame v6 = Videogame.builder().title("Fortnite").price(0).build();
		Videogame v7 = Videogame.builder().title("Apex Legends").price(0).build();
		Videogame v8 = Videogame.builder().title("Elden Ring").price(85).build();
		Videogame v9 = Videogame.builder().title("Cyberpunk 2077").price(75).build();
		Videogame v10 = Videogame.builder().title("Valorant").price(0).build();
		Videogame v11 = Videogame.builder().title("Red Dead Redemption 2").price(90).build();

		
		videoRepo.save(v1);
		videoRepo.save(v2);
		videoRepo.save(v3);
		videoRepo.save(v4);
		videoRepo.save(v5);
		videoRepo.save(v6);
		videoRepo.save(v7);
		videoRepo.save(v8);
		videoRepo.save(v9);
		videoRepo.save(v10);
		videoRepo.save(v11);
		
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
		empRepo.save(e10);
		
		// employee without store (optional case)
		// Link videogames to stores

		// Store 1 sells popular paid games
		s1.setVideogames(List.of(v1, v2, v3, v4));

		// Store 2 sells free + competitive games
		s2.setVideogames(List.of(v6, v7, v10));

		// Store 3 sells a mix
		s3.setVideogames(List.of(v3, v5, v8, v9));

		// Store 4 sells AAA titles
		s4.setVideogames(List.of(v4, v8, v11));

		// Store 5 sells everything
		s5.setVideogames(List.of(
		        v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11
		));
		
		storeRepo.save(s1);
		storeRepo.save(s2);
		storeRepo.save(s3);
		storeRepo.save(s4);
		storeRepo.save(s5);


		

	}

}
