package kr.my.posts.entity;

import javax.persistence.*;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "POST_FILES", schema = "", catalog = "MY_MEMBER")
public class PostFiles {
    private Long fileSeq;
    private Long myPostsPostSeq;
    private String fileHashCode;
    private MyPosts myPostsByMyPostsPostSeq;

    @Id
    @Column(name = "FILE_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getFileSeq() {
        return fileSeq;
    }

    public void setFileSeq(Long fileSeq) {
        this.fileSeq = fileSeq;
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
    @Column(name = "FILE_HASH_CODE", nullable = true, insertable = true, updatable = true, length = 255)
    public String getFileHashCode() {
        return fileHashCode;
    }

    public void setFileHashCode(String fileHashCode) {
        this.fileHashCode = fileHashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostFiles postFiles = (PostFiles) o;

        if (fileSeq != null ? !fileSeq.equals(postFiles.fileSeq) : postFiles.fileSeq != null) return false;
        if (myPostsPostSeq != null ? !myPostsPostSeq.equals(postFiles.myPostsPostSeq) : postFiles.myPostsPostSeq != null)
            return false;
        if (fileHashCode != null ? !fileHashCode.equals(postFiles.fileHashCode) : postFiles.fileHashCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fileSeq != null ? fileSeq.hashCode() : 0;
        result = 31 * result + (myPostsPostSeq != null ? myPostsPostSeq.hashCode() : 0);
        result = 31 * result + (fileHashCode != null ? fileHashCode.hashCode() : 0);
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
