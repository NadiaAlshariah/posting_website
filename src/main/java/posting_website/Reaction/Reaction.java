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

}
