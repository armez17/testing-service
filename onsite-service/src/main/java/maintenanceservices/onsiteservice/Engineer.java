package maintenanceservices.onsiteservice;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Engineer {
	
	protected Engineer() {
		
	}
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String level;
	@OneToMany(mappedBy = "engineer")
	private List<Cased> cased;
	
	public Engineer(Integer id, String name, String level) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	

	public List<Cased> getCaseService() {
		return cased;
	}

	public void setCaseService(List<Cased> caseService) {
		this.cased = caseService;
	}

	@Override
	public String toString() {
		return "Engineer [id=" + id + ",name=" + name + ", level=" + level + "]";
	}
	
	
	
}
