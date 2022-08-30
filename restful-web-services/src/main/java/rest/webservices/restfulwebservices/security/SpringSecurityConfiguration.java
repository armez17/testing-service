package rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 1-all request should be authe
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		// 2-if a request is not authen, a web page is show
		http.httpBasic(withDefaults());
		// 3-CSRF -> POST, PUT
		http.csrf().disable();
		
		return http.build();
	}
	
	
	
	
}
