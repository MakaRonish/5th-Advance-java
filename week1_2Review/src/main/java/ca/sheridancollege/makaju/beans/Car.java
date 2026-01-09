package ca.sheridancollege.makaju.beans;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data //give getter setter @tostring ans @equalsandHashCode
public class Car {
	private String make;
	private String model;
	private int year;
	private double mileage;
	private boolean hybrid;

}
