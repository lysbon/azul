package com.azul.la12.domain;

import java.util.List;

import org.springframework.core.style.ToStringCreator;

public class Player {
	
	private long id;
	private String name;
	private int age;
	private List<Team> teams;
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	public String toString() {
		return new ToStringCreator(this).append("id", id).append("name", name).toString();
	}
	
}
