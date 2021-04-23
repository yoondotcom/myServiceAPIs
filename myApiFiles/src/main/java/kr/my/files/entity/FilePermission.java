package kr.my.files.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by goodjwon on 16. 1. 16..
 * 파일에 접근 정책을 설정 한다.
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "filesRoleFileRoleSeq")
@Getter
@Entity
@Table(name = "FILE_PERMISSION")
public class FilePermission {

    @Id @Column(name = "FILE_ROLE_SEQ", nullable = false, insertable = true, updatable = true)
    private Long fileRoleSeq;
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

    @Builder
    public FilePermission(
            Integer fileOwnerPermissionRead,
            Integer ownerPermissionWrite,
            Integer groupPermissionRead,
            Integer groupPermissionWrite,
            Integer publicPermissionRead,
            Integer fileAllUserPermissionWrite,
            MyFiles myFileSeq) {
        this.ownerPermissionRead = fileOwnerPermissionRead;
        this.ownerPermissionWrite = ownerPermissionWrite;
        this.groupPermissionRead = groupPermissionRead;
        this.groupPermissionWrite = groupPermissionWrite;
        this.publicPermissionRead = publicPermissionRead;
        this.publicPermissionWrite = fileAllUserPermissionWrite;
    }
}
