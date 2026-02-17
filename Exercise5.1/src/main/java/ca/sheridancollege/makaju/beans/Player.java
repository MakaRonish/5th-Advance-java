package ca.sheridancollege.makaju.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	

}
