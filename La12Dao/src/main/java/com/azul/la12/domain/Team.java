package com.azul.la12.domain;

import java.util.List;

import org.springframework.core.style.ToStringCreator;

public class Team {
	
	private long id;
	private String name;
	private String description;
	private int type;
	private List<Player> players;
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return new ToStringCreator(this).append("id", id).append("name", name)
				.append("description", description).toString();
	}
		
}
