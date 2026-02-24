package ca.sheridancollege.makaju.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ca.sheridancollege.makaju.beans.Shirt;

import ca.sheridancollege.makaju.repositories.ShirtRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ShirtServiceImp implements ShirtService {

	private ShirtRepository shirtRepo;
	@Override
	public Shirt getShirtById(Long id) {
		Optional<Shirt> foundShirt = shirtRepo.findById(id);
		if(foundShirt.isPresent()) {
			return foundShirt.get();
			
		}else {
			return null;
		}
	}

	@Override
	public List<Shirt> getAllShirts() {
		return shirtRepo.findAll();
		
	}

	@Override
	public Shirt addShirt(Shirt shirt) {
		shirt.setId(null);
		
		Shirt addedShirt = shirtRepo.save(shirt);
	
		return addedShirt;
	}

	@Override
	public Shirt update(Shirt shirt) {
		
		Shirt addedShirt = shirtRepo.save(shirt);
		
		// TODO Auto-generated method stub
		return addedShirt;
	}

	@Override
	public void deleteShirtById(Long id) {
		shirtRepo.deleteById(id);

	}

}
