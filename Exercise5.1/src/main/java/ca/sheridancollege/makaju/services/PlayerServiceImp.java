package ca.sheridancollege.makaju.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ca.sheridancollege.makaju.beans.Player;
import ca.sheridancollege.makaju.repositories.PlayerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlayerServiceImp implements PlayerService {
	private PlayerRepository playerRepo;
	
	@Override
	public Player addPlayer(Player student) {
		student.setID(null);
		
		
		Player addedStudent = playerRepo.save(student);
		
		// TODO Auto-generated method stub
		return addedStudent;
	}
	
	@Override
	public Player getPlayerById(Long id) {
		Optional<Player> foundStudent = playerRepo.findById(id);
		if(foundStudent.isPresent()) {
			return foundStudent.get();
			
		}else {
			return null;
		}
		
		
	}
	
	

	@Override
	public List<Player> getAllPlayers() {
		
		return playerRepo.findAll();
	}

	@Override
	public Player update(Player student) {
		
		Player addedStudent = playerRepo.save(student);
		
		// TODO Auto-generated method stub
		return addedStudent;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Player> updateMultiplePlayers(List<Player> students) {
		for (Player s:students) {
			update(s);
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePlayerById(Long id) {
		playerRepo.deleteById(id);
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllPlayers() {
		playerRepo.deleteAll();
		// TODO Auto-generated method stub

	}

}
