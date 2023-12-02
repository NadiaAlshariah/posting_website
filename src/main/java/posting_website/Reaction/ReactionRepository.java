package posting_website.Reaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import posting_website.Post.Post;
import posting_website.User.AppUser;
import java.util.Optional;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, ReactionId> {
    @Query("SELECT s FROM Reaction s WHERE s.appUser = ?1AND s.post = ?2")
    Optional<Reaction> findReactionById(AppUser appUser, Post post);
}
