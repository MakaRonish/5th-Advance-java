package ca.sheridancollege.makaju.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import ca.sheridancollege.makaju.beans.Therapist;
import ca.sheridancollege.makaju.repositories.TherapistRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TherapistServiceImp implements TherapistService {

	private TherapistRepository therapistRepo;
	@Override
	public List<Therapist> getAllTherapists() {
		// TODO Auto-generated method stub
		return therapistRepo.findAll();
	}

	@Override
	public Therapist getTherapistById(Long id) {
		Optional<Therapist> foundTherapist = therapistRepo.findById(id);
		if(foundTherapist.isPresent()) {
			return foundTherapist.get();
			
		}else {
			return null;
		}
	}

	@Override
	public Therapist addTherapist(Therapist therapist) {
		therapist.setId(null);
		Therapist addedTherapist = therapistRepo.save(therapist);
		return addedTherapist;
	}

}
