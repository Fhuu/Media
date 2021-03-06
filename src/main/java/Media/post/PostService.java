package Media.post;

import Media.post.PostRepository;
import Media.user.User;
import Media.user.UserRepository;
import Media.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
@SuppressWarnings("unused")
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService (@Qualifier("PostRepository") PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    String getPost(Integer postId) {
        return postRepository.findById(postId).get().getContent();
    }

    String getAllPost() {
        Iterable<Post> posts = postRepository.findAll();
        String result = "[";
        for(Post post : posts) {
            result = result + post.toString() + ", ";
        }
        return result.substring(0, result.length()-2) + "]";
    }

    String getPostByUsername(String username) {
        String result = "";
        for(Post post : postRepository.findAll()) {
            if(post.getUser().getUsername().equals(username)) {
                result = result + ", " + post.toString();
            }
        }
        return result.substring(2,result.length());
    }

    void createPost(String text, String username) {

        try {
            Connection conn =
                    DriverManager.getConnection("jdbc:mariadb://localhost:3306/media", "myadmin","sql");
            String query = "insert into post values(" +
                    "default, \'" + text + "\', default, \'" + username +
                    "\');";
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
