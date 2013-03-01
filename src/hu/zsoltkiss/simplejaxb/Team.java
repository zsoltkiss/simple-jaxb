package hu.zsoltkiss.simplejaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Team {
	
	
	private String name;
	
	
	private String officialName;
	
	
	private int yearOfFoundation;

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setOfficialName(String officialName) {
		this.officialName = officialName;
	}
	
	public String getOfficialName() {
		return officialName;
	}

	
	public int getYearOfFoundation() {
		return yearOfFoundation;
	}

	@XmlElement
	public void setYearOfFoundation(int yearOfFoundation) {
		this.yearOfFoundation = yearOfFoundation;
	}
	
	

}
