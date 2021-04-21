package kr.my.files.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "filesRoleFileRoleSeq")
@Getter
@Entity
@Table(name = "USER_FILE_PERMISSIONS", schema = "", catalog = "MY_MEMBER")
public class UserFilePermissions {
    @Id
    @Column(name = "FILES_ROLE_FILE_ROLE_SEQ", nullable = false, insertable = true, updatable = true)
    private Integer filesRoleFileRoleSeq;
    @Column(name = "FILE_OWNER_PERMISSION_READ", nullable = false, insertable = true, updatable = true, length = 1)
    private String fileOwnerPermissionRead;
    @Column(name = "FILE_OWNER_PERMISSION_WRITE", nullable = true, insertable = true, updatable = true, length = 1)
    private String fileOwnerPermissionWrite;
    @Column(name = "FILE_GROUP_PERMISSION_READ", nullable = false, insertable = true, updatable = true, length = 1)
    private String fileGroupPermissionRead;
    @Column(name = "FILE_GROUP_PERMISSION_WRITE", nullable = false, insertable = true, updatable = true, length = 1)
    private String fileGroupPermissionWrite;
    @Column(name = "FILE_ALLUSER_PERMISSION_READ", nullable = false, insertable = true, updatable = true, length = 1)
    private String fileAlluserPermissionRead;
    @Column(name = "FILE_ALLUSER_PERMISSION_WRITE", nullable = false, insertable = true, updatable = true, length = 1)
    private String fileAlluserPermissionWrite;
    @Column(name = "REG_DATE", nullable = true, insertable = true, updatable = true)
    private LocalDateTime regDate;
    @Column(name = "MY_USERS_USER_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    private LocalDateTime uptDate;
    @Column(name = "UPT_DATE", nullable = true, insertable = true, updatable = true)
    private String myUsersUserCode;
    private MyUsers myUsersByMyUsersUserCode;

    @ManyToOne
    @JoinColumn(name = "MY_USERS_USER_CODE", referencedColumnName = "USER_CODE", nullable = false)
    public MyUsers getMyUsersByMyUsersUserCode() {
        return myUsersByMyUsersUserCode;
    }


}
