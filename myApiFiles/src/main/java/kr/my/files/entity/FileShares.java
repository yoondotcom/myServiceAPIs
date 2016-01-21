package kr.my.files.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "FILE_SHARES", schema = "", catalog = "MY_MEMBER")
public class FileShares {
    private Long shareSeq;
    private String fileLinked;
    private String fileLinkType;
    private Timestamp regDate;
    private Long myFilesFileSeq;
    private MyFiles myFilesByMyFilesFileSeq;

    @Id
    @Column(name = "SHARE_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getShareSeq() {
        return shareSeq;
    }

    public void setShareSeq(Long shareSeq) {
        this.shareSeq = shareSeq;
    }

    @Basic
    @Column(name = "FILE_LINKED", nullable = true, insertable = true, updatable = true, length = 255)
    public String getFileLinked() {
        return fileLinked;
    }

    public void setFileLinked(String fileLinked) {
        this.fileLinked = fileLinked;
    }

    @Basic
    @Column(name = "FILE_LINK_TYPE", nullable = true, insertable = true, updatable = true, length = 50)
    public String getFileLinkType() {
        return fileLinkType;
    }

    public void setFileLinkType(String fileLinkType) {
        this.fileLinkType = fileLinkType;
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
    @Column(name = "MY_FILES_FILE_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getMyFilesFileSeq() {
        return myFilesFileSeq;
    }

    public void setMyFilesFileSeq(Long myFilesFileSeq) {
        this.myFilesFileSeq = myFilesFileSeq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileShares that = (FileShares) o;

        if (shareSeq != null ? !shareSeq.equals(that.shareSeq) : that.shareSeq != null) return false;
        if (fileLinked != null ? !fileLinked.equals(that.fileLinked) : that.fileLinked != null) return false;
        if (fileLinkType != null ? !fileLinkType.equals(that.fileLinkType) : that.fileLinkType != null) return false;
        if (regDate != null ? !regDate.equals(that.regDate) : that.regDate != null) return false;
        if (myFilesFileSeq != null ? !myFilesFileSeq.equals(that.myFilesFileSeq) : that.myFilesFileSeq != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shareSeq != null ? shareSeq.hashCode() : 0;
        result = 31 * result + (fileLinked != null ? fileLinked.hashCode() : 0);
        result = 31 * result + (fileLinkType != null ? fileLinkType.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        result = 31 * result + (myFilesFileSeq != null ? myFilesFileSeq.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MY_FILES_FILE_SEQ", referencedColumnName = "FILE_SEQ", nullable = false)
    public MyFiles getMyFilesByMyFilesFileSeq() {
        return myFilesByMyFilesFileSeq;
    }

    public void setMyFilesByMyFilesFileSeq(MyFiles myFilesByMyFilesFileSeq) {
        this.myFilesByMyFilesFileSeq = myFilesByMyFilesFileSeq;
    }
}
