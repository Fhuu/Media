package Media.post;

import Media.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@SuppressWarnings("unused")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postId;
    @NotBlank
    @NotNull
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "timestamp default now()")
    private Date postTime;
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    public Post() {
    }

    public Post(@JsonProperty("text") String text,
    @JsonProperty("Media/user") User user) {
        this.content = text;
        this.user = user;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String text) {
        this.content = text;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "{" +
                "postId=" + postId +
                ", content='" + content + '\'' +
                ", postTime=" + postTime +
                ", user=" + user.getUsername() +
                '}';
    }
}
