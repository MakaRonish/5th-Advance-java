package ca.sheridancollege.makaju.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.makaju.beans.Shirt;



@Service
public interface ShirtService {
	public Shirt[] getShirts(RestTemplate restTemplate);
	public Shirt[] getShirtsById(RestTemplate restTemplate,Long id);
	public Shirt[] addShirt(RestTemplate restTemplate,Shirt shirt);
	public void editShirt(RestTemplate restTemplate,Shirt shirt);
	public void deleteShirtById(RestTemplate restTemplate);


}
