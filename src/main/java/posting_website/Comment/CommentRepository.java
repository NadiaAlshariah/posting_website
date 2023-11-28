package posting_website.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import posting_website.Post.Post;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT s FROM Comment s WHERE s.id = ?1" )
    Optional<Comment> findCommentById(Long id);
}
