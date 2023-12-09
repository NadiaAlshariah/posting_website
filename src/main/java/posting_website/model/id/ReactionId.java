package posting_website.model.id;

import posting_website.model.Post;
import posting_website.model.AppUser;

import java.io.Serializable;

public class ReactionId implements Serializable {
    private AppUser appUser;
    private Post post;

    public ReactionId() {
    }

    public ReactionId(AppUser appUser, Post post) {
        this.appUser = appUser;
        this.post = post;
    }

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
}
