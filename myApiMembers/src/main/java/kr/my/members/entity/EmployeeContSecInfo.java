package kr.my.members.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "EMPLOYEE_CONT_SEC_INFO", schema = "", catalog = "MY_MEMBER")
public class EmployeeContSecInfo {
    private String emplContCode;
    private String emplContType;
    private String emplContName;
    private String emplContA;
    private String emplContB;
    private String emplContC;
    private String emplAuth;
    private String emplContPassword;
    private String emplContStatus;
    private Timestamp emplContStatusDate;
    private String emplEmployeeCode;
    private Employee employeeByEmplEmployeeCode;

    @Id
    @Column(name = "EMPL_CONT_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getEmplContCode() {
        return emplContCode;
    }

    public void setEmplContCode(String emplContCode) {
        this.emplContCode = emplContCode;
    }

    @Basic
    @Column(name = "EMPL_CONT_TYPE", nullable = false, insertable = true, updatable = true, length = 3)
    public String getEmplContType() {
        return emplContType;
    }

    public void setEmplContType(String emplContType) {
        this.emplContType = emplContType;
    }

    @Basic
    @Column(name = "EMPL_CONT_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getEmplContName() {
        return emplContName;
    }

    public void setEmplContName(String emplContName) {
        this.emplContName = emplContName;
    }

    @Basic
    @Column(name = "EMPL_CONT_A", nullable = true, insertable = true, updatable = true, length = 100)
    public String getEmplContA() {
        return emplContA;
    }

    public void setEmplContA(String emplContA) {
        this.emplContA = emplContA;
    }

    @Basic
    @Column(name = "EMPL_CONT_B", nullable = true, insertable = true, updatable = true, length = 100)
    public String getEmplContB() {
        return emplContB;
    }

    public void setEmplContB(String emplContB) {
        this.emplContB = emplContB;
    }

    @Basic
    @Column(name = "EMPL_CONT_C", nullable = true, insertable = true, updatable = true, length = 100)
    public String getEmplContC() {
        return emplContC;
    }

    public void setEmplContC(String emplContC) {
        this.emplContC = emplContC;
    }

    @Basic
    @Column(name = "EMPL_AUTH", nullable = false, insertable = true, updatable = true, length = 2)
    public String getEmplAuth() {
        return emplAuth;
    }

    public void setEmplAuth(String emplAuth) {
        this.emplAuth = emplAuth;
    }

    @Basic
    @Column(name = "EMPL_CONT_PASSWORD", nullable = true, insertable = true, updatable = true, length = 40)
    public String getEmplContPassword() {
        return emplContPassword;
    }

    public void setEmplContPassword(String emplContPassword) {
        this.emplContPassword = emplContPassword;
    }

    @Basic
    @Column(name = "EMPL_CONT_STATUS", nullable = false, insertable = true, updatable = true, length = 2)
    public String getEmplContStatus() {
        return emplContStatus;
    }

    public void setEmplContStatus(String emplContStatus) {
        this.emplContStatus = emplContStatus;
    }

    @Basic
    @Column(name = "EMPL_CONT_STATUS_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getEmplContStatusDate() {
        return emplContStatusDate;
    }

    public void setEmplContStatusDate(Timestamp emplContStatusDate) {
        this.emplContStatusDate = emplContStatusDate;
    }

    @Basic
    @Column(name = "EMPL_EMPLOYEE_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getEmplEmployeeCode() {
        return emplEmployeeCode;
    }

    public void setEmplEmployeeCode(String emplEmployeeCode) {
        this.emplEmployeeCode = emplEmployeeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeContSecInfo that = (EmployeeContSecInfo) o;

        if (emplContCode != null ? !emplContCode.equals(that.emplContCode) : that.emplContCode != null) return false;
        if (emplContType != null ? !emplContType.equals(that.emplContType) : that.emplContType != null) return false;
        if (emplContName != null ? !emplContName.equals(that.emplContName) : that.emplContName != null) return false;
        if (emplContA != null ? !emplContA.equals(that.emplContA) : that.emplContA != null) return false;
        if (emplContB != null ? !emplContB.equals(that.emplContB) : that.emplContB != null) return false;
        if (emplContC != null ? !emplContC.equals(that.emplContC) : that.emplContC != null) return false;
        if (emplAuth != null ? !emplAuth.equals(that.emplAuth) : that.emplAuth != null) return false;
        if (emplContPassword != null ? !emplContPassword.equals(that.emplContPassword) : that.emplContPassword != null)
            return false;
        if (emplContStatus != null ? !emplContStatus.equals(that.emplContStatus) : that.emplContStatus != null)
            return false;
        if (emplContStatusDate != null ? !emplContStatusDate.equals(that.emplContStatusDate) : that.emplContStatusDate != null)
            return false;
        return emplEmployeeCode != null ? emplEmployeeCode.equals(that.emplEmployeeCode) : that.emplEmployeeCode == null;
    }

    @Override
    public int hashCode() {
        int result = emplContCode != null ? emplContCode.hashCode() : 0;
        result = 31 * result + (emplContType != null ? emplContType.hashCode() : 0);
        result = 31 * result + (emplContName != null ? emplContName.hashCode() : 0);
        result = 31 * result + (emplContA != null ? emplContA.hashCode() : 0);
        result = 31 * result + (emplContB != null ? emplContB.hashCode() : 0);
        result = 31 * result + (emplContC != null ? emplContC.hashCode() : 0);
        result = 31 * result + (emplAuth != null ? emplAuth.hashCode() : 0);
        result = 31 * result + (emplContPassword != null ? emplContPassword.hashCode() : 0);
        result = 31 * result + (emplContStatus != null ? emplContStatus.hashCode() : 0);
        result = 31 * result + (emplContStatusDate != null ? emplContStatusDate.hashCode() : 0);
        result = 31 * result + (emplEmployeeCode != null ? emplEmployeeCode.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "EMPL_EMPLOYEE_CODE", referencedColumnName = "EMPL_CODE", nullable = false)
    public Employee getEmployeeByEmplEmployeeCode() {
        return employeeByEmplEmployeeCode;
    }

    public void setEmployeeByEmplEmployeeCode(Employee employeeByEmplEmployeeCode) {
        this.employeeByEmplEmployeeCode = employeeByEmplEmployeeCode;
    }
}
