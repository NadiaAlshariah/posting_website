package posting_website.Relationship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import posting_website.User.AppUser;

import java.util.Optional;

@Repository
public interface RelationsipRepository extends JpaRepository<Relationship, AppUser> {
    @Query("SELECT s FROM Relationship s WHERE s.user = ? AND s.friend = ?1")
    Optional<Relationship> findByUser(AppUser user, AppUser friend);
}
