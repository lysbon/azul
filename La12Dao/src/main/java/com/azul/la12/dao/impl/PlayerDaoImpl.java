package com.azul.la12.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.azul.la12.dao.PlayerDao;
import com.azul.la12.domain.Player;

@Repository
public class PlayerDaoImpl implements PlayerDao {

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public PlayerDaoImpl(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<Player> listAllPlayers() {
		StringBuilder hql = new StringBuilder("FROM Player");
		List<Player> players = hibernateTemplate.find(hql.toString());
		return players;
	}

	public Player getPlayer(long id) {
		return hibernateTemplate.get(Player.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Player> findPlayerByName(String name) {
		StringBuilder hql = new StringBuilder("FROM Player WHERE name = ?");
		List<Player> players = hibernateTemplate.find(hql.toString(),name);
		return players;
	}

	@SuppressWarnings("unchecked")
	public List<Player> findPlayersByTeam(long idTeam) {
		DetachedCriteria dc = DetachedCriteria.forClass(Player.class);
		dc.createCriteria("teams").add(Restrictions.eq("id",idTeam));		
		dc.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<Player> players = hibernateTemplate.findByCriteria(dc);
		return players;
	}
	
	@SuppressWarnings("unchecked")
	public Player findPlayerByTeam(long idPlayer,long idTeam) {
		DetachedCriteria dc = DetachedCriteria.forClass(Player.class);
		dc.add(Restrictions.eq("id", idPlayer));
		dc.createCriteria("teams").add(Restrictions.eq("id",idTeam));		
		dc.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<Player> players = hibernateTemplate.findByCriteria(dc);
		if(players==null) return null;
		return players.get(0);
	}

	public void savePlayer(Player player) {
		hibernateTemplate.save(player);
	}

	public void updatePlayer(Player player) {
		hibernateTemplate.update(player);
	}

}
