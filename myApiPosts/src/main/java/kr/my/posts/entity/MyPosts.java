package kr.my.posts.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "MY_POSTS", schema = "", catalog = "MY_MEMBER")
public class MyPosts {
    private Long postSeq;
    private String myUsersMemCode;
    private String memName;
    private String memNickName;
    private Timestamp postDate;
    private String postContents;
    private String postTitle;
    private String postExcerpt;
    private String postStatus;
    private String postPassword;
    private Timestamp postModified;
    private Long postParent;
    private String postType;
    private String postMineType;
    private String commentStatus;
    private String commontCnt;
    private String postRole;
    private Collection<MyLikePosts> myLikePostsesByPostSeq;
    private MyUsers myUsersByMyUsersMemCode;
    private Collection<PostCommnets> postCommnetsesByPostSeq;
    private Collection<PostFiles> postFilesByPostSeq;
    private Collection<PostTags> postTagsesByPostSeq;

    @Id
    @Column(name = "POST_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getPostSeq() {
        return postSeq;
    }

    public void setPostSeq(Long postSeq) {
        this.postSeq = postSeq;
    }

    @Basic
    @Column(name = "MY_USERS_MEM_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getMyUsersMemCode() {
        return myUsersMemCode;
    }

    public void setMyUsersMemCode(String myUsersMemCode) {
        this.myUsersMemCode = myUsersMemCode;
    }

    @Basic
    @Column(name = "MEM_NAME", nullable = false, insertable = true, updatable = true, length = 45)
    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    @Basic
    @Column(name = "MEM_NICK_NAME", nullable = false, insertable = true, updatable = true, length = 45)
    public String getMemNickName() {
        return memNickName;
    }

    public void setMemNickName(String memNickName) {
        this.memNickName = memNickName;
    }

    @Basic
    @Column(name = "POST_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    @Basic
    @Column(name = "POST_CONTENTS", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getPostContents() {
        return postContents;
    }

    public void setPostContents(String postContents) {
        this.postContents = postContents;
    }

    @Basic
    @Column(name = "POST_TITLE", nullable = false, insertable = true, updatable = true, length = 1000)
    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    @Basic
    @Column(name = "POST_EXCERPT", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPostExcerpt() {
        return postExcerpt;
    }

    public void setPostExcerpt(String postExcerpt) {
        this.postExcerpt = postExcerpt;
    }

    @Basic
    @Column(name = "POST_STATUS", nullable = false, insertable = true, updatable = true, length = 3)
    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    @Basic
    @Column(name = "POST_PASSWORD", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPostPassword() {
        return postPassword;
    }

    public void setPostPassword(String postPassword) {
        this.postPassword = postPassword;
    }

    @Basic
    @Column(name = "POST_MODIFIED", nullable = false, insertable = true, updatable = true)
    public Timestamp getPostModified() {
        return postModified;
    }

    public void setPostModified(Timestamp postModified) {
        this.postModified = postModified;
    }

    @Basic
    @Column(name = "POST_PARENT", nullable = false, insertable = true, updatable = true)
    public Long getPostParent() {
        return postParent;
    }

    public void setPostParent(Long postParent) {
        this.postParent = postParent;
    }

    @Basic
    @Column(name = "POST_TYPE", nullable = false, insertable = true, updatable = true, length = 3)
    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    @Basic
    @Column(name = "POST_MINE_TYPE", nullable = false, insertable = true, updatable = true, length = 100)
    public String getPostMineType() {
        return postMineType;
    }

    public void setPostMineType(String postMineType) {
        this.postMineType = postMineType;
    }

    @Basic
    @Column(name = "COMMENT_STATUS", nullable = false, insertable = true, updatable = true, length = 45)
    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    @Basic
    @Column(name = "COMMONT_CNT", nullable = false, insertable = true, updatable = true, length = 45)
    public String getCommontCnt() {
        return commontCnt;
    }

    public void setCommontCnt(String commontCnt) {
        this.commontCnt = commontCnt;
    }

    @Basic
    @Column(name = "POST_ROLE", nullable = true, insertable = true, updatable = true, length = 45)
    public String getPostRole() {
        return postRole;
    }

    public void setPostRole(String postRole) {
        this.postRole = postRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyPosts myPosts = (MyPosts) o;

        if (postSeq != null ? !postSeq.equals(myPosts.postSeq) : myPosts.postSeq != null) return false;
        if (myUsersMemCode != null ? !myUsersMemCode.equals(myPosts.myUsersMemCode) : myPosts.myUsersMemCode != null)
            return false;
        if (memName != null ? !memName.equals(myPosts.memName) : myPosts.memName != null) return false;
        if (memNickName != null ? !memNickName.equals(myPosts.memNickName) : myPosts.memNickName != null) return false;
        if (postDate != null ? !postDate.equals(myPosts.postDate) : myPosts.postDate != null) return false;
        if (postContents != null ? !postContents.equals(myPosts.postContents) : myPosts.postContents != null)
            return false;
        if (postTitle != null ? !postTitle.equals(myPosts.postTitle) : myPosts.postTitle != null) return false;
        if (postExcerpt != null ? !postExcerpt.equals(myPosts.postExcerpt) : myPosts.postExcerpt != null) return false;
        if (postStatus != null ? !postStatus.equals(myPosts.postStatus) : myPosts.postStatus != null) return false;
        if (postPassword != null ? !postPassword.equals(myPosts.postPassword) : myPosts.postPassword != null)
            return false;
        if (postModified != null ? !postModified.equals(myPosts.postModified) : myPosts.postModified != null)
            return false;
        if (postParent != null ? !postParent.equals(myPosts.postParent) : myPosts.postParent != null) return false;
        if (postType != null ? !postType.equals(myPosts.postType) : myPosts.postType != null) return false;
        if (postMineType != null ? !postMineType.equals(myPosts.postMineType) : myPosts.postMineType != null)
            return false;
        if (commentStatus != null ? !commentStatus.equals(myPosts.commentStatus) : myPosts.commentStatus != null)
            return false;
        if (commontCnt != null ? !commontCnt.equals(myPosts.commontCnt) : myPosts.commontCnt != null) return false;
        return postRole != null ? postRole.equals(myPosts.postRole) : myPosts.postRole == null;
    }

    @Override
    public int hashCode() {
        int result = postSeq != null ? postSeq.hashCode() : 0;
        result = 31 * result + (myUsersMemCode != null ? myUsersMemCode.hashCode() : 0);
        result = 31 * result + (memName != null ? memName.hashCode() : 0);
        result = 31 * result + (memNickName != null ? memNickName.hashCode() : 0);
        result = 31 * result + (postDate != null ? postDate.hashCode() : 0);
        result = 31 * result + (postContents != null ? postContents.hashCode() : 0);
        result = 31 * result + (postTitle != null ? postTitle.hashCode() : 0);
        result = 31 * result + (postExcerpt != null ? postExcerpt.hashCode() : 0);
        result = 31 * result + (postStatus != null ? postStatus.hashCode() : 0);
        result = 31 * result + (postPassword != null ? postPassword.hashCode() : 0);
        result = 31 * result + (postModified != null ? postModified.hashCode() : 0);
        result = 31 * result + (postParent != null ? postParent.hashCode() : 0);
        result = 31 * result + (postType != null ? postType.hashCode() : 0);
        result = 31 * result + (postMineType != null ? postMineType.hashCode() : 0);
        result = 31 * result + (commentStatus != null ? commentStatus.hashCode() : 0);
        result = 31 * result + (commontCnt != null ? commontCnt.hashCode() : 0);
        result = 31 * result + (postRole != null ? postRole.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "myPostsByMyPostsPostSeq")
    public Collection<MyLikePosts> getMyLikePostsesByPostSeq() {
        return myLikePostsesByPostSeq;
    }

    public void setMyLikePostsesByPostSeq(Collection<MyLikePosts> myLikePostsesByPostSeq) {
        this.myLikePostsesByPostSeq = myLikePostsesByPostSeq;
    }

    @ManyToOne
    @JoinColumn(name = "MY_USERS_MEM_CODE", referencedColumnName = "USER_CODE", nullable = false)
    public MyUsers getMyUsersByMyUsersMemCode() {
        return myUsersByMyUsersMemCode;
    }

    public void setMyUsersByMyUsersMemCode(MyUsers myUsersByMyUsersMemCode) {
        this.myUsersByMyUsersMemCode = myUsersByMyUsersMemCode;
    }

    @OneToMany(mappedBy = "myPostsByMyPostsPostSeq")
    public Collection<PostCommnets> getPostCommnetsesByPostSeq() {
        return postCommnetsesByPostSeq;
    }

    public void setPostCommnetsesByPostSeq(Collection<PostCommnets> postCommnetsesByPostSeq) {
        this.postCommnetsesByPostSeq = postCommnetsesByPostSeq;
    }

    @OneToMany(mappedBy = "myPostsByMyPostsPostSeq")
    public Collection<PostFiles> getPostFilesByPostSeq() {
        return postFilesByPostSeq;
    }

    public void setPostFilesByPostSeq(Collection<PostFiles> postFilesByPostSeq) {
        this.postFilesByPostSeq = postFilesByPostSeq;
    }

    @OneToMany(mappedBy = "myPostsByMyPostsPostSeq")
    public Collection<PostTags> getPostTagsesByPostSeq() {
        return postTagsesByPostSeq;
    }

    public void setPostTagsesByPostSeq(Collection<PostTags> postTagsesByPostSeq) {
        this.postTagsesByPostSeq = postTagsesByPostSeq;
    }
}
