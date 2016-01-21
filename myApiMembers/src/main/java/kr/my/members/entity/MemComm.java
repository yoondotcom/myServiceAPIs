package kr.my.members.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "MEM_COMM", schema = "", catalog = "MY_MEMBER")
public class MemComm {
    private String memCode;
    private String memName;
    private String memSubName;
    private String memSex;
    private String memRowBirthDay;
    private String memZip;
    private String memRoadCode;
    private String memAddr;
    private String memAddrDtail;
    private String memStatus;
    private Timestamp memStatusDate;
    private Collection<MemContSecInfo> memContSecInfosByMemCode;
    private Collection<SignUpInfo> signUpInfosByMemCode;

    @Id
    @Column(name = "MEM_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getMemCode() {
        return memCode;
    }

    public void setMemCode(String memCode) {
        this.memCode = memCode;
    }

    @Basic
    @Column(name = "MEM_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    @Basic
    @Column(name = "MEM_SUB_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getMemSubName() {
        return memSubName;
    }

    public void setMemSubName(String memSubName) {
        this.memSubName = memSubName;
    }

    @Basic
    @Column(name = "MEM_SEX", nullable = true, insertable = true, updatable = true, length = 2)
    public String getMemSex() {
        return memSex;
    }

    public void setMemSex(String memSex) {
        this.memSex = memSex;
    }

    @Basic
    @Column(name = "MEM_ROW_BIRTH_DAY", nullable = true, insertable = true, updatable = true, length = 8)
    public String getMemRowBirthDay() {
        return memRowBirthDay;
    }

    public void setMemRowBirthDay(String memRowBirthDay) {
        this.memRowBirthDay = memRowBirthDay;
    }

    @Basic
    @Column(name = "MEM_ZIP", nullable = true, insertable = true, updatable = true, length = 10)
    public String getMemZip() {
        return memZip;
    }

    public void setMemZip(String memZip) {
        this.memZip = memZip;
    }

    @Basic
    @Column(name = "MEM_ROAD_CODE", nullable = true, insertable = true, updatable = true, length = 20)
    public String getMemRoadCode() {
        return memRoadCode;
    }

    public void setMemRoadCode(String memRoadCode) {
        this.memRoadCode = memRoadCode;
    }

    @Basic
    @Column(name = "MEM_ADDR", nullable = true, insertable = true, updatable = true, length = 100)
    public String getMemAddr() {
        return memAddr;
    }

    public void setMemAddr(String memAddr) {
        this.memAddr = memAddr;
    }

    @Basic
    @Column(name = "MEM_ADDR_DTAIL", nullable = true, insertable = true, updatable = true, length = 100)
    public String getMemAddrDtail() {
        return memAddrDtail;
    }

    public void setMemAddrDtail(String memAddrDtail) {
        this.memAddrDtail = memAddrDtail;
    }

    @Basic
    @Column(name = "MEM_STATUS", nullable = true, insertable = true, updatable = true, length = 2)
    public String getMemStatus() {
        return memStatus;
    }

    public void setMemStatus(String memStatus) {
        this.memStatus = memStatus;
    }

    @Basic
    @Column(name = "MEM_STATUS_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getMemStatusDate() {
        return memStatusDate;
    }

    public void setMemStatusDate(Timestamp memStatusDate) {
        this.memStatusDate = memStatusDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemComm memComm = (MemComm) o;

        if (memCode != null ? !memCode.equals(memComm.memCode) : memComm.memCode != null) return false;
        if (memName != null ? !memName.equals(memComm.memName) : memComm.memName != null) return false;
        if (memSubName != null ? !memSubName.equals(memComm.memSubName) : memComm.memSubName != null) return false;
        if (memSex != null ? !memSex.equals(memComm.memSex) : memComm.memSex != null) return false;
        if (memRowBirthDay != null ? !memRowBirthDay.equals(memComm.memRowBirthDay) : memComm.memRowBirthDay != null)
            return false;
        if (memZip != null ? !memZip.equals(memComm.memZip) : memComm.memZip != null) return false;
        if (memRoadCode != null ? !memRoadCode.equals(memComm.memRoadCode) : memComm.memRoadCode != null) return false;
        if (memAddr != null ? !memAddr.equals(memComm.memAddr) : memComm.memAddr != null) return false;
        if (memAddrDtail != null ? !memAddrDtail.equals(memComm.memAddrDtail) : memComm.memAddrDtail != null)
            return false;
        if (memStatus != null ? !memStatus.equals(memComm.memStatus) : memComm.memStatus != null) return false;
        if (memStatusDate != null ? !memStatusDate.equals(memComm.memStatusDate) : memComm.memStatusDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = memCode != null ? memCode.hashCode() : 0;
        result = 31 * result + (memName != null ? memName.hashCode() : 0);
        result = 31 * result + (memSubName != null ? memSubName.hashCode() : 0);
        result = 31 * result + (memSex != null ? memSex.hashCode() : 0);
        result = 31 * result + (memRowBirthDay != null ? memRowBirthDay.hashCode() : 0);
        result = 31 * result + (memZip != null ? memZip.hashCode() : 0);
        result = 31 * result + (memRoadCode != null ? memRoadCode.hashCode() : 0);
        result = 31 * result + (memAddr != null ? memAddr.hashCode() : 0);
        result = 31 * result + (memAddrDtail != null ? memAddrDtail.hashCode() : 0);
        result = 31 * result + (memStatus != null ? memStatus.hashCode() : 0);
        result = 31 * result + (memStatusDate != null ? memStatusDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "memCommByMemCode")
    public Collection<MemContSecInfo> getMemContSecInfosByMemCode() {
        return memContSecInfosByMemCode;
    }

    public void setMemContSecInfosByMemCode(Collection<MemContSecInfo> memContSecInfosByMemCode) {
        this.memContSecInfosByMemCode = memContSecInfosByMemCode;
    }

    @OneToMany(mappedBy = "memCommByMemCode")
    public Collection<SignUpInfo> getSignUpInfosByMemCode() {
        return signUpInfosByMemCode;
    }

    public void setSignUpInfosByMemCode(Collection<SignUpInfo> signUpInfosByMemCode) {
        this.signUpInfosByMemCode = signUpInfosByMemCode;
    }
}
