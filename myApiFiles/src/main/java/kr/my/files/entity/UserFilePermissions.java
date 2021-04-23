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
 * 사용자 기본 퍼미션 정책을 저장 한다.
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "filesRoleFileRoleSeq")
@Getter
@Entity
@Table(name = "USER_FILE_PERMISSIONS")
public class UserFilePermissions {

    @Id @GeneratedValue @Column(name = "USER_ROLE_SEQ", nullable = false, insertable = true, updatable = true)
    private Long userDefaultPermissionSeq;
    @Column(name = "OWNER_PERMISSION_READ", nullable = false, insertable = true, updatable = true, length = 1)
    private Integer ownerPermissionRead;
    @Column(name = "OWNER_PERMISSION_WRITE", nullable = false, insertable = true, updatable = true, length = 1)
    private Integer ownerPermissionWrite;
    @Column(name = "GROUP_PERMISSION_READ", nullable = false, insertable = true, updatable = true, length = 1)
    private Integer groupPermissionRead;
    @Column(name = "GROUP_PERMISSION_WRITE", nullable = false, insertable = true, updatable = true, length = 1)
    private Integer groupPermissionWrite;
    @Column(name = "PUBLIC_PERMISSION_READ", nullable = false, insertable = true, updatable = true, length = 1)
    private Integer publicPermissionRead;
    @Column(name = "PUBLIC_PERMISSION_WRITE", nullable = false, insertable = true, updatable = true, length = 1)
    private Integer publicPermissionWrite;
    @Column(name = "REG_DATE", nullable = false, insertable = true, updatable = true)
    private LocalDateTime regDate;
    @Column(name = "UPT_DATE", nullable = true, insertable = true, updatable = true)
    private LocalDateTime uptDate;

    @ManyToOne
    @JoinColumn(name = "MY_USERS_USER_CODE", referencedColumnName = "USER_CODE", nullable = false)
    private MyUsers myUsersByUserCode;

    public UserFilePermissions(Integer ownerPermissionRead, Integer ownerPermissionWrite,
                               Integer groupPermissionRead, Integer groupPermissionWrite,
                               Integer publicPermissionRead, Integer publicPermissionWrite,
                               MyUsers myUsersByUserCode) {
        this.ownerPermissionRead = ownerPermissionRead;
        this.ownerPermissionWrite = ownerPermissionWrite;
        this.groupPermissionRead = groupPermissionRead;
        this.groupPermissionWrite = groupPermissionWrite;
        this.publicPermissionRead = publicPermissionRead;
        this.publicPermissionWrite = publicPermissionWrite;
        this.myUsersByUserCode = myUsersByUserCode;
    }
}
