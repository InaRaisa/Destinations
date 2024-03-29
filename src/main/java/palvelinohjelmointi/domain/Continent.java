package palvelinohjelmointi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// An entity represents a table in a relational database
@Entity
public class Continent {
	// @Id annotation is used to create an id column of the table
	@Id
	// @GeneratedValue annotation generates a unique primary key automatically for each new entity object
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "continent")
	private List<Destination> destinations;

	public Continent() {
		super();
	}

	public Continent(String name) {
		System.out.println("name is " + name);
		this.name = name;
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

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	@Override
	public String toString() {
		return "Continent [id=" + id + ", name=" + name + "]";
	}
}
