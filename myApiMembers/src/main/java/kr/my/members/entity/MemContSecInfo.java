package kr.my.members.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "MEM_CONT_SEC_INFO", schema = "", catalog = "MY_MEMBER")
public class MemContSecInfo {
    private String contCode;
    private String contType;
    private String contName;
    private String contCont;
    private String contContHash;
    private String password;
    private String contAuth;
    private String contStatus;
    private Timestamp contStatusDate;
    private String memCode;
    private MemComm memCommByMemCode;

    @Id
    @Column(name = "CONT_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }

    @Basic
    @Column(name = "CONT_TYPE", nullable = false, insertable = true, updatable = true, length = 3)
    public String getContType() {
        return contType;
    }

    public void setContType(String contType) {
        this.contType = contType;
    }

    @Basic
    @Column(name = "CONT_NAME", nullable = false, insertable = true, updatable = true, length = 50)
    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    @Basic
    @Column(name = "CONT_CONT", nullable = true, insertable = true, updatable = true, length = 100)
    public String getContCont() {
        return contCont;
    }

    public void setContCont(String contCont) {
        this.contCont = contCont;
    }

    @Basic
    @Column(name = "CONT_CONT_HASH", nullable = true, insertable = true, updatable = true, length = 255)
    public String getContContHash() {
        return contContHash;
    }

    public void setContContHash(String contContHash) {
        this.contContHash = contContHash;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "CONT_AUTH", nullable = true, insertable = true, updatable = true, length = 2)
    public String getContAuth() {
        return contAuth;
    }

    public void setContAuth(String contAuth) {
        this.contAuth = contAuth;
    }

    @Basic
    @Column(name = "CONT_STATUS", nullable = true, insertable = true, updatable = true, length = 2)
    public String getContStatus() {
        return contStatus;
    }

    public void setContStatus(String contStatus) {
        this.contStatus = contStatus;
    }

    @Basic
    @Column(name = "CONT_STATUS_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getContStatusDate() {
        return contStatusDate;
    }

    public void setContStatusDate(Timestamp contStatusDate) {
        this.contStatusDate = contStatusDate;
    }

    @Basic
    @Column(name = "MEM_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getMemCode() {
        return memCode;
    }

    public void setMemCode(String memCode) {
        this.memCode = memCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemContSecInfo that = (MemContSecInfo) o;

        if (contCode != null ? !contCode.equals(that.contCode) : that.contCode != null) return false;
        if (contType != null ? !contType.equals(that.contType) : that.contType != null) return false;
        if (contName != null ? !contName.equals(that.contName) : that.contName != null) return false;
        if (contCont != null ? !contCont.equals(that.contCont) : that.contCont != null) return false;
        if (contContHash != null ? !contContHash.equals(that.contContHash) : that.contContHash != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (contAuth != null ? !contAuth.equals(that.contAuth) : that.contAuth != null) return false;
        if (contStatus != null ? !contStatus.equals(that.contStatus) : that.contStatus != null) return false;
        if (contStatusDate != null ? !contStatusDate.equals(that.contStatusDate) : that.contStatusDate != null)
            return false;
        return memCode != null ? memCode.equals(that.memCode) : that.memCode == null;
    }

    @Override
    public int hashCode() {
        int result = contCode != null ? contCode.hashCode() : 0;
        result = 31 * result + (contType != null ? contType.hashCode() : 0);
        result = 31 * result + (contName != null ? contName.hashCode() : 0);
        result = 31 * result + (contCont != null ? contCont.hashCode() : 0);
        result = 31 * result + (contContHash != null ? contContHash.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (contAuth != null ? contAuth.hashCode() : 0);
        result = 31 * result + (contStatus != null ? contStatus.hashCode() : 0);
        result = 31 * result + (contStatusDate != null ? contStatusDate.hashCode() : 0);
        result = 31 * result + (memCode != null ? memCode.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MEM_CODE", referencedColumnName = "MEM_CODE", nullable = false)
    public MemComm getMemCommByMemCode() {
        return memCommByMemCode;
    }

    public void setMemCommByMemCode(MemComm memCommByMemCode) {
        this.memCommByMemCode = memCommByMemCode;
    }
}
