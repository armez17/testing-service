package rest.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.webservices.restfulwebservices.user.Post;
import rest.webservices.restfulwebservices.user.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
