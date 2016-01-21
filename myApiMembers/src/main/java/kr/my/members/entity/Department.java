package kr.my.members.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
public class Department {
    private String deptCode;
    private String deptName;
    private String deptGroupCode;
    private Integer deptSort;
    private Integer deptLevel;
    private String deptStatus;
    private Timestamp deptStatusDate;
    private String branchCode;
    private Department departmentByDeptGroupCode;
    private Collection<Department> departmentsByDeptCode;
    private Branch branchByBranchCode;
    private Collection<Employee> employeesByDeptCode;

    @Id
    @Column(name = "DEPT_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    @Basic
    @Column(name = "DEPT_NAME", nullable = false, insertable = true, updatable = true, length = 200)
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "DEPT_GROUP_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getDeptGroupCode() {
        return deptGroupCode;
    }

    public void setDeptGroupCode(String deptGroupCode) {
        this.deptGroupCode = deptGroupCode;
    }

    @Basic
    @Column(name = "DEPT_SORT", nullable = false, insertable = true, updatable = true)
    public Integer getDeptSort() {
        return deptSort;
    }

    public void setDeptSort(Integer deptSort) {
        this.deptSort = deptSort;
    }

    @Basic
    @Column(name = "DEPT_LEVEL", nullable = false, insertable = true, updatable = true)
    public Integer getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(Integer deptLevel) {
        this.deptLevel = deptLevel;
    }

    @Basic
    @Column(name = "DEPT_STATUS", nullable = false, insertable = true, updatable = true, length = 2)
    public String getDeptStatus() {
        return deptStatus;
    }

    public void setDeptStatus(String deptStatus) {
        this.deptStatus = deptStatus;
    }

    @Basic
    @Column(name = "DEPT_STATUS_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getDeptStatusDate() {
        return deptStatusDate;
    }

    public void setDeptStatusDate(Timestamp deptStatusDate) {
        this.deptStatusDate = deptStatusDate;
    }

    @Basic
    @Column(name = "BRANCH_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (deptCode != null ? !deptCode.equals(that.deptCode) : that.deptCode != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;
        if (deptGroupCode != null ? !deptGroupCode.equals(that.deptGroupCode) : that.deptGroupCode != null)
            return false;
        if (deptSort != null ? !deptSort.equals(that.deptSort) : that.deptSort != null) return false;
        if (deptLevel != null ? !deptLevel.equals(that.deptLevel) : that.deptLevel != null) return false;
        if (deptStatus != null ? !deptStatus.equals(that.deptStatus) : that.deptStatus != null) return false;
        if (deptStatusDate != null ? !deptStatusDate.equals(that.deptStatusDate) : that.deptStatusDate != null)
            return false;
        if (branchCode != null ? !branchCode.equals(that.branchCode) : that.branchCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deptCode != null ? deptCode.hashCode() : 0;
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        result = 31 * result + (deptGroupCode != null ? deptGroupCode.hashCode() : 0);
        result = 31 * result + (deptSort != null ? deptSort.hashCode() : 0);
        result = 31 * result + (deptLevel != null ? deptLevel.hashCode() : 0);
        result = 31 * result + (deptStatus != null ? deptStatus.hashCode() : 0);
        result = 31 * result + (deptStatusDate != null ? deptStatusDate.hashCode() : 0);
        result = 31 * result + (branchCode != null ? branchCode.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "DEPT_GROUP_CODE", referencedColumnName = "DEPT_CODE", nullable = false)
    public Department getDepartmentByDeptGroupCode() {
        return departmentByDeptGroupCode;
    }

    public void setDepartmentByDeptGroupCode(Department departmentByDeptGroupCode) {
        this.departmentByDeptGroupCode = departmentByDeptGroupCode;
    }

    @OneToMany(mappedBy = "departmentByDeptGroupCode")
    public Collection<Department> getDepartmentsByDeptCode() {
        return departmentsByDeptCode;
    }

    public void setDepartmentsByDeptCode(Collection<Department> departmentsByDeptCode) {
        this.departmentsByDeptCode = departmentsByDeptCode;
    }

    @ManyToOne
    @JoinColumn(name = "BRANCH_CODE", referencedColumnName = "BRANCH_CODE", nullable = false)
    public Branch getBranchByBranchCode() {
        return branchByBranchCode;
    }

    public void setBranchByBranchCode(Branch branchByBranchCode) {
        this.branchByBranchCode = branchByBranchCode;
    }

    @OneToMany(mappedBy = "departmentByDeptCode")
    public Collection<Employee> getEmployeesByDeptCode() {
        return employeesByDeptCode;
    }

    public void setEmployeesByDeptCode(Collection<Employee> employeesByDeptCode) {
        this.employeesByDeptCode = employeesByDeptCode;
    }
}
