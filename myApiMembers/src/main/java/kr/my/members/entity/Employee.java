package kr.my.members.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
public class Employee {
    private String emplCode;
    private String emplNumber;
    private String emplName;
    private String emplSex;
    private String emplBirthDay;
    private String emplZip;
    private String emplRoadCode;
    private String emplAddr;
    private String emplAddrDetl;
    private String emplPositionCode;
    private String emplStatus;
    private Timestamp emplStatusDate;
    private String branchCode;
    private String deptCode;
    private Department departmentByDeptCode;
    private Collection<EmployeeContSecInfo> employeeContSecInfosByEmplCode;
    private Collection<EmpRoles> empRolesByEmplCode;

    @Id
    @Column(name = "EMPL_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getEmplCode() {
        return emplCode;
    }

    public void setEmplCode(String emplCode) {
        this.emplCode = emplCode;
    }

    @Basic
    @Column(name = "EMPL_NUMBER", nullable = true, insertable = true, updatable = true, length = 20)
    public String getEmplNumber() {
        return emplNumber;
    }

    public void setEmplNumber(String emplNumber) {
        this.emplNumber = emplNumber;
    }

    @Basic
    @Column(name = "EMPL_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getEmplName() {
        return emplName;
    }

    public void setEmplName(String emplName) {
        this.emplName = emplName;
    }

    @Basic
    @Column(name = "EMPL_SEX", nullable = false, insertable = true, updatable = true, length = 2)
    public String getEmplSex() {
        return emplSex;
    }

    public void setEmplSex(String emplSex) {
        this.emplSex = emplSex;
    }

    @Basic
    @Column(name = "EMPL_BIRTH_DAY", nullable = false, insertable = true, updatable = true, length = 9)
    public String getEmplBirthDay() {
        return emplBirthDay;
    }

    public void setEmplBirthDay(String emplBirthDay) {
        this.emplBirthDay = emplBirthDay;
    }

    @Basic
    @Column(name = "EMPL_ZIP", nullable = true, insertable = true, updatable = true, length = 10)
    public String getEmplZip() {
        return emplZip;
    }

    public void setEmplZip(String emplZip) {
        this.emplZip = emplZip;
    }

    @Basic
    @Column(name = "EMPL_ROAD_CODE", nullable = true, insertable = true, updatable = true, length = 20)
    public String getEmplRoadCode() {
        return emplRoadCode;
    }

    public void setEmplRoadCode(String emplRoadCode) {
        this.emplRoadCode = emplRoadCode;
    }

    @Basic
    @Column(name = "EMPL_ADDR", nullable = false, insertable = true, updatable = true, length = 100)
    public String getEmplAddr() {
        return emplAddr;
    }

    public void setEmplAddr(String emplAddr) {
        this.emplAddr = emplAddr;
    }

    @Basic
    @Column(name = "EMPL_ADDR_DETL", nullable = false, insertable = true, updatable = true, length = 100)
    public String getEmplAddrDetl() {
        return emplAddrDetl;
    }

    public void setEmplAddrDetl(String emplAddrDetl) {
        this.emplAddrDetl = emplAddrDetl;
    }

    @Basic
    @Column(name = "EMPL_POSITION_CODE", nullable = false, insertable = true, updatable = true, length = 3)
    public String getEmplPositionCode() {
        return emplPositionCode;
    }

    public void setEmplPositionCode(String emplPositionCode) {
        this.emplPositionCode = emplPositionCode;
    }

    @Basic
    @Column(name = "EMPL_STATUS", nullable = false, insertable = true, updatable = true, length = 2)
    public String getEmplStatus() {
        return emplStatus;
    }

    public void setEmplStatus(String emplStatus) {
        this.emplStatus = emplStatus;
    }

    @Basic
    @Column(name = "EMPL_STATUS_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getEmplStatusDate() {
        return emplStatusDate;
    }

    public void setEmplStatusDate(Timestamp emplStatusDate) {
        this.emplStatusDate = emplStatusDate;
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
    @Column(name = "DEPT_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (emplCode != null ? !emplCode.equals(employee.emplCode) : employee.emplCode != null) return false;
        if (emplNumber != null ? !emplNumber.equals(employee.emplNumber) : employee.emplNumber != null) return false;
        if (emplName != null ? !emplName.equals(employee.emplName) : employee.emplName != null) return false;
        if (emplSex != null ? !emplSex.equals(employee.emplSex) : employee.emplSex != null) return false;
        if (emplBirthDay != null ? !emplBirthDay.equals(employee.emplBirthDay) : employee.emplBirthDay != null)
            return false;
        if (emplZip != null ? !emplZip.equals(employee.emplZip) : employee.emplZip != null) return false;
        if (emplRoadCode != null ? !emplRoadCode.equals(employee.emplRoadCode) : employee.emplRoadCode != null)
            return false;
        if (emplAddr != null ? !emplAddr.equals(employee.emplAddr) : employee.emplAddr != null) return false;
        if (emplAddrDetl != null ? !emplAddrDetl.equals(employee.emplAddrDetl) : employee.emplAddrDetl != null)
            return false;
        if (emplPositionCode != null ? !emplPositionCode.equals(employee.emplPositionCode) : employee.emplPositionCode != null)
            return false;
        if (emplStatus != null ? !emplStatus.equals(employee.emplStatus) : employee.emplStatus != null) return false;
        if (emplStatusDate != null ? !emplStatusDate.equals(employee.emplStatusDate) : employee.emplStatusDate != null)
            return false;
        if (branchCode != null ? !branchCode.equals(employee.branchCode) : employee.branchCode != null) return false;
        return deptCode != null ? deptCode.equals(employee.deptCode) : employee.deptCode == null;
    }

    @Override
    public int hashCode() {
        int result = emplCode != null ? emplCode.hashCode() : 0;
        result = 31 * result + (emplNumber != null ? emplNumber.hashCode() : 0);
        result = 31 * result + (emplName != null ? emplName.hashCode() : 0);
        result = 31 * result + (emplSex != null ? emplSex.hashCode() : 0);
        result = 31 * result + (emplBirthDay != null ? emplBirthDay.hashCode() : 0);
        result = 31 * result + (emplZip != null ? emplZip.hashCode() : 0);
        result = 31 * result + (emplRoadCode != null ? emplRoadCode.hashCode() : 0);
        result = 31 * result + (emplAddr != null ? emplAddr.hashCode() : 0);
        result = 31 * result + (emplAddrDetl != null ? emplAddrDetl.hashCode() : 0);
        result = 31 * result + (emplPositionCode != null ? emplPositionCode.hashCode() : 0);
        result = 31 * result + (emplStatus != null ? emplStatus.hashCode() : 0);
        result = 31 * result + (emplStatusDate != null ? emplStatusDate.hashCode() : 0);
        result = 31 * result + (branchCode != null ? branchCode.hashCode() : 0);
        result = 31 * result + (deptCode != null ? deptCode.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "DEPT_CODE", referencedColumnName = "DEPT_CODE", nullable = false)
    public Department getDepartmentByDeptCode() {
        return departmentByDeptCode;
    }

    public void setDepartmentByDeptCode(Department departmentByDeptCode) {
        this.departmentByDeptCode = departmentByDeptCode;
    }

    @OneToMany(mappedBy = "employeeByEmplEmployeeCode")
    public Collection<EmployeeContSecInfo> getEmployeeContSecInfosByEmplCode() {
        return employeeContSecInfosByEmplCode;
    }

    public void setEmployeeContSecInfosByEmplCode(Collection<EmployeeContSecInfo> employeeContSecInfosByEmplCode) {
        this.employeeContSecInfosByEmplCode = employeeContSecInfosByEmplCode;
    }

    @OneToMany(mappedBy = "employeeByEmplCode")
    public Collection<EmpRoles> getEmpRolesByEmplCode() {
        return empRolesByEmplCode;
    }

    public void setEmpRolesByEmplCode(Collection<EmpRoles> empRolesByEmplCode) {
        this.empRolesByEmplCode = empRolesByEmplCode;
    }
}
