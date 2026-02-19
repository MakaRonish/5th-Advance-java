package ca.sheridancollege.makaju.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Player {
	private Long ID;
	private String name;
	private String className;
	private int gamesPlayed;
	private int gameWon;
	private int gameLost;
	private double points;

}
