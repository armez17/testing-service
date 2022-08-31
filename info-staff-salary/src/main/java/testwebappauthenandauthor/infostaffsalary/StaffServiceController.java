package testwebappauthenandauthor.infostaffsalary;


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
public class StaffServiceController {

	private StaffRepo staffRepo;

	public StaffServiceController(StaffRepo staffRepo) {
		this.staffRepo = staffRepo ;
	}
	
	@GetMapping("/info")
	public List<Staff> retrieveEngineer() {
		return staffRepo.findAll();
	}
	
	@GetMapping("/info/{id}")
	public Optional<Staff> retrieveStaff(@PathVariable int id) {
		Optional<Staff> staff = staffRepo.findById(id);
		if(staff.isEmpty()) {
			throw new StaffNotFoundException("id:" + id);
		}
		return staff;
	}

	@DeleteMapping("/info/{id}")
	public void deleteStaff(@PathVariable int id) {
		staffRepo.deleteById(id);
	}

	@PostMapping("/info")
	public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
		Staff savedStaff = staffRepo.save(staff);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedStaff.getId())
				.toUri();  
		return ResponseEntity.created(location).build();		
	}
	
	
	
}



