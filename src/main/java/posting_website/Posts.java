package posting_website;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Posts {
    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )
    private Long id;
    private Long userId;
    private String content;
    private Date timePosted;
    private Long likesNumber;
    private Long commentsNumber;

    public Posts() {
    }

    public Posts(Long id, Long userId, String content, Date timePosted, Long likesNumber, Long commentsNumber) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.timePosted = timePosted;
        this.likesNumber = likesNumber;
        this.commentsNumber = commentsNumber;
    }

    public Posts(Long userId, String content, Date timePosted, Long likesNumber, Long commentsNumber) {
        this.userId = userId;
        this.content = content;
        this.timePosted = timePosted;
        this.likesNumber = likesNumber;
        this.commentsNumber = commentsNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
