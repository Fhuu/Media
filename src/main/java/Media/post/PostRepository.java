package Media.post;

import Media.post.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("PostRepository")
public interface PostRepository extends CrudRepository<Post, Integer> {
}
