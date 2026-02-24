package ca.sheridancollege.makaju.beans;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ID;
	private String name;
	private String className;
	private int gamesPlayed;
	private int gameWon;
	private int gameLost;
	private double points;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="team_id")
	private Team team;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	    name="player_game",
	    joinColumns=@JoinColumn(name="player_id"),
	    inverseJoinColumns=@JoinColumn(name="game_id")
	)
	private List<Game> games;

}
