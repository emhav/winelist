package hh.swd20.Winelist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hh.swd20.Winelist.domain.Type;

@Entity
public class Wine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String origin;
	private int year;
	private String variety;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "typeid")
	private Type type;
	
	public Wine() {}
	
	public Wine(String name, String origin, int year, String variety, Type type){
		super();
		this.name = name;
		this.origin = origin;
		this.year = year;
		this.variety = variety;
		this.type = type;
		
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}
	
	@Override
	public String toString() {
		if (this.type != null)
			return "Wine [id=" + id + ",name=" + name + ", origin=" + origin + ", year=" + year + ", variety=" + variety + " type =" + this.getType() + "]";		
		else
			return "Wine [id=" + id + ",name=" + name + ", origin=" + origin + ", year=" + year + ", variety=" + variety + "]";
	}
	
}
