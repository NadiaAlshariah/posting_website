package posting_website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import posting_website.model.AppUser;
import posting_website.model.Relationship;
import posting_website.model.id.RelationshipId;

import java.util.Optional;


@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, RelationshipId> {
    @Query("SELECT s FROM Relationship s WHERE s.user = ?1 AND s.friend = ?2")
    Optional<Relationship> findByUser(AppUser user, AppUser friend);
}
