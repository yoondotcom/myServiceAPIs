package kr.my.posts.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "MY_LIKE_POSTS", schema = "", catalog = "MY_MEMBER")
public class MyLikePosts {
    private Long likeSeq;
    private String myUsersUserCode;
    private Long myPostsPostSeq;
    private Timestamp regDate;
    private MyUsers myUsersByMyUsersUserCode;
    private MyPosts myPostsByMyPostsPostSeq;

    @Id
    @Column(name = "LIKE_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getLikeSeq() {
        return likeSeq;
    }

    public void setLikeSeq(Long likeSeq) {
        this.likeSeq = likeSeq;
    }

    @Basic
    @Column(name = "MY_USERS_USER_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getMyUsersUserCode() {
        return myUsersUserCode;
    }

    public void setMyUsersUserCode(String myUsersUserCode) {
        this.myUsersUserCode = myUsersUserCode;
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
    @Column(name = "REG_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyLikePosts that = (MyLikePosts) o;

        if (likeSeq != null ? !likeSeq.equals(that.likeSeq) : that.likeSeq != null) return false;
        if (myUsersUserCode != null ? !myUsersUserCode.equals(that.myUsersUserCode) : that.myUsersUserCode != null)
            return false;
        if (myPostsPostSeq != null ? !myPostsPostSeq.equals(that.myPostsPostSeq) : that.myPostsPostSeq != null)
            return false;
        return regDate != null ? regDate.equals(that.regDate) : that.regDate == null;
    }

    @Override
    public int hashCode() {
        int result = likeSeq != null ? likeSeq.hashCode() : 0;
        result = 31 * result + (myUsersUserCode != null ? myUsersUserCode.hashCode() : 0);
        result = 31 * result + (myPostsPostSeq != null ? myPostsPostSeq.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MY_USERS_USER_CODE", referencedColumnName = "USER_CODE", nullable = false)
    public MyUsers getMyUsersByMyUsersUserCode() {
        return myUsersByMyUsersUserCode;
    }

    public void setMyUsersByMyUsersUserCode(MyUsers myUsersByMyUsersUserCode) {
        this.myUsersByMyUsersUserCode = myUsersByMyUsersUserCode;
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
