package ca.sheridancollege.makaju.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.sheridancollege.makaju.beans.Therapist;

@Service
public interface TherapistService {
	
	public List<Therapist> getAllTherapists();
	public Therapist getTherapistById(Long id);
	public Therapist addTherapist(Therapist therapist);

}
