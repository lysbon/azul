package com.azul.la12.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.azul.la12.dao.TeamDao;
import com.azul.la12.domain.Team;

@Repository
public class TeamDaoImpl implements TeamDao {

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public TeamDaoImpl(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<Team> listAllTeams() {
		StringBuilder hql = new StringBuilder("FROM Team");
		List<Team> teams = hibernateTemplate.find(hql.toString());
		return teams;
	}

	public Team getTeam(long id) {
		return hibernateTemplate.get(Team.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Team> findTeamByName(String name) {
		StringBuilder hql = new StringBuilder("FROM Team WHERE name = ?");
		List<Team> teams = hibernateTemplate.find(hql.toString(),name);
		return teams;
	}

	public void saveTeam(Team team) {
		hibernateTemplate.save(team);
	}

	public void updateTeam(Team team) {
		hibernateTemplate.update(team);
	}	

}
