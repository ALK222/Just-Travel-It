package is2.justtravelit.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import is2.justtravelit.entities.User;
import is2.justtravelit.repositories.UserRepository;

@Service
public class RepositoryUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = null;
		try {
			user = userRepository.findByName(username);
		} catch (UsernameNotFoundException e) {
			e = new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> roles = new ArrayList<>();
		for (String role : user.getRoles()) {
			roles.add(new SimpleGrantedAuthority("ROLE_" + role));
		}

		return new org.springframework.security.core.userdetails.User(user.getName(), 
				user.getPassword(), roles);

	}
}
