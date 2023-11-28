package posting_website.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class PostService {
    PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    public void addPost(Post post){
        post.setTimePosted(new Date());
        if (!post.getContent().isEmpty()){
            postRepository.save(post);
        }
        else {
            throw new IllegalStateException("post with id " + post.getId() + " is empty");
        }
    }

    public void deletePost(Long postId) {
        boolean exists = postRepository.existsById(postId);
        if (!exists){
            throw new IllegalStateException("Post with id " + postId + "does not exist");
        }
        postRepository.deleteById(postId);
    }

    public void updatePost(Long postId, String newContent){
        Post post = postRepository.findPostById(postId).orElseThrow(() -> new IllegalStateException(
                "post with id " + postId + " doesnt exist"));

        if (newContent != null && !newContent.isEmpty() && !Objects.equals(newContent, post.getContent())){
            post.setContent(newContent);
        }

    }
}
