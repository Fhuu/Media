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

    public boolean login(String username, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<User> selectedUser = userRepository.findById(username);
        if(selectedUser.isPresent() &&
                encoder.matches(password, selectedUser.get().getPassword())) {

            return true;
        }
        return false;
    }

    public boolean usernameExist(String username) {
        return userRepository.existsById(username);
    }

    public User getUser(String username) {
        return userRepository.findById(username).get();
    }

}
