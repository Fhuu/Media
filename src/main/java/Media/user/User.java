package Media.user;

import Media.post.Post;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@SuppressWarnings("unused")
public class User {

    @Id
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    private String name;

    public User(@JsonProperty("username") String username,
                @JsonProperty("password")String password,
                @JsonProperty("name") String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "\"username\" : \"" + username + '\"' +
                ", \"name\" : \"" + name + '\"' +
                '}';
    }
}
