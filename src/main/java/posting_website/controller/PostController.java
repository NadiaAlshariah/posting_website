package posting_website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import posting_website.service.PostService;
import posting_website.model.Post;

import java.util.List;

@RestController
@RequestMapping(path="Post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @PostMapping
    public void addNewPost(@RequestBody Post post){
        postService.addPost(post);
    }

    @DeleteMapping(path = "{postId}")
    public void deletePost(@PathVariable("postId") Long id){
        postService.deletePost(id);
    }

    @PutMapping(path = "{postId}")
    public void updatePost(
            @PathVariable("postId") Long postId,
            @RequestParam (required = true) String newContent){

        postService.updatePost(postId, newContent);
    }
}
