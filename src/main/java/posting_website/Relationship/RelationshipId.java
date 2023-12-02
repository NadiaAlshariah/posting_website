package posting_website.Relationship;

import posting_website.User.AppUser;

import java.io.Serializable;

public class RelationshipId implements Serializable {
    private AppUser user;
    private AppUser friend;

    public RelationshipId() {
    }

    public RelationshipId(AppUser user, AppUser friend) {
        this.user = user;
        this.friend = friend;
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

}
