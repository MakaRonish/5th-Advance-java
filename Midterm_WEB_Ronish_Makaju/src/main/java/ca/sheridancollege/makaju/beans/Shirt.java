package ca.sheridancollege.makaju.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Shirt {
	
	private Long id;
	private String name;
	private double price;
	private int quantity;
	private String employeeName;
}
