package ca.sheridancollege.makaju.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.sheridancollege.makaju.beans.Player;

@Service
public interface PlayerService {
	
	public Player addPlayer(Player player);
	public Player getPlayerById(Long id);
	public List<Player> getAllPlayers();
	public Player update(Player player);
	public List<Player> updateMultiplePlayers(List<Player> player);
	public void deletePlayerById(Long id);
	public void deleteAllPlayers();

}
