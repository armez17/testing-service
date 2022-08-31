package testwebappauthenandauthor.infostaffsalary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Staff {
	
	protected Staff() {
		
	}
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String position;
	private Integer salary;
	
	
	public Staff(Integer id, String name, String position, Integer salary) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
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


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", position=" + position + ", salary=" + salary + "]";
	}
	
	
}
