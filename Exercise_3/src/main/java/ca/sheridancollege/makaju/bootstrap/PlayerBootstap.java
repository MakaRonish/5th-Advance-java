package ca.sheridancollege.makaju.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.makaju.beans.Player;
import ca.sheridancollege.makaju.repositories.PlayerRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PlayerBootstap implements CommandLineRunner {
	
	private PlayerRepository PlayerRepo;
	
	@Override
	public void run(String... arg) throws Exception{
		Player p1  = new Player(null, "Alex", 10, 15, 8, 98f, "Bronze");
		Player p2  = new Player(null, "Ben", 12, 18, 10, 10f, "Bronze");
		Player p3  = new Player(null, "Chris", 8, 20, 7, 60f, "Bronze");

		Player p4  = new Player(null, "David", 25, 20, 15, 120f, "Silver");
		Player p5  = new Player(null, "Ethan", 30, 22, 18, 200f, "Silver");
		Player p6  = new Player(null, "Frank", 28, 25, 17, 280f, "Silver");

		Player p7  = new Player(null, "George", 45, 30, 25, 320f, "Gold");
		Player p8  = new Player(null, "Henry", 50, 28, 27, 400f, "Gold");
		Player p9  = new Player(null, "Ian", 48, 35, 26, 480f, "Gold");

		Player p10 = new Player(null, "Jack", 65, 40, 35, 601f, "Platinum");
		Player p11 = new Player(null, "Kevin", 70, 38, 36, 660f, "Platinum");
		Player p12 = new Player(null, "Leo", 75, 42, 38, 999f, "Platinum");

		Player p13 = new Player(null, "Mike", 90, 50, 45, 4000f, "Diamond");
		Player p14 = new Player(null, "Nate", 95, 48, 47, 4600f, "Diamond");
		Player p15 = new Player(null, "Oscar", 100, 45, 50, 5000f, "Diamond");

		PlayerRepo.save(p2);
		PlayerRepo.save(p3);
		PlayerRepo.save(p1);
		PlayerRepo.save(p4);
		PlayerRepo.save(p5);
		PlayerRepo.save(p6);
		PlayerRepo.save(p7);
		PlayerRepo.save(p8);
		PlayerRepo.save(p9);
		PlayerRepo.save(p10);
		PlayerRepo.save(p11);
		PlayerRepo.save(p12);
		PlayerRepo.save(p13);
		PlayerRepo.save(p14);
		PlayerRepo.save(p15);

	}
	
	

}
