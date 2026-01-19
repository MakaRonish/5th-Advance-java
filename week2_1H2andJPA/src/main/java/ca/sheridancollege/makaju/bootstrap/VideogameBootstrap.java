package ca.sheridancollege.makaju.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.makaju.beans.Videogame;
import ca.sheridancollege.makaju.repositories.VideogameRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor //this make vgREpo to not be null 
public class VideogameBootstrap implements CommandLineRunner {
	
	VideogameRepository vgRepo;
	
	@Override
	public void run(String... arg) throws Exception{
		Videogame g1= new Videogame("Dead Space",1234,22.22,"Horror");
		Videogame g2= new Videogame("PUBG",5678,99.99,"Action");
		Videogame g3= new Videogame("Minecraft",9101,88.67,"RPG");
		Videogame g4= new Videogame("FIFA",2234,12.99,"Sports");
		Videogame g5= new Videogame("Mist",9987,33.77,"Puzzle");
		
		vgRepo.save(g1);
		vgRepo.save(g2);
		vgRepo.save(g3);
		vgRepo.save(g4);
		vgRepo.save(g5);
	}

}
