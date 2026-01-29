package ca.sheridancollege.makaju.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.makaju.beans.Player;
import ca.sheridancollege.makaju.repositories.PlayerRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PlayerBootstrap implements CommandLineRunner {
	PlayerRepository repo;
	
	@Override
	public void run(String... arg) throws Exception{
		repo.save(new Player("Ares", "Warrior", 120f));
        repo.save(new Player("Luna", "Mage", 150f));
        repo.save(new Player("Kai", "Archer", 90f));
        repo.save(new Player("Nova", "Assassin", 200f));
        repo.save(new Player("Drake", "Tank", 80f));

        repo.save(new Player("Iris", "Support", 110f));
        repo.save(new Player("Zane", "Warrior", 140f));
        repo.save(new Player("Mira", "Mage", 160f));
        repo.save(new Player("Rex", "Archer", 95f));
        repo.save(new Player("Vex", "Assassin", 210f));

        repo.save(new Player("Atlas", "Tank", 70f));
        repo.save(new Player("Echo", "Support", 130f));
        repo.save(new Player("Blaze", "Warrior", 155f));
        repo.save(new Player("Frost", "Mage", 170f));
        repo.save(new Player("Shadow", "Assassin", 220f));
	}

}
