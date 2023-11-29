package posting_website.Reaction;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ReactionId implements Serializable {

    @Column(name = "user_id")
    private Long appUserId;

    @Column(name = "post_id")
    private Long postId;

    public ReactionId() {
    }

    public ReactionId(Long appUserId, Long postId) {
        this.appUserId = appUserId;
        this.postId = postId;
    }

    public Long getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Long appUserId) {
        this.appUserId = appUserId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
