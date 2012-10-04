package com.azul.la12.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.azul.la12.dao.PlayerDao;
import com.azul.la12.dao.TeamDao;
import com.azul.la12.domain.Constants;
import com.azul.la12.domain.Player;
import com.azul.la12.domain.Team;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-jdbc.xml"})
public class DataAccessTest{

	@Autowired    
    private TeamDao teamDao;
	@Autowired    
    private PlayerDao playerDao;
	
	@Test
	@Transactional
	public void testProcessTeam() {
		
		//Validating team query
		Team team = this.teamDao.getTeam(1);
        assertNotNull(team);
        
        //Validating player query
        List<Player> player = playerDao.findPlayerByName("Cholito Avila");
        assertNotNull(player);
        
        //Validating whether cholito_avila has a team or not
        Player cholito = player.get(0);
        List<Team> teams = cholito.getTeams();
        assertFalse(teams == null || teams.size()<=0);
        
        //Validating whether cholito_avila is chosen by The_Magician_Markarian
        List<Team> result = teamDao.findTeamByName("Seleccion del Peru");
        assertFalse(result == null || result.size()<=0);
        Team peruTeam = result.get(0);
        assertNotNull(playerDao.findPlayerByTeam(cholito.getId(),peruTeam.getId()));
        
        //Validating how many players have been chosen in _Peru
        List<Player> playersPeru = playerDao.findPlayersByTeam(peruTeam.getId());
        //I'm hoping to find _Tilsa here
        //or at least one dude for the photo thing
        assertTrue(playersPeru.size()>0);        
        
        //Validating saving data
        Team arsenal = new Team();
        arsenal.setName("Arsenal FC");
        arsenal.setType(Constants.kTypeTeamRegular);
        arsenal.setDescription("Barclays Premier League team");
        
        List<Player> arsenalPlayers = new ArrayList<Player>();
        Player theoWalcott = new Player();
        theoWalcott.setName("Theo Walcott");
        theoWalcott.setAge(23);
        
        arsenalPlayers.add(theoWalcott);
        
        teamDao.saveTeam(arsenal);
        result = teamDao.findTeamByName("Arsenal FC");
        assertFalse(result == null || result.size()<=0);
        
	}
	
}