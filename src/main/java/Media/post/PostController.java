package Media.post;

import Media.post.PostService;
import Media.user.UserRepository;
import Media.user.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@SuppressWarnings("unused")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

//    @PostMapping("/post/post")
//    public void post(String content, String username, @Autowired @Qualifier("UserRepository") UserRepository userRepository) {
//        postService.addPost(content, username, userRepository);
//    }

    @GetMapping("/post/viewall")
    @ResponseBody
    String showPost () {
        return postService.getAllPost();
    }

    @GetMapping("/post/view/{username}")
    String showPostFromId(@PathVariable("username") String username) {
        return postService.getPostByUsername(username);
    }

    @PostMapping("/post/add")
    void addPost(@RequestBody PostInput post) {
        postService.createPost(post.getContent(), post.getUsername());
    }

    private static class PostInput{
        String content, username;
        PostInput(@JsonProperty("content") String content, @JsonProperty("username") String username) {
            this.content = content;
            this.username= username;
        }

        public String getContent() {
            return content;
        }

        public String getUsername() {
            return username;
        }
    }
}
