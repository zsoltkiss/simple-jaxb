package hu.zsoltkiss.simplejaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Player {
	
	private String name;
	private Team team;
	
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	public Team getTeam() {
		return team;
	}
	
	@XmlElement
	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	public String toString() {
		//return super.toString() + " (" + name + ")";
		return name + " (" + team.getName() + ")";
	}
	
	
	

}
