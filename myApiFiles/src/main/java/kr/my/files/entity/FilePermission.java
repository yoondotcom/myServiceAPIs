package kr.my.files.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "filesRoleFileRoleSeq")
@Getter
@Entity
@Table(name = "FILE_PERMISSION")
public class FilePermission {

    @Id @Column(name = "FILES_ROLE_FILE_ROLE_SEQ", nullable = false, insertable = true, updatable = true)
    private Long filesRoleFileRoleSeq;
    @Column(name = "FILE_OWNER_PERMISSION_READ", nullable = false, insertable = true, updatable = true, length = 1)
    private String fileOwnerPermissionRead;
    @Column(name = "FILE_OWNER_PERMISSION_WRITE", nullable = false, insertable = true, updatable = true, length = 1)
    private String fileOwnerPermissionWrite;
    @Column(name = "FILE_GROUP_PERMISSION_READ", nullable = false, insertable = true, updatable = true, length = 1)
    private String fileGroupPermissionRead;
    @Column(name = "FILE_GROUP_PERMISSION_WRITE", nullable = false, insertable = true, updatable = true, length = 1)
    private String fileGroupPermissionWrite;
    @Column(name = "FILE_ALLUSER_PERMISSION_READ", nullable = false, insertable = true, updatable = true, length = 1)
    private String fileAlluserPermissionRead;
    @Column(name = "FILE_ALLUSER_PERMISSION_WRITE", nullable = false, insertable = true, updatable = true, length = 1)
    private String fileAlluserPermissionWrite;
    @Column(name = "REG_DATE", nullable = false, insertable = true, updatable = true)
    private Timestamp regDate;
    @Column(name = "UPT_DATE", nullable = true, insertable = true, updatable = true)
    private Timestamp uptDate;

    @ManyToOne
    @JoinColumn(name = "MY_FILES_FILE_SEQ", referencedColumnName = "FILE_SEQ", nullable = false)
    private MyFiles myFilesByMyFilesFileSeq;

    @Builder
    public FilePermission(
            String fileOwnerPermissionRead,
            String fileOwnerPermissionWrite,
            String fileGroupPermissionRead,
            String fileGroupPermissionWrite,
            String fileAlluserPermissionRead,
            String fileAlluserPermissionWrite) {
        this.fileOwnerPermissionRead = fileOwnerPermissionRead;
        this.fileOwnerPermissionWrite = fileOwnerPermissionWrite;
        this.fileGroupPermissionRead = fileGroupPermissionRead;
        this.fileGroupPermissionWrite = fileGroupPermissionWrite;
        this.fileAlluserPermissionRead = fileAlluserPermissionRead;
        this.fileAlluserPermissionWrite = fileAlluserPermissionWrite;
    }
}
