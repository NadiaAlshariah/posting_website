package posting_website.Reaction;

import jakarta.persistence.*;
import posting_website.Post.Post;
import posting_website.User.AppUser;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Reaction {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;

    @Id
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    private String type;

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
