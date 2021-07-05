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
import java.util.List;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "shareSeq")
@Getter
@Entity
@Table(name = "MY_FILES")
public class MyFiles extends BaseTimeEntity {
    @Id
    @Column(name = "FILE_SEQ", nullable = false, insertable = true, updatable = true)
    private Long fileSeq;
    @Column(name = "FILE_ORG_NAME", nullable = false, insertable = true, updatable = true, length = 255)
    private String fileOrgName;
    @Column(name = "FILE_PHY_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    private String filePhyName;
    @Column(name = "FILE_HASH_CODE", nullable = false, insertable = true, updatable = true, length = 255)
    private String fileHashCode;
    @Column(name = "FILE_DOWNLOAD_PATH", nullable = false, insertable = true, updatable = true, length = 1000)
    private String fileDownloadPath;
    @Column(name = "FILE_OWNER_DISPLAY_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    private String fileOwnerDisplayName;
    @Column(name = "FILE_PATH", nullable = false, insertable = true, updatable = true, length = 1000)
    private String filePath;
    @Column(name = "FILE_STATUS", nullable = false, insertable = true, updatable = true, length = 3)
    private String fileStatus;
    @Column(name = "REG_DATE", nullable = false, insertable = true, updatable = true)
    private Timestamp regDate;
    @Column(name = "POST_LINKED", nullable = false, insertable = true, updatable = true)
    private Long postLinked;
    @Column(name = "POST_LINK_TYPE", nullable = false, insertable = true, updatable = true, length = 50)
    private String postLinkType;
    @Column(name = "FILE_CONTENT_TYPE", nullable = true, insertable = true, updatable = true, length = 200)
    private String fileContentType;

    @OneToOne
    @JoinColumn(name = "FILE_ROLE_SEQ")
    private FilePermission filePermissions;


    /**
     * 파일을 조회 하면 해당 사용자를 나오게 한다.
     */
    @ManyToOne
    @JoinColumn(name = "USER_CODE", referencedColumnName = "USER_CODE", nullable = false)
    private MyUsers myUsersByUserCode;

    @OneToMany(mappedBy = "myFileSeq")
    private List<FilePermissionGroup> filePermissionGroups;

    public MyFiles(String fileOrgName, String fileOwnerDisplayName,
                   String fileContentType, FilePermission filePermissions,
                   MyUsers myUsersByUserCode) {
        this.fileOrgName = fileOrgName;
        this.fileOwnerDisplayName = fileOwnerDisplayName;
        this.fileContentType = fileContentType;
        this.filePermissions = filePermissions;
        this.myUsersByUserCode = myUsersByUserCode;
    }
}
