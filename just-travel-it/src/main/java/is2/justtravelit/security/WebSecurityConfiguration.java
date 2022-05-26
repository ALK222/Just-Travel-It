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
		
		http.csrf().disable();

		// UserRestController
		
		
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/login").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/signup").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/new/password").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/users").hasAnyRole("ADMIN");

		// ReservationRestController

		http.authorizeRequests().antMatchers(HttpMethod.POST,"/reservations").hasAnyRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/reservations").hasAnyRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.PUT,"/reservations").hasAnyRole("USER");
		
		// HotelRestController
		
		
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/hotels").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/hotels").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.PUT,"/hotels").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/hotels").hasAnyRole("ADMIN");
		
		
		//FlightRestController

		http.authorizeRequests().antMatchers(HttpMethod.POST,"/flights").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/flights").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.PUT,"/flights").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/flights").hasAnyRole("ADMIN");

		//AirportRestController

		http.authorizeRequests().antMatchers(HttpMethod.POST,"/airports").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/airports").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.PUT,"/airports").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/airports").hasAnyRole("ADMIN");


		
		
		
		// Login form
		http.formLogin().loginProcessingUrl("/login");
		
		
		
		
	}

}
