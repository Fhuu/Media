package Media.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/show")
    String showUsers() {
        return userService.showAllUser();
    }

    @PostMapping("/login")
    boolean login(@RequestBody Login login) {
        return userService.login(login.getUsername(), login.getPassword());
    }

    private static class Login {
        private String username, password;
        private Login(@JsonProperty("username")String username,
                      @JsonProperty("password")String password) {
            this.username = username;
            this.password = password;
        }

        private String getUsername() {
            return username;
        }

        private String getPassword() {
            return password;
        }
    }
}
