package kr.my.members.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "EMP_AGREEYS", schema = "", catalog = "MY_MEMBER")
public class EmpAgreeys {
    private Long eaSeq;
    private Timestamp agreeRegDate;
    private Long empRolesErSeq;
    private String stipulationStipCode;
    private EmpRoles empRolesByEmpRolesErSeq;
    private Stipulation stipulationByStipulationStipCode;

    @Id
    @Column(name = "EA_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getEaSeq() {
        return eaSeq;
    }

    public void setEaSeq(Long eaSeq) {
        this.eaSeq = eaSeq;
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
    @Column(name = "EMP_ROLES_ER_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getEmpRolesErSeq() {
        return empRolesErSeq;
    }

    public void setEmpRolesErSeq(Long empRolesErSeq) {
        this.empRolesErSeq = empRolesErSeq;
    }

    @Basic
    @Column(name = "STIPULATION_STIP_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getStipulationStipCode() {
        return stipulationStipCode;
    }

    public void setStipulationStipCode(String stipulationStipCode) {
        this.stipulationStipCode = stipulationStipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpAgreeys that = (EmpAgreeys) o;

        if (eaSeq != null ? !eaSeq.equals(that.eaSeq) : that.eaSeq != null) return false;
        if (agreeRegDate != null ? !agreeRegDate.equals(that.agreeRegDate) : that.agreeRegDate != null) return false;
        if (empRolesErSeq != null ? !empRolesErSeq.equals(that.empRolesErSeq) : that.empRolesErSeq != null)
            return false;
        if (stipulationStipCode != null ? !stipulationStipCode.equals(that.stipulationStipCode) : that.stipulationStipCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eaSeq != null ? eaSeq.hashCode() : 0;
        result = 31 * result + (agreeRegDate != null ? agreeRegDate.hashCode() : 0);
        result = 31 * result + (empRolesErSeq != null ? empRolesErSeq.hashCode() : 0);
        result = 31 * result + (stipulationStipCode != null ? stipulationStipCode.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "EMP_ROLES_ER_SEQ", referencedColumnName = "ER_SEQ", nullable = false)
    public EmpRoles getEmpRolesByEmpRolesErSeq() {
        return empRolesByEmpRolesErSeq;
    }

    public void setEmpRolesByEmpRolesErSeq(EmpRoles empRolesByEmpRolesErSeq) {
        this.empRolesByEmpRolesErSeq = empRolesByEmpRolesErSeq;
    }

    @ManyToOne
    @JoinColumn(name = "STIPULATION_STIP_CODE", referencedColumnName = "STIP_CODE", nullable = false)
    public Stipulation getStipulationByStipulationStipCode() {
        return stipulationByStipulationStipCode;
    }

    public void setStipulationByStipulationStipCode(Stipulation stipulationByStipulationStipCode) {
        this.stipulationByStipulationStipCode = stipulationByStipulationStipCode;
    }
}
