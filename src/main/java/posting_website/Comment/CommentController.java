package posting_website.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="Comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getComments(){
        return commentService.getComments();
    }
    @PostMapping
    public void addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
    }
    @DeleteMapping(path = "{commentId}")
    public void deleteComment(@PathVariable("commentId") Long id){
        commentService.deleteComment(id);
    }

    @PutMapping(path = "{commentId}")
    public void updateComment(
            @PathVariable("commentId") Long id,
            @RequestParam(required = true) String newContent
    ){
        commentService.updateComment(id, newContent);
    }
}
