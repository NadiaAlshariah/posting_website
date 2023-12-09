package posting_website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posting_website.model.Comment;
import posting_website.repository.CommentRepository;

import java.util.List;
import java.util.Objects;

@Service
public class CommentService {
    CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments(){
        return commentRepository.findAll();
    }

    public void addComment(Comment comment){
        if (!(comment.getContent() == null) &&!comment.getContent().trim().isEmpty()){
            commentRepository.save(comment);
        }
        else{
            throw new IllegalStateException("Comment with id " + comment.getId() + "is empty");
        }
    }

    public void deleteComment(Long commentId){
        boolean exists = commentRepository.existsById(commentId);
        if (!exists){
            throw new IllegalStateException("Comment with id " + commentId + "does not exist");
        }
        commentRepository.deleteById(commentId);
    }

    public void updateComment(Long commentId, String newContent){
        Comment comment = commentRepository.findCommentById(commentId).orElseThrow(()->
                new IllegalStateException("Comment with id " + commentId + "does not exist"));
        if (newContent != null && !newContent.isEmpty()&&!Objects.equals(newContent, comment.getContent())){
            comment.setContent(newContent);
        }
    }
}
