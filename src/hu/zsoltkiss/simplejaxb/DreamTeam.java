package hu.zsoltkiss.simplejaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
@XmlRootElement 
public class DreamTeam {
	
	private Collection<Player> members;
	
	{
		members = new HashSet<Player>();
	}

	public Collection<Player> getMembers() {
		return members;
	}

	@XmlElement
	public void setMembers(Collection<Player> members) {
		this.members = members;
	}
	
	public void addMember(Player player) {
		members.add(player);
	}
	
	

}
*/


@XmlRootElement 
public class DreamTeam {
	
	private Player[] tacticalOrder;

	public Player[] getTacticalOrder() {
		return tacticalOrder;
	}

	@XmlElement(name="player")
	public void setTacticalOrder(Player[] tacticalOrder) {
		this.tacticalOrder = tacticalOrder;
	}
	
	

	
	
	

}
