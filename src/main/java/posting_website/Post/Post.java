package posting_website.Post;

import jakarta.persistence.*;
import posting_website.User.AppUser;

import java.util.Date;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String content;
    private Date timePosted;
    private Long likesNumber;
    private Long commentsNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;

    public Post() {
    }

    public Post(Long id, String content, Date timePosted, Long likesNumber, Long commentsNumber, AppUser appUser) {
        this.id = id;
        this.content = content;
        this.timePosted = timePosted;
        this.likesNumber = likesNumber;
        this.commentsNumber = commentsNumber;
        this.appUser = appUser;
    }

    public Post(String content, Date timePosted, Long likesNumber, Long commentsNumber, AppUser appUser) {
        this.content = content;
        this.timePosted = timePosted;
        this.likesNumber = likesNumber;
        this.commentsNumber = commentsNumber;
        this.appUser = appUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(Date timePosted) {
        this.timePosted = timePosted;
    }

    public Long getLikesNumber() {
        return likesNumber;
    }

    public void setLikesNumber(Long likesNumber) {
        this.likesNumber = likesNumber;
    }

    public Long getCommentsNumber() {
        return commentsNumber;
    }

    public void setCommentsNumber(Long commentsNumber) {
        this.commentsNumber = commentsNumber;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
