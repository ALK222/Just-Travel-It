package is2.justtravelit.security;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	RepositoryUserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// UserRestController
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/flights").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/signup").anonymous();
		http.authorizeRequests().antMatchers("/new/password").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/users").hasAnyRole("ADMIN");

		// ReservationRestController

		http.authorizeRequests().antMatchers("/reservations").permitAll();
		http.authorizeRequests().antMatchers("/reservations").permitAll();
		http.authorizeRequests().antMatchers("/reservations").permitAll();
		
		// HotelRestController
		
		http.authorizeRequests().antMatchers("/hotels").permitAll();
		
		//FlightRestController

		http.authorizeRequests().antMatchers("/flights").permitAll();

		//AirportRestController

		http.authorizeRequests().antMatchers("/airports").permitAll();


		
		
		
		// Login form
		http.formLogin().loginProcessingUrl("/login");
		
		
		
		
	}

}
