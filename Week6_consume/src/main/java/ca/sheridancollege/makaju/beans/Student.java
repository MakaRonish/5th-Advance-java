package ca.sheridancollege.makaju.beans;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	
	private Long id;
	
	private String name;
	private Double grade;
	private String letterGrade;
	

}
