package kr.my.members.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "EMP_ROLES", schema = "", catalog = "MY_MEMBER")
public class EmpRoles {
    private Long erSeq;
    private String roleCode;
    private String emplCode;
    private String deptCode;
    private Timestamp erRegDate;
    private Collection<EmpAgreeys> empAgreeysesByErSeq;
    private Employee employeeByEmplCode;

    @Id
    @Column(name = "ER_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getErSeq() {
        return erSeq;
    }

    public void setErSeq(Long erSeq) {
        this.erSeq = erSeq;
    }

    @Basic
    @Column(name = "ROLE_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Basic
    @Column(name = "EMPL_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getEmplCode() {
        return emplCode;
    }

    public void setEmplCode(String emplCode) {
        this.emplCode = emplCode;
    }

    @Basic
    @Column(name = "DEPT_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    @Basic
    @Column(name = "ER_REG_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getErRegDate() {
        return erRegDate;
    }

    public void setErRegDate(Timestamp erRegDate) {
        this.erRegDate = erRegDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpRoles empRoles = (EmpRoles) o;

        if (erSeq != null ? !erSeq.equals(empRoles.erSeq) : empRoles.erSeq != null) return false;
        if (roleCode != null ? !roleCode.equals(empRoles.roleCode) : empRoles.roleCode != null) return false;
        if (emplCode != null ? !emplCode.equals(empRoles.emplCode) : empRoles.emplCode != null) return false;
        if (deptCode != null ? !deptCode.equals(empRoles.deptCode) : empRoles.deptCode != null) return false;
        if (erRegDate != null ? !erRegDate.equals(empRoles.erRegDate) : empRoles.erRegDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = erSeq != null ? erSeq.hashCode() : 0;
        result = 31 * result + (roleCode != null ? roleCode.hashCode() : 0);
        result = 31 * result + (emplCode != null ? emplCode.hashCode() : 0);
        result = 31 * result + (deptCode != null ? deptCode.hashCode() : 0);
        result = 31 * result + (erRegDate != null ? erRegDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "empRolesByEmpRolesErSeq")
    public Collection<EmpAgreeys> getEmpAgreeysesByErSeq() {
        return empAgreeysesByErSeq;
    }

    public void setEmpAgreeysesByErSeq(Collection<EmpAgreeys> empAgreeysesByErSeq) {
        this.empAgreeysesByErSeq = empAgreeysesByErSeq;
    }

    @ManyToOne
    @JoinColumn(name = "EMPL_CODE", referencedColumnName = "EMPL_CODE", nullable = false)
    public Employee getEmployeeByEmplCode() {
        return employeeByEmplCode;
    }

    public void setEmployeeByEmplCode(Employee employeeByEmplCode) {
        this.employeeByEmplCode = employeeByEmplCode;
    }
}
