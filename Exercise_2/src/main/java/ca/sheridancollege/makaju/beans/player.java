package ca.sheridancollege.makaju.beans;



import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data //give getter setter @tostring ans @equalsandHashCode
public class player {
	private int ID;
	private String NAME;
	private String Unit_Class;
	private String Team;
	
}
