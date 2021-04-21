package kr.my.files.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Entity
@Table(name = "MY_USERS")
public class MyUsers {
    @Id
    @Column(name = "USER_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    private String userCode;

    @Column(name = "USER_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    private String userName;

    @Column(name = "USER_EMAIL", nullable = false, insertable = true, updatable = true, length = 100)
    private String userEmail;

    @Column(name = "USER_NICENAME", nullable = false, insertable = true, updatable = true, length = 100)
    private String userNicename;

    @Column(name = "USER_STATUS", nullable = false, insertable = true, updatable = true, length = 20)
    private String userStatus;

    @Column(name = "USER_ACTIVATION_KEY", nullable = false, insertable = true, updatable = true, length = 255)
    private String userActivationKey;

    @Column(name = "USER_REG_DATE", nullable = false, insertable = true, updatable = true)
    private Timestamp userRegDate;

    @Column(name = "USER_UPT_DATE", nullable = true, insertable = true, updatable = true)
    private Timestamp userUptDate;

    @OneToMany(mappedBy = "myUsersByMyUsersUserCode")
    private Collection<MyFiles> myFilesByUserCode;

    @OneToMany(mappedBy = "myUsersByMyUsersUserCode")
    private Collection<UserFilePermissions> userFilePermissionsesByUserCode;

}
