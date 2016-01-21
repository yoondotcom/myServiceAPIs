package kr.my.files.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "MY_FILES", schema = "", catalog = "MY_MEMBER")
public class MyFiles {
    private Long fileSeq;
    private String fileOrgName;
    private String filePhyName;
    private String fileHashCode;
    private String fileDownloadPath;
    private String fileOwnerDisplayName;
    private String filePath;
    private String fileStatus;
    private Timestamp regDate;
    private Long postLinked;
    private String postLinkType;
    private String fileContentType;
    private String myUsersUserCode;
    private Collection<FilePermission> filePermissionsByFileSeq;
    private Collection<FileShares> fileSharesByFileSeq;
    private MyUsers myUsersByMyUsersUserCode;

    @Id
    @Column(name = "FILE_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getFileSeq() {
        return fileSeq;
    }

    public void setFileSeq(Long fileSeq) {
        this.fileSeq = fileSeq;
    }

    @Basic
    @Column(name = "FILE_ORG_NAME", nullable = false, insertable = true, updatable = true, length = 255)
    public String getFileOrgName() {
        return fileOrgName;
    }

    public void setFileOrgName(String fileOrgName) {
        this.fileOrgName = fileOrgName;
    }

    @Basic
    @Column(name = "FILE_PHY_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getFilePhyName() {
        return filePhyName;
    }

    public void setFilePhyName(String filePhyName) {
        this.filePhyName = filePhyName;
    }

    @Basic
    @Column(name = "FILE_HASH_CODE", nullable = false, insertable = true, updatable = true, length = 255)
    public String getFileHashCode() {
        return fileHashCode;
    }

    public void setFileHashCode(String fileHashCode) {
        this.fileHashCode = fileHashCode;
    }

    @Basic
    @Column(name = "FILE_DOWNLOAD_PATH", nullable = false, insertable = true, updatable = true, length = 1000)
    public String getFileDownloadPath() {
        return fileDownloadPath;
    }

    public void setFileDownloadPath(String fileDownloadPath) {
        this.fileDownloadPath = fileDownloadPath;
    }

    @Basic
    @Column(name = "FILE_OWNER_DISPLAY_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getFileOwnerDisplayName() {
        return fileOwnerDisplayName;
    }

    public void setFileOwnerDisplayName(String fileOwnerDisplayName) {
        this.fileOwnerDisplayName = fileOwnerDisplayName;
    }

    @Basic
    @Column(name = "FILE_PATH", nullable = false, insertable = true, updatable = true, length = 1000)
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "FILE_STATUS", nullable = false, insertable = true, updatable = true, length = 3)
    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }

    @Basic
    @Column(name = "REG_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    @Basic
    @Column(name = "POST_LINKED", nullable = false, insertable = true, updatable = true)
    public Long getPostLinked() {
        return postLinked;
    }

    public void setPostLinked(Long postLinked) {
        this.postLinked = postLinked;
    }

    @Basic
    @Column(name = "POST_LINK_TYPE", nullable = false, insertable = true, updatable = true, length = 50)
    public String getPostLinkType() {
        return postLinkType;
    }

    public void setPostLinkType(String postLinkType) {
        this.postLinkType = postLinkType;
    }

    @Basic
    @Column(name = "FILE_CONTENT_TYPE", nullable = true, insertable = true, updatable = true, length = 200)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyFiles myFiles = (MyFiles) o;

        if (fileSeq != null ? !fileSeq.equals(myFiles.fileSeq) : myFiles.fileSeq != null) return false;
        if (fileOrgName != null ? !fileOrgName.equals(myFiles.fileOrgName) : myFiles.fileOrgName != null) return false;
        if (filePhyName != null ? !filePhyName.equals(myFiles.filePhyName) : myFiles.filePhyName != null) return false;
        if (fileHashCode != null ? !fileHashCode.equals(myFiles.fileHashCode) : myFiles.fileHashCode != null)
            return false;
        if (fileDownloadPath != null ? !fileDownloadPath.equals(myFiles.fileDownloadPath) : myFiles.fileDownloadPath != null)
            return false;
        if (fileOwnerDisplayName != null ? !fileOwnerDisplayName.equals(myFiles.fileOwnerDisplayName) : myFiles.fileOwnerDisplayName != null)
            return false;
        if (filePath != null ? !filePath.equals(myFiles.filePath) : myFiles.filePath != null) return false;
        if (fileStatus != null ? !fileStatus.equals(myFiles.fileStatus) : myFiles.fileStatus != null) return false;
        if (regDate != null ? !regDate.equals(myFiles.regDate) : myFiles.regDate != null) return false;
        if (postLinked != null ? !postLinked.equals(myFiles.postLinked) : myFiles.postLinked != null) return false;
        if (postLinkType != null ? !postLinkType.equals(myFiles.postLinkType) : myFiles.postLinkType != null)
            return false;
        if (fileContentType != null ? !fileContentType.equals(myFiles.fileContentType) : myFiles.fileContentType != null)
            return false;
        if (myUsersUserCode != null ? !myUsersUserCode.equals(myFiles.myUsersUserCode) : myFiles.myUsersUserCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fileSeq != null ? fileSeq.hashCode() : 0;
        result = 31 * result + (fileOrgName != null ? fileOrgName.hashCode() : 0);
        result = 31 * result + (filePhyName != null ? filePhyName.hashCode() : 0);
        result = 31 * result + (fileHashCode != null ? fileHashCode.hashCode() : 0);
        result = 31 * result + (fileDownloadPath != null ? fileDownloadPath.hashCode() : 0);
        result = 31 * result + (fileOwnerDisplayName != null ? fileOwnerDisplayName.hashCode() : 0);
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (fileStatus != null ? fileStatus.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        result = 31 * result + (postLinked != null ? postLinked.hashCode() : 0);
        result = 31 * result + (postLinkType != null ? postLinkType.hashCode() : 0);
        result = 31 * result + (fileContentType != null ? fileContentType.hashCode() : 0);
        result = 31 * result + (myUsersUserCode != null ? myUsersUserCode.hashCode() : 0);
        return result;
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
