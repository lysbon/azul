package com.azul.la12.dao;

import java.util.List;

import com.azul.la12.domain.Team;


public interface TeamDao {

	public List<Team> listAllTeams();
	public Team getTeam(long id) ;
	public List<Team> findTeamByName(String name) ;
	public void saveTeam(Team team);
	public void updateTeam(Team team);
	
}
