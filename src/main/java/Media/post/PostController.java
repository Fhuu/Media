package Media.post;

import Media.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@SuppressWarnings("unused")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post/viewall")
    @ResponseBody
    Iterable<Post> showPost () {
        return postService.getAllPost();
    }

    @GetMapping("/post/view/{username}")
    String showPostFromId(@PathVariable("username") String username) {
        return postService.getPostByUsername(username);
    }
}
