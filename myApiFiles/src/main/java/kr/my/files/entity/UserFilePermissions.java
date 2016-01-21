package kr.my.files.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "USER_FILE_PERMISSIONS", schema = "", catalog = "MY_MEMBER")
public class UserFilePermissions {
    private Integer filesRoleFileRoleSeq;
    private String fileOwnerPermissionRead;
    private String fileOwnerPermissionWrite;
    private String fileGroupPermissionRead;
    private String fileGroupPermissionWrite;
    private String fileAlluserPermissionRead;
    private String fileAlluserPermissionWrite;
    private Timestamp regDate;
    private Timestamp uptDate;
    private String myUsersUserCode;
    private MyUsers myUsersByMyUsersUserCode;

    @Id
    @Column(name = "FILES_ROLE_FILE_ROLE_SEQ", nullable = false, insertable = true, updatable = true)
    public Integer getFilesRoleFileRoleSeq() {
        return filesRoleFileRoleSeq;
    }

    public void setFilesRoleFileRoleSeq(Integer filesRoleFileRoleSeq) {
        this.filesRoleFileRoleSeq = filesRoleFileRoleSeq;
    }

    @Basic
    @Column(name = "FILE_OWNER_PERMISSION_READ", nullable = false, insertable = true, updatable = true, length = 1)
    public String getFileOwnerPermissionRead() {
        return fileOwnerPermissionRead;
    }

    public void setFileOwnerPermissionRead(String fileOwnerPermissionRead) {
        this.fileOwnerPermissionRead = fileOwnerPermissionRead;
    }

    @Basic
    @Column(name = "FILE_OWNER_PERMISSION_WRITE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getFileOwnerPermissionWrite() {
        return fileOwnerPermissionWrite;
    }

    public void setFileOwnerPermissionWrite(String fileOwnerPermissionWrite) {
        this.fileOwnerPermissionWrite = fileOwnerPermissionWrite;
    }

    @Basic
    @Column(name = "FILE_GROUP_PERMISSION_READ", nullable = false, insertable = true, updatable = true, length = 1)
    public String getFileGroupPermissionRead() {
        return fileGroupPermissionRead;
    }

    public void setFileGroupPermissionRead(String fileGroupPermissionRead) {
        this.fileGroupPermissionRead = fileGroupPermissionRead;
    }

    @Basic
    @Column(name = "FILE_GROUP_PERMISSION_WRITE", nullable = false, insertable = true, updatable = true, length = 1)
    public String getFileGroupPermissionWrite() {
        return fileGroupPermissionWrite;
    }

    public void setFileGroupPermissionWrite(String fileGroupPermissionWrite) {
        this.fileGroupPermissionWrite = fileGroupPermissionWrite;
    }

    @Basic
    @Column(name = "FILE_ALLUSER_PERMISSION_READ", nullable = false, insertable = true, updatable = true, length = 1)
    public String getFileAlluserPermissionRead() {
        return fileAlluserPermissionRead;
    }

    public void setFileAlluserPermissionRead(String fileAlluserPermissionRead) {
        this.fileAlluserPermissionRead = fileAlluserPermissionRead;
    }

    @Basic
    @Column(name = "FILE_ALLUSER_PERMISSION_WRITE", nullable = false, insertable = true, updatable = true, length = 1)
    public String getFileAlluserPermissionWrite() {
        return fileAlluserPermissionWrite;
    }

    public void setFileAlluserPermissionWrite(String fileAlluserPermissionWrite) {
        this.fileAlluserPermissionWrite = fileAlluserPermissionWrite;
    }

    @Basic
    @Column(name = "REG_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    @Basic
    @Column(name = "UPT_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getUptDate() {
        return uptDate;
    }

    public void setUptDate(Timestamp uptDate) {
        this.uptDate = uptDate;
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

        UserFilePermissions that = (UserFilePermissions) o;

        if (filesRoleFileRoleSeq != null ? !filesRoleFileRoleSeq.equals(that.filesRoleFileRoleSeq) : that.filesRoleFileRoleSeq != null)
            return false;
        if (fileOwnerPermissionRead != null ? !fileOwnerPermissionRead.equals(that.fileOwnerPermissionRead) : that.fileOwnerPermissionRead != null)
            return false;
        if (fileOwnerPermissionWrite != null ? !fileOwnerPermissionWrite.equals(that.fileOwnerPermissionWrite) : that.fileOwnerPermissionWrite != null)
            return false;
        if (fileGroupPermissionRead != null ? !fileGroupPermissionRead.equals(that.fileGroupPermissionRead) : that.fileGroupPermissionRead != null)
            return false;
        if (fileGroupPermissionWrite != null ? !fileGroupPermissionWrite.equals(that.fileGroupPermissionWrite) : that.fileGroupPermissionWrite != null)
            return false;
        if (fileAlluserPermissionRead != null ? !fileAlluserPermissionRead.equals(that.fileAlluserPermissionRead) : that.fileAlluserPermissionRead != null)
            return false;
        if (fileAlluserPermissionWrite != null ? !fileAlluserPermissionWrite.equals(that.fileAlluserPermissionWrite) : that.fileAlluserPermissionWrite != null)
            return false;
        if (regDate != null ? !regDate.equals(that.regDate) : that.regDate != null) return false;
        if (uptDate != null ? !uptDate.equals(that.uptDate) : that.uptDate != null) return false;
        if (myUsersUserCode != null ? !myUsersUserCode.equals(that.myUsersUserCode) : that.myUsersUserCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filesRoleFileRoleSeq != null ? filesRoleFileRoleSeq.hashCode() : 0;
        result = 31 * result + (fileOwnerPermissionRead != null ? fileOwnerPermissionRead.hashCode() : 0);
        result = 31 * result + (fileOwnerPermissionWrite != null ? fileOwnerPermissionWrite.hashCode() : 0);
        result = 31 * result + (fileGroupPermissionRead != null ? fileGroupPermissionRead.hashCode() : 0);
        result = 31 * result + (fileGroupPermissionWrite != null ? fileGroupPermissionWrite.hashCode() : 0);
        result = 31 * result + (fileAlluserPermissionRead != null ? fileAlluserPermissionRead.hashCode() : 0);
        result = 31 * result + (fileAlluserPermissionWrite != null ? fileAlluserPermissionWrite.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        result = 31 * result + (uptDate != null ? uptDate.hashCode() : 0);
        result = 31 * result + (myUsersUserCode != null ? myUsersUserCode.hashCode() : 0);
        return result;
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
