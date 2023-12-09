package posting_website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import posting_website.model.Post;
import posting_website.model.AppUser;
import posting_website.model.Reaction;
import posting_website.model.id.ReactionId;

import java.util.Optional;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, ReactionId> {
    @Query("SELECT s FROM Reaction s WHERE s.appUser = ?1AND s.post = ?2")
    Optional<Reaction> findReactionById(AppUser appUser, Post post);
}
