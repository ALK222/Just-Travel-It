
//Usar cada vez que se dropea el esquema en mySql

package is2.justtravelit.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import is2.justtravelit.entities.User;
import is2.justtravelit.repositories.UserRepository;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
	private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void initDatabase() {
    	
    	userRepository.save(new User("user", "0000000", "user@user", passwordEncoder.encode("pass"), "USER"));
		userRepository.save(new User("admin", "0000000", "admin@admin", passwordEncoder.encode("adminpass"), "USER", "ADMIN"));
    }
}
