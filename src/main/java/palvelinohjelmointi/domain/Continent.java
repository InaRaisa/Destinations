package palvelinohjelmointi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Continent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long continentid;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "continent")
	private List<Destination> destinations;

	public Continent() {}

	public Continent(String name) {
		super();
		this.name = name;
	}

	public Long getContinentid() {
		return continentid;
	}
	
	public void setContinentid(Long continentid) {
		this.continentid = continentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	@Override
	public String toString() {
		return "Continent [continentid=" + continentid + ", name=" + name + "]";
	}
}
