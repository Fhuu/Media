package Media.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@SuppressWarnings("unused")
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(@Qualifier("UserRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String showAllUser() {
        return userRepository.findAll().toString();
    }

    public String createUser(User user) {
        if(usernameExist(user.getUsername())) {
            return "Existing username! Please log in if it is you or take another username!";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "Account created, " + user.getUsername() + "! Please log in to try this website!";
    }

    public String login(String username, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(userRepository.findById(username).isPresent() &&
                encoder.matches(password, userRepository.findById(username).get().getPassword())) {
            return userRepository.findById(username).get().toString();
        }
        return "USERNAME OR PASSWORD IS FALSE";
    }

    public boolean usernameExist(String username) {
        return userRepository.existsById(username);
    }

}
