package rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Chaiyapat Boontham");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getVersionSecondOfPerson() {
		return new PersonV2(new Name("Chaiyapat","Boontham"));
	}
	
	@GetMapping(path="/person",params="version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		return new PersonV1("Chaiyapat Boontham");
	}
	
	@GetMapping(path="/person",params="version=2")
	public PersonV2 getVersionSecondOfPersonRequestParameter() {
		return new PersonV2(new Name("Chaiyapat","Boontham"));
	}
	
	@GetMapping(path="/person/header",headers="X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		return new PersonV1("Chaiyapat Boontham");
	}
	
	@GetMapping(path="/person/header",headers="X-API-VERSION=2")
	public PersonV2 getVersionSecondOfPersonRequestHeader() {
		return new PersonV2(new Name("Chaiyapat","Boontham"));
	}
	@GetMapping(path="/person/accept",produces="application/vnd.company.app-V1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV1("Chaiyapat Boontham");
	}
	
	@GetMapping(path="/person/accept",produces="application/vnd.company.app-V2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		return new PersonV2(new Name("Chaiyapat","Boontham"));
	}
}
