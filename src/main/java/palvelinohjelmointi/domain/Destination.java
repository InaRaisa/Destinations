package palvelinohjelmointi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Destination {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String country, capital, bestTimeToVisit, idealLengthOfVisit;
	private int population;
	
	@ManyToOne
	//JsonIgnore helps to ignore endless loop
	@JsonIgnore
	@JoinColumn(name = "continentId")
	private Continent continent;
	
	public Destination() {}

	public Destination(String country, String capital, int population, String bestTimeToVisit, String idealLengthOfVisit) {
		super();
		this.country = country;
		this.capital = capital;
		this.population = population;
		this.bestTimeToVisit = bestTimeToVisit;
		this.idealLengthOfVisit = idealLengthOfVisit;
	}
	
	public Destination(String country, String capital, int population, String bestTimeToVisit, String idealLengthOfVisit, Continent continent) {
		super();
		System.out.println("Destination constructor");
		this.country = country;
		this.capital = capital;
		this.population = population;
		this.bestTimeToVisit = bestTimeToVisit;
		this.idealLengthOfVisit = idealLengthOfVisit;
		this.continent = continent;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getBestTimeToVisit() {
		return bestTimeToVisit;
	}

	public void setBestTimeToVisit(String bestTimeToVisit) {
		this.bestTimeToVisit = bestTimeToVisit;
	}

	public String getIdealLengthOfVisit() {
		return idealLengthOfVisit;
	}

	public void setIdealLengthOfVisit(String idealLengthOfVisit) {
		this.idealLengthOfVisit = idealLengthOfVisit;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}
	
	@Override
	public String toString() {
		
		if (this.continent != null)
			return "Destination [id=" + id + ", country=" + country + ", capital= " + capital + ", population= " + population + ", bestTimeToVisit=" + bestTimeToVisit + ", idealTimeToVisit= " + idealLengthOfVisit + ", continent=" + continent + "]";
		else
			return "Destination [id=" + id + ", country=" + country + ", capital= " + capital + ", population= " + population + ", bestTimeToVisit=" + bestTimeToVisit + ", idealTimeToVisit= " + idealLengthOfVisit + "]";
	}
}