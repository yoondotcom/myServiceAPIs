package kr.my.posts.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "POST_TAGS", schema = "", catalog = "MY_MEMBER")
public class PostTags {
    private Long tagSeq;
    private String tagName;
    private Timestamp regDate;
    private Long myPostsPostSeq;
    private String myUsersUserCode;
    private MyPosts myPostsByMyPostsPostSeq;
    private MyUsers myUsersByMyUsersUserCode;

    @Id
    @Column(name = "TAG_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getTagSeq() {
        return tagSeq;
    }

    public void setTagSeq(Long tagSeq) {
        this.tagSeq = tagSeq;
    }

    @Basic
    @Column(name = "TAG_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Basic
    @Column(name = "REG_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
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
    @Column(name = "MY_USERS_USER_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getMyUsersUserCode() {
        return myUsersUserCode;
    }

    public void setMyUsersUserCode(String myUsersUserCode) {
        this.myUsersUserCode = myUsersUserCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostTags postTags = (PostTags) o;

        if (tagSeq != null ? !tagSeq.equals(postTags.tagSeq) : postTags.tagSeq != null) return false;
        if (tagName != null ? !tagName.equals(postTags.tagName) : postTags.tagName != null) return false;
        if (regDate != null ? !regDate.equals(postTags.regDate) : postTags.regDate != null) return false;
        if (myPostsPostSeq != null ? !myPostsPostSeq.equals(postTags.myPostsPostSeq) : postTags.myPostsPostSeq != null)
            return false;
        return myUsersUserCode != null ? myUsersUserCode.equals(postTags.myUsersUserCode) : postTags.myUsersUserCode == null;
    }

    @Override
    public int hashCode() {
        int result = tagSeq != null ? tagSeq.hashCode() : 0;
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        result = 31 * result + (myPostsPostSeq != null ? myPostsPostSeq.hashCode() : 0);
        result = 31 * result + (myUsersUserCode != null ? myUsersUserCode.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "MY_USERS_USER_CODE", referencedColumnName = "USER_CODE", nullable = false)
    public MyUsers getMyUsersByMyUsersUserCode() {
        return myUsersByMyUsersUserCode;
    }

    public void setMyUsersByMyUsersUserCode(MyUsers myUsersByMyUsersUserCode) {
        this.myUsersByMyUsersUserCode = myUsersByMyUsersUserCode;
    }
}
