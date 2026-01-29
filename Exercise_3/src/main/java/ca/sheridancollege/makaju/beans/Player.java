package ca.sheridancollege.makaju.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int kills;
	private int deaths;
	private int matches;
	private float points;
	private String ranks;
	
//	@Transient
//	private String[] ranks= {"Bronze","Silver","Gold","Platinum","Diamond"};
	
	
	


}
