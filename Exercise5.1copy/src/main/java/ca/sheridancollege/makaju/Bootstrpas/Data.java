package ca.sheridancollege.makaju.Bootstrpas;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.makaju.beans.Game;
import ca.sheridancollege.makaju.beans.Player;
import ca.sheridancollege.makaju.beans.Team;
import ca.sheridancollege.makaju.services.PlayerService;
import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class Data implements CommandLineRunner {

	private PlayerService playerService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		playerService.addPlayer(

			    Player.builder()
			        .name("Ronish")
			        .gamesPlayed(100)
			        .gameWon(100)
			        .gameLost(0)
			        .points(9999.99)

			        .team(
			            Team.builder()
			                .teamName("Red Team")
			                .build()
			        )

			        .games(List.of(
			            Game.builder().gameName("FIFA").build(),
			            Game.builder().gameName("COD").build()
			        ))

			        .build()
			);
		playerService.addPlayer(

			    Player.builder()
			        .name("Alex")
			        .gamesPlayed(85)
			        .gameWon(60)
			        .gameLost(25)
			        .points(7200.50)

			        .team(
			            Team.builder()
			                .teamName("Blue Team")
			                .build()
			        )

			        .games(List.of(
			            Game.builder().gameName("COD").build()
			        ))

			        .build()
			);
	}

}
