package ca.sheridancollege.makaju.beans;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Videogame {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String title;
	private double price;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="videogames")
	
	private List<Store> stores;

	@Override
	public String toString() {
		return "Videogame [id=" + id + ", title=" + title + ", price=" + price + ", ]";
	}
	
	

}
