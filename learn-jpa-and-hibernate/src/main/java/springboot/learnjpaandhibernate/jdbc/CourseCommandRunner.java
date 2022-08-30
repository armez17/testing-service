package springboot.learnjpaandhibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import springboot.learnjpaandhibernate.course.Course;
import springboot.learnjpaandhibernate.course.CourseJpaRepository;
import springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;


@Component
public class CourseCommandRunner implements CommandLineRunner {
	//@Autowired
	//private CourseJdbcRepository repository;
	//@Autowired
	//private CourseJpaRepository repository;
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1L,"LearnJDBC 555","Armez"));
		repository.save(new Course(2L,"LearnH2 555","Armez"));
		repository.save(new Course(3L,"LearnSpringDB 555","Armez"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("Armez"));
		System.out.println(repository.findByAuthor(""));
		
		System.out.println(repository.findByName("LearnH2 555"));
		System.out.println(repository.findByName(""));
	}

	
	
}
