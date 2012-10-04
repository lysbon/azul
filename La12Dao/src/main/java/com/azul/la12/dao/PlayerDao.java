package com.azul.la12.dao;

import java.util.List;

import com.azul.la12.domain.Player;


public interface PlayerDao {

	public List<Player> listAllPlayers();
	public Player getPlayer(long id) ;
	public List<Player> findPlayerByName(String name) ;
	public List<Player> findPlayersByTeam(long idTeam) ;
	public Player findPlayerByTeam(long idPlayer,long idTeam);
	public void savePlayer(Player player);
	public void updatePlayer(Player player);
	
}
