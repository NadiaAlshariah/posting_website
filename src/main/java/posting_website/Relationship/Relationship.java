package posting_website.Relationship;

import jakarta.persistence.*;
import posting_website.User.AppUser;


@Entity
@Table
@IdClass(RelationshipId.class)
public class Relationship {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    @Id
    @ManyToOne
    @JoinColumn(name = "friend_id")
    private AppUser friend;

    private String status;

    public Relationship() {
    }

    public Relationship(String status) {
        this.status = status;
    }

    public Relationship(AppUser user, AppUser friend, String status) {
        this.user = user;
        this.friend = friend;
        this.status = status;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public AppUser getFriend() {
        return friend;
    }

    public void setFriend(AppUser friend) {
        this.friend = friend;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
