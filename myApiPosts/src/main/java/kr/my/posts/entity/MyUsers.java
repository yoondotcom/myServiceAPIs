package kr.my.posts.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "MY_USERS", schema = "", catalog = "MY_MEMBER")
public class MyUsers {
    private String userCode;
    private String userName;
    private String userEmail;
    private String userNicename;
    private String userStatus;
    private String userActivationKey;
    private Timestamp userRegDate;
    private Timestamp userUptDate;
    private Collection<MyLikePosts> myLikePostsesByUserCode;
    private Collection<MyPosts> myPostsesByUserCode;
    private Collection<PostTags> postTagsesByUserCode;

    @Id
    @Column(name = "USER_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Basic
    @Column(name = "USER_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "USER_EMAIL", nullable = false, insertable = true, updatable = true, length = 100)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "USER_NICENAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getUserNicename() {
        return userNicename;
    }

    public void setUserNicename(String userNicename) {
        this.userNicename = userNicename;
    }

    @Basic
    @Column(name = "USER_STATUS", nullable = false, insertable = true, updatable = true, length = 20)
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @Basic
    @Column(name = "USER_ACTIVATION_KEY", nullable = false, insertable = true, updatable = true, length = 255)
    public String getUserActivationKey() {
        return userActivationKey;
    }

    public void setUserActivationKey(String userActivationKey) {
        this.userActivationKey = userActivationKey;
    }

    @Basic
    @Column(name = "USER_REG_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getUserRegDate() {
        return userRegDate;
    }

    public void setUserRegDate(Timestamp userRegDate) {
        this.userRegDate = userRegDate;
    }

    @Basic
    @Column(name = "USER_UPT_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getUserUptDate() {
        return userUptDate;
    }

    public void setUserUptDate(Timestamp userUptDate) {
        this.userUptDate = userUptDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyUsers myUsers = (MyUsers) o;

        if (userCode != null ? !userCode.equals(myUsers.userCode) : myUsers.userCode != null) return false;
        if (userName != null ? !userName.equals(myUsers.userName) : myUsers.userName != null) return false;
        if (userEmail != null ? !userEmail.equals(myUsers.userEmail) : myUsers.userEmail != null) return false;
        if (userNicename != null ? !userNicename.equals(myUsers.userNicename) : myUsers.userNicename != null)
            return false;
        if (userStatus != null ? !userStatus.equals(myUsers.userStatus) : myUsers.userStatus != null) return false;
        if (userActivationKey != null ? !userActivationKey.equals(myUsers.userActivationKey) : myUsers.userActivationKey != null)
            return false;
        if (userRegDate != null ? !userRegDate.equals(myUsers.userRegDate) : myUsers.userRegDate != null) return false;
        return userUptDate != null ? userUptDate.equals(myUsers.userUptDate) : myUsers.userUptDate == null;
    }

    @Override
    public int hashCode() {
        int result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userNicename != null ? userNicename.hashCode() : 0);
        result = 31 * result + (userStatus != null ? userStatus.hashCode() : 0);
        result = 31 * result + (userActivationKey != null ? userActivationKey.hashCode() : 0);
        result = 31 * result + (userRegDate != null ? userRegDate.hashCode() : 0);
        result = 31 * result + (userUptDate != null ? userUptDate.hashCode() : 0);
        return result;
    }


    @OneToMany(mappedBy = "myUsersByMyUsersUserCode")
    public Collection<MyLikePosts> getMyLikePostsesByUserCode() {
        return myLikePostsesByUserCode;
    }

    public void setMyLikePostsesByUserCode(Collection<MyLikePosts> myLikePostsesByUserCode) {
        this.myLikePostsesByUserCode = myLikePostsesByUserCode;
    }

    @OneToMany(mappedBy = "myUsersByMyUsersMemCode")
    public Collection<MyPosts> getMyPostsesByUserCode() {
        return myPostsesByUserCode;
    }

    public void setMyPostsesByUserCode(Collection<MyPosts> myPostsesByUserCode) {
        this.myPostsesByUserCode = myPostsesByUserCode;
    }

    @OneToMany(mappedBy = "myUsersByMyUsersUserCode")
    public Collection<PostTags> getPostTagsesByUserCode() {
        return postTagsesByUserCode;
    }

    public void setPostTagsesByUserCode(Collection<PostTags> postTagsesByUserCode) {
        this.postTagsesByUserCode = postTagsesByUserCode;
    }
}
