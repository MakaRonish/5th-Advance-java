package ca.sheridancollege.makaju.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data

@Entity
public class Videogame {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String title;
	@NonNull
	private Integer isbn;
	@NonNull
	private Double price;
	@NonNull
	private String genre;
	
	@Transient
	private String[] genres= {"Horros","Action","RPG","Sports","Puzzle"};
	
	

}
