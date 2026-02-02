package ca.sheridancollege.makaju.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.makaju.beans.Guest;
import ca.sheridancollege.makaju.beans.Pet;
import ca.sheridancollege.makaju.repositories.GuestRepository;
import ca.sheridancollege.makaju.repositories.PetRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {
	private GuestRepository guestRepo;
	private PetRepository petRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Guest g1 = new Guest(0l,"Ronish Makaju",21,null);
		Guest g2 = new Guest(0l,"Priya Makaju",21,null);
		Pet p1 = new Pet(0l,"Dog","jerman shepard",null);
		guestRepo.save(g1);
		guestRepo.save(g2);
		petRepo.save(p1);
		g2.setPet(p1);
		guestRepo.save(g2);
		
		Guest g3 = new Guest(0L, "Aarav Sharma", 25, null);
		Guest g4 = new Guest(0L, "Neha Patel", 22, null);
		Guest g5 = new Guest(0L, "Suman Thapa", 28, null);
		Guest g6 = new Guest(0L, "Karan Singh", 24, null);

		// Guests without pets
		guestRepo.save(g3);
		guestRepo.save(g4);
		guestRepo.save(g5);
		guestRepo.save(g6);

		// Pets
		Pet p2 = new Pet(0L, "Cat", "Persian", null);
		Pet p3 = new Pet(0L, "Dog", "Golden Retriever", null);
		Pet p4 = new Pet(0L, "Bird", "Parrot", null);
		Pet p5 = new Pet(0L, "Dog", "Bulldog", null);

		petRepo.save(p2);
		petRepo.save(p3);
		petRepo.save(p4);
		petRepo.save(p5);

		// Guests with pets
		Guest g7 = new Guest(0L, "Anita Rai", 26, null);
		Guest g8 = new Guest(0L, "Rohit Verma", 30, null);
		Guest g9 = new Guest(0L, "Pooja Joshi", 23, null);
		Guest g10 = new Guest(0L, "Nikhil Mehta", 27, null);

		guestRepo.save(g7);
		guestRepo.save(g8);
		guestRepo.save(g9);
		guestRepo.save(g10);

		g7.setPet(p2);
		g8.setPet(p3);
		g9.setPet(p4);
		g10.setPet(p5);

		guestRepo.save(g7);
		guestRepo.save(g8);
		guestRepo.save(g9);
		guestRepo.save(g10);
		
		
	}

}
