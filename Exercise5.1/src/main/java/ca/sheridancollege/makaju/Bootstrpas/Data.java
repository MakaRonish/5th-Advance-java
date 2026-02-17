package ca.sheridancollege.makaju.Bootstrpas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.makaju.beans.Player;
import ca.sheridancollege.makaju.services.PlayerService;
import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class Data implements CommandLineRunner {

	private PlayerService playerService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		playerService.addPlayer(Player.builder().name("Ronish").gamesPlayed(100).gameWon(100).gameLost(0).points(9999.99).build());
		playerService.addPlayer(Player.builder().name("Alex").gamesPlayed(85).gameWon(60).gameLost(25).points(7200.50).build()); playerService.addPlayer(Player.builder().name("Jordan").gamesPlayed(120).gameWon(90).gameLost(30).points(8800.75).build()); playerService.addPlayer(Player.builder().name("Taylor").gamesPlayed(70).gameWon(40).gameLost(30).points(5400.20).build()); playerService.addPlayer(Player.builder().name("Chris").gamesPlayed(95).gameWon(65).gameLost(30).points(7600.10).build()); playerService.addPlayer(Player.builder().name("Morgan").gamesPlayed(110).gameWon(85).gameLost(25).points(9100.00).build()); playerService.addPlayer(Player.builder().name("Jamie").gamesPlayed(60).gameWon(35).gameLost(25).points(4800.45).build()); playerService.addPlayer(Player.builder().name("Casey").gamesPlayed(130).gameWon(100).gameLost(30).points(9900.90).build()); playerService.addPlayer(Player.builder().name("Riley").gamesPlayed(75).gameWon(50).gameLost(25).points(6300.33).build()); playerService.addPlayer(Player.builder().name("Drew").gamesPlayed(90).gameWon(55).gameLost(35).points(7000.70).build());

	}

}
