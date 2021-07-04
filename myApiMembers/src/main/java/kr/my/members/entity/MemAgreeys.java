package kr.my.members.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "MEM_AGREEYS", schema = "", catalog = "MY_MEMBER")
public class MemAgreeys {
    private Long maSeq;
    private String stipCode;
    private Timestamp agreeRegDate;
    private Long singUpSeq;
    private Stipulation stipulationByStipCode;
    private SignUpInfo signUpInfoBySingUpSeq;

    @Id
    @Column(name = "MA_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getMaSeq() {
        return maSeq;
    }

    public void setMaSeq(Long maSeq) {
        this.maSeq = maSeq;
    }

    @Basic
    @Column(name = "STIP_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getStipCode() {
        return stipCode;
    }

    public void setStipCode(String stipCode) {
        this.stipCode = stipCode;
    }

    @Basic
    @Column(name = "AGREE_REG_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getAgreeRegDate() {
        return agreeRegDate;
    }

    public void setAgreeRegDate(Timestamp agreeRegDate) {
        this.agreeRegDate = agreeRegDate;
    }

    @Basic
    @Column(name = "SING_UP_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getSingUpSeq() {
        return singUpSeq;
    }

    public void setSingUpSeq(Long singUpSeq) {
        this.singUpSeq = singUpSeq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemAgreeys that = (MemAgreeys) o;

        if (maSeq != null ? !maSeq.equals(that.maSeq) : that.maSeq != null) return false;
        if (stipCode != null ? !stipCode.equals(that.stipCode) : that.stipCode != null) return false;
        if (agreeRegDate != null ? !agreeRegDate.equals(that.agreeRegDate) : that.agreeRegDate != null) return false;
        return singUpSeq != null ? singUpSeq.equals(that.singUpSeq) : that.singUpSeq == null;
    }

    @Override
    public int hashCode() {
        int result = maSeq != null ? maSeq.hashCode() : 0;
        result = 31 * result + (stipCode != null ? stipCode.hashCode() : 0);
        result = 31 * result + (agreeRegDate != null ? agreeRegDate.hashCode() : 0);
        result = 31 * result + (singUpSeq != null ? singUpSeq.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "STIP_CODE", referencedColumnName = "STIP_CODE", nullable = false)
    public Stipulation getStipulationByStipCode() {
        return stipulationByStipCode;
    }

    public void setStipulationByStipCode(Stipulation stipulationByStipCode) {
        this.stipulationByStipCode = stipulationByStipCode;
    }

    @ManyToOne
    @JoinColumn(name = "SING_UP_SEQ", referencedColumnName = "SING_UP_SEQ", nullable = false)
    public SignUpInfo getSignUpInfoBySingUpSeq() {
        return signUpInfoBySingUpSeq;
    }

    public void setSignUpInfoBySingUpSeq(SignUpInfo signUpInfoBySingUpSeq) {
        this.signUpInfoBySingUpSeq = signUpInfoBySingUpSeq;
    }
}
