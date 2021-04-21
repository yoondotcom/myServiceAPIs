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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "shareSeq")
@Getter
@Entity
@Table(name = "MY_FILES", schema = "", catalog = "MY_MEMBER")
public class MyFiles {
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
    private String myUsersUserCode;
    private Collection<FilePermission> filePermissionsByFileSeq;
    private Collection<FileShares> fileSharesByFileSeq;
    private MyUsers myUsersByMyUsersUserCode;


    public Long getFileSeq() {
        return fileSeq;
    }

    public void setFileSeq(Long fileSeq) {
        this.fileSeq = fileSeq;
    }

    @Basic

    public String getFileOrgName() {
        return fileOrgName;
    }

    public void setFileOrgName(String fileOrgName) {
        this.fileOrgName = fileOrgName;
    }

    @Basic

    public String getFilePhyName() {
        return filePhyName;
    }

    public void setFilePhyName(String filePhyName) {
        this.filePhyName = filePhyName;
    }

    @Basic

    public String getFileHashCode() {
        return fileHashCode;
    }

    public void setFileHashCode(String fileHashCode) {
        this.fileHashCode = fileHashCode;
    }

    @Basic

    public String getFileDownloadPath() {
        return fileDownloadPath;
    }

    public void setFileDownloadPath(String fileDownloadPath) {
        this.fileDownloadPath = fileDownloadPath;
    }

    @Basic

    public String getFileOwnerDisplayName() {
        return fileOwnerDisplayName;
    }

    public void setFileOwnerDisplayName(String fileOwnerDisplayName) {
        this.fileOwnerDisplayName = fileOwnerDisplayName;
    }

    @Basic

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }

    @Basic

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    @Basic

    public Long getPostLinked() {
        return postLinked;
    }

    public void setPostLinked(Long postLinked) {
        this.postLinked = postLinked;
    }

    @Basic

    public String getPostLinkType() {
        return postLinkType;
    }

    public void setPostLinkType(String postLinkType) {
        this.postLinkType = postLinkType;
    }

    @Basic

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    @Basic
    @Column(name = "MY_USERS_USER_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getMyUsersUserCode() {
        return myUsersUserCode;
    }

    public void setMyUsersUserCode(String myUsersUserCode) {
        this.myUsersUserCode = myUsersUserCode;
    }

    @OneToMany(mappedBy = "myFilesByMyFilesFileSeq")
    public Collection<FilePermission> getFilePermissionsByFileSeq() {
        return filePermissionsByFileSeq;
    }

    public void setFilePermissionsByFileSeq(Collection<FilePermission> filePermissionsByFileSeq) {
        this.filePermissionsByFileSeq = filePermissionsByFileSeq;
    }

    @OneToMany(mappedBy = "myFilesByMyFilesFileSeq")
    public Collection<FileShares> getFileSharesByFileSeq() {
        return fileSharesByFileSeq;
    }

    public void setFileSharesByFileSeq(Collection<FileShares> fileSharesByFileSeq) {
        this.fileSharesByFileSeq = fileSharesByFileSeq;
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
