package palvelinohjelmointi.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DestinationForm {
	
	@NotNull
    @Size(min=2, max=100)
    private String country;
	
	@NotNull
	@Size(min=2, max=40)
	private String capital;
	
	@NotNull
	@Size(min=3, max=40)
	private String bestTimeToVisit;
	
	@NotNull
	@Size(min=4, max=50)
	private String idealLengthOfVisit;

    @NotNull
    @Min(0)
    private Integer population;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public void getCapital(String capital) {
    	this.capital = capital;
    }
    
    public void setCapital(String capital) {
        this.capital = capital;
    }
    
    public void getBestTimeToVisit(String bestTimeToVisit) {
    	this.bestTimeToVisit = bestTimeToVisit;
    }
    
    public void setBestTimeToVisit(String bestTimeToVisit) {
        this.bestTimeToVisit = bestTimeToVisit;
    }
    
    public void getIdealLengthOfVisit(String idealLengthOfVisit) {
    	this.idealLengthOfVisit = idealLengthOfVisit;
    }
    
    public void setIdealLengthOfVisit(String idealLengthOfVisit) {
        this.idealLengthOfVisit = idealLengthOfVisit;
    }
    
    public Integer getPopulation() {
    	return population;
    }

    public void setPopulation(Integer population) {
    	this.population = population;
    }
    
    public String toString() {
        return "Destination(Country: " + this.country + ", Capital: " + this.capital + ", BestTimeToVisit: " + this.bestTimeToVisit + ", IdealLengthOfVisit: " + this.idealLengthOfVisit + ", Population: " + this.population + ")";
    }
}