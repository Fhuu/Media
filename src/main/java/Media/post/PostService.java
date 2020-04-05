package Media.post;

import Media.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;

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
        String result = "";
        for(Post post : posts) {
            result = result + post.toString();
        }
        return result;
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
}
