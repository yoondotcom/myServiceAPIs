package kr.my.members.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "SIGN_UP_INFO", schema = "", catalog = "MY_MEMBER")
public class SignUpInfo {
    private Long singUpSeq;
    private String branchCode;
    private String memCode;
    private Timestamp memRegDate;
    private Collection<MemAgreeys> memAgreeysesBySingUpSeq;
    private Branch branchByBranchCode;
    private MemComm memCommByMemCode;

    @Id
    @Column(name = "SING_UP_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getSingUpSeq() {
        return singUpSeq;
    }

    public void setSingUpSeq(Long singUpSeq) {
        this.singUpSeq = singUpSeq;
    }

    @Basic
    @Column(name = "BRANCH_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    @Basic
    @Column(name = "MEM_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getMemCode() {
        return memCode;
    }

    public void setMemCode(String memCode) {
        this.memCode = memCode;
    }

    @Basic
    @Column(name = "MEM_REG_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getMemRegDate() {
        return memRegDate;
    }

    public void setMemRegDate(Timestamp memRegDate) {
        this.memRegDate = memRegDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SignUpInfo that = (SignUpInfo) o;

        if (singUpSeq != null ? !singUpSeq.equals(that.singUpSeq) : that.singUpSeq != null) return false;
        if (branchCode != null ? !branchCode.equals(that.branchCode) : that.branchCode != null) return false;
        if (memCode != null ? !memCode.equals(that.memCode) : that.memCode != null) return false;
        if (memRegDate != null ? !memRegDate.equals(that.memRegDate) : that.memRegDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = singUpSeq != null ? singUpSeq.hashCode() : 0;
        result = 31 * result + (branchCode != null ? branchCode.hashCode() : 0);
        result = 31 * result + (memCode != null ? memCode.hashCode() : 0);
        result = 31 * result + (memRegDate != null ? memRegDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "signUpInfoBySingUpSeq")
    public Collection<MemAgreeys> getMemAgreeysesBySingUpSeq() {
        return memAgreeysesBySingUpSeq;
    }

    public void setMemAgreeysesBySingUpSeq(Collection<MemAgreeys> memAgreeysesBySingUpSeq) {
        this.memAgreeysesBySingUpSeq = memAgreeysesBySingUpSeq;
    }

    @ManyToOne
    @JoinColumn(name = "BRANCH_CODE", referencedColumnName = "BRANCH_CODE", nullable = false)
    public Branch getBranchByBranchCode() {
        return branchByBranchCode;
    }

    public void setBranchByBranchCode(Branch branchByBranchCode) {
        this.branchByBranchCode = branchByBranchCode;
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
