package kr.my.posts.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "POST_COMMNETS", schema = "", catalog = "MY_MEMBER")
public class PostCommnets {
    private Long commentSeq;
    private Long myPostsPostSeq;
    private String commntContents;
    private String commentEmail;
    private String commentPassword;
    private String commentIp;
    private String commentUrl;
    private Timestamp commentRegDate;
    private Timestamp commentUptDate;
    private MyPosts myPostsByMyPostsPostSeq;

    @Id
    @Column(name = "COMMENT_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getCommentSeq() {
        return commentSeq;
    }

    public void setCommentSeq(Long commentSeq) {
        this.commentSeq = commentSeq;
    }

    @Basic
    @Column(name = "MY_POSTS_POST_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getMyPostsPostSeq() {
        return myPostsPostSeq;
    }

    public void setMyPostsPostSeq(Long myPostsPostSeq) {
        this.myPostsPostSeq = myPostsPostSeq;
    }

    @Basic
    @Column(name = "COMMNT_CONTENTS", nullable = false, insertable = true, updatable = true, length = 65535)
    public String getCommntContents() {
        return commntContents;
    }

    public void setCommntContents(String commntContents) {
        this.commntContents = commntContents;
    }

    @Basic
    @Column(name = "COMMENT_EMAIL", nullable = true, insertable = true, updatable = true, length = 45)
    public String getCommentEmail() {
        return commentEmail;
    }

    public void setCommentEmail(String commentEmail) {
        this.commentEmail = commentEmail;
    }

    @Basic
    @Column(name = "COMMENT_PASSWORD", nullable = true, insertable = true, updatable = true, length = 45)
    public String getCommentPassword() {
        return commentPassword;
    }

    public void setCommentPassword(String commentPassword) {
        this.commentPassword = commentPassword;
    }

    @Basic
    @Column(name = "COMMENT_IP", nullable = true, insertable = true, updatable = true, length = 45)
    public String getCommentIp() {
        return commentIp;
    }

    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp;
    }

    @Basic
    @Column(name = "COMMENT_URL", nullable = true, insertable = true, updatable = true, length = 45)
    public String getCommentUrl() {
        return commentUrl;
    }

    public void setCommentUrl(String commentUrl) {
        this.commentUrl = commentUrl;
    }

    @Basic
    @Column(name = "COMMENT_REG_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getCommentRegDate() {
        return commentRegDate;
    }

    public void setCommentRegDate(Timestamp commentRegDate) {
        this.commentRegDate = commentRegDate;
    }

    @Basic
    @Column(name = "COMMENT_UPT_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getCommentUptDate() {
        return commentUptDate;
    }

    public void setCommentUptDate(Timestamp commentUptDate) {
        this.commentUptDate = commentUptDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostCommnets that = (PostCommnets) o;

        if (commentSeq != null ? !commentSeq.equals(that.commentSeq) : that.commentSeq != null) return false;
        if (myPostsPostSeq != null ? !myPostsPostSeq.equals(that.myPostsPostSeq) : that.myPostsPostSeq != null)
            return false;
        if (commntContents != null ? !commntContents.equals(that.commntContents) : that.commntContents != null)
            return false;
        if (commentEmail != null ? !commentEmail.equals(that.commentEmail) : that.commentEmail != null) return false;
        if (commentPassword != null ? !commentPassword.equals(that.commentPassword) : that.commentPassword != null)
            return false;
        if (commentIp != null ? !commentIp.equals(that.commentIp) : that.commentIp != null) return false;
        if (commentUrl != null ? !commentUrl.equals(that.commentUrl) : that.commentUrl != null) return false;
        if (commentRegDate != null ? !commentRegDate.equals(that.commentRegDate) : that.commentRegDate != null)
            return false;
        return commentUptDate != null ? commentUptDate.equals(that.commentUptDate) : that.commentUptDate == null;
    }

    @Override
    public int hashCode() {
        int result = commentSeq != null ? commentSeq.hashCode() : 0;
        result = 31 * result + (myPostsPostSeq != null ? myPostsPostSeq.hashCode() : 0);
        result = 31 * result + (commntContents != null ? commntContents.hashCode() : 0);
        result = 31 * result + (commentEmail != null ? commentEmail.hashCode() : 0);
        result = 31 * result + (commentPassword != null ? commentPassword.hashCode() : 0);
        result = 31 * result + (commentIp != null ? commentIp.hashCode() : 0);
        result = 31 * result + (commentUrl != null ? commentUrl.hashCode() : 0);
        result = 31 * result + (commentRegDate != null ? commentRegDate.hashCode() : 0);
        result = 31 * result + (commentUptDate != null ? commentUptDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MY_POSTS_POST_SEQ", referencedColumnName = "POST_SEQ", nullable = false)
    public MyPosts getMyPostsByMyPostsPostSeq() {
        return myPostsByMyPostsPostSeq;
    }

    public void setMyPostsByMyPostsPostSeq(MyPosts myPostsByMyPostsPostSeq) {
        this.myPostsByMyPostsPostSeq = myPostsByMyPostsPostSeq;
    }
}
