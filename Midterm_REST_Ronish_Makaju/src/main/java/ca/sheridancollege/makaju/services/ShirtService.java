package ca.sheridancollege.makaju.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.sheridancollege.makaju.beans.Shirt;


@Service
public interface ShirtService {
	public Shirt getShirtById(Long id);
	public List<Shirt> getAllShirts();
	public Shirt addShirt(Shirt shirt);
	public Shirt update(Shirt shirt);
	public void deleteShirtById(Long id);

}
