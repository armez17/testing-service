package maintenanceservices.onsiteservice;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cased {
	
	@Id
	@GeneratedValue
	private Integer number;
	@Size(max=255)
	private String issue;
	@Size(max=255)
	private String resolve;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Engineer engineer;
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getResolve() {
		return resolve;
	}
	public void setResolve(String resolve) {
		this.resolve = resolve;
	}
	public Engineer getEngineer() {
		return engineer;
	}
	public void setEngineer(Engineer engineer) {
		this.engineer = engineer;
	}
	@Override
	public String toString() {
		return "CaseService [number=" + number + ", issue=" + issue + ", resolve=" + resolve + "]";
	}

	
	
	
	
}
