package maintenanceservices.onsiteservice;

import java.net.URI;
import java.util.List;
import java.util.Optional;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
public class EngineerServiceController {

	private EngineerRepo engineerRepo;
	private CasedRepo casedRepo;

	public EngineerServiceController(EngineerRepo engineerRepo,CasedRepo casedRepo) {
		this.engineerRepo = engineerRepo ;
		this.casedRepo = casedRepo ;
	}
	
	//GET-All Engineer
	@GetMapping("/engineers")
	public List<Engineer> retrieveEngineer() {
		return engineerRepo.findAll();
	}
	
	//GET-By Id
	@GetMapping("/engineers/{id}")
	public Optional<Engineer> retrieveEngineer(@PathVariable int id) {
		Optional<Engineer> engineer = engineerRepo.findById(id);
		if(engineer.isEmpty()) {
			throw new EngineerNotFoundException("id:" + id);
		}
		return engineer;
	}
	
	//GET -All Case	
	@GetMapping("/cased")
	public List<Cased> retrieveCased() {
		return casedRepo.findAll();
	}
	
	//GET -Cased By EngineerID
	@GetMapping("/engineers/{id}/cased")
	public List<Cased> retrievePostsForUser(@PathVariable int id) {
		Optional<Engineer> user = engineerRepo.findById(id);
		if(user.isEmpty())
			throw new EngineerNotFoundException("id:"+ id);
		return user.get().getCaseService();
	}
	
	//DELETE -Delete By Id
	@DeleteMapping("/engineers/{id}")
	public void deleteEngineer(@PathVariable int id) {
		engineerRepo.deleteById(id);
	}

	//POST -Create Engineer
	@PostMapping("/engineers")
	public ResponseEntity<Engineer> createEngineer(@RequestBody Engineer engineer) {
		Engineer savedEngineer = engineerRepo.save(engineer);
		// /Engineers/4 => /Engineers/{id},  Engineer.getID
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedEngineer.getId())
				.toUri();  
		return ResponseEntity.created(location).build();
		
	}

	
	
	
	
}



