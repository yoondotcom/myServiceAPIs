package kr.my.members.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
public class Branch {
    private String branchCode;
    private String branchName;
    private String branchCorpRegNum;
    private String branchEntrRegNum;
    private String branchTel;
    private String branchFax;
    private String branchZip;
    private String branchRoadCode;
    private String branchAddr;
    private String branchAddrDetl;
    private String branchExp;
    private String branchGroup;
    private Integer branchSort;
    private Integer branchLevel;
    private String branchStatus;
    private Timestamp branchStatusDate;
    private Branch branchByBranchGroup;
    private Collection<Branch> branchesByBranchCode;
    private Collection<Department> departmentsByBranchCode;
    private Collection<SignUpInfo> signUpInfosByBranchCode;

    @Id
    @Column(name = "BRANCH_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    @Basic
    @Column(name = "BRANCH_NAME", nullable = false, insertable = true, updatable = true, length = 200)
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Basic
    @Column(name = "BRANCH_CORP_REG_NUM", nullable = true, insertable = true, updatable = true, length = 15)
    public String getBranchCorpRegNum() {
        return branchCorpRegNum;
    }

    public void setBranchCorpRegNum(String branchCorpRegNum) {
        this.branchCorpRegNum = branchCorpRegNum;
    }

    @Basic
    @Column(name = "BRANCH_ENTR_REG_NUM", nullable = true, insertable = true, updatable = true, length = 15)
    public String getBranchEntrRegNum() {
        return branchEntrRegNum;
    }

    public void setBranchEntrRegNum(String branchEntrRegNum) {
        this.branchEntrRegNum = branchEntrRegNum;
    }

    @Basic
    @Column(name = "BRANCH_TEL", nullable = true, insertable = true, updatable = true, length = 15)
    public String getBranchTel() {
        return branchTel;
    }

    public void setBranchTel(String branchTel) {
        this.branchTel = branchTel;
    }

    @Basic
    @Column(name = "BRANCH_FAX", nullable = true, insertable = true, updatable = true, length = 15)
    public String getBranchFax() {
        return branchFax;
    }

    public void setBranchFax(String branchFax) {
        this.branchFax = branchFax;
    }

    @Basic
    @Column(name = "BRANCH_ZIP", nullable = true, insertable = true, updatable = true, length = 10)
    public String getBranchZip() {
        return branchZip;
    }

    public void setBranchZip(String branchZip) {
        this.branchZip = branchZip;
    }

    @Basic
    @Column(name = "BRANCH_ROAD_CODE", nullable = true, insertable = true, updatable = true, length = 20)
    public String getBranchRoadCode() {
        return branchRoadCode;
    }

    public void setBranchRoadCode(String branchRoadCode) {
        this.branchRoadCode = branchRoadCode;
    }

    @Basic
    @Column(name = "BRANCH_ADDR", nullable = true, insertable = true, updatable = true, length = 100)
    public String getBranchAddr() {
        return branchAddr;
    }

    public void setBranchAddr(String branchAddr) {
        this.branchAddr = branchAddr;
    }

    @Basic
    @Column(name = "BRANCH_ADDR_DETL", nullable = true, insertable = true, updatable = true, length = 100)
    public String getBranchAddrDetl() {
        return branchAddrDetl;
    }

    public void setBranchAddrDetl(String branchAddrDetl) {
        this.branchAddrDetl = branchAddrDetl;
    }

    @Basic
    @Column(name = "BRANCH_EXP", nullable = true, insertable = true, updatable = true, length = 500)
    public String getBranchExp() {
        return branchExp;
    }

    public void setBranchExp(String branchExp) {
        this.branchExp = branchExp;
    }

    @Basic
    @Column(name = "BRANCH_GROUP", nullable = false, insertable = true, updatable = true, length = 15)
    public String getBranchGroup() {
        return branchGroup;
    }

    public void setBranchGroup(String branchGroup) {
        this.branchGroup = branchGroup;
    }

    @Basic
    @Column(name = "BRANCH_SORT", nullable = false, insertable = true, updatable = true)
    public Integer getBranchSort() {
        return branchSort;
    }

    public void setBranchSort(Integer branchSort) {
        this.branchSort = branchSort;
    }

    @Basic
    @Column(name = "BRANCH_LEVEL", nullable = false, insertable = true, updatable = true)
    public Integer getBranchLevel() {
        return branchLevel;
    }

    public void setBranchLevel(Integer branchLevel) {
        this.branchLevel = branchLevel;
    }

    @Basic
    @Column(name = "BRANCH_STATUS", nullable = false, insertable = true, updatable = true, length = 2)
    public String getBranchStatus() {
        return branchStatus;
    }

    public void setBranchStatus(String branchStatus) {
        this.branchStatus = branchStatus;
    }

    @Basic
    @Column(name = "BRANCH_STATUS_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getBranchStatusDate() {
        return branchStatusDate;
    }

    public void setBranchStatusDate(Timestamp branchStatusDate) {
        this.branchStatusDate = branchStatusDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Branch branch = (Branch) o;

        if (branchCode != null ? !branchCode.equals(branch.branchCode) : branch.branchCode != null) return false;
        if (branchName != null ? !branchName.equals(branch.branchName) : branch.branchName != null) return false;
        if (branchCorpRegNum != null ? !branchCorpRegNum.equals(branch.branchCorpRegNum) : branch.branchCorpRegNum != null)
            return false;
        if (branchEntrRegNum != null ? !branchEntrRegNum.equals(branch.branchEntrRegNum) : branch.branchEntrRegNum != null)
            return false;
        if (branchTel != null ? !branchTel.equals(branch.branchTel) : branch.branchTel != null) return false;
        if (branchFax != null ? !branchFax.equals(branch.branchFax) : branch.branchFax != null) return false;
        if (branchZip != null ? !branchZip.equals(branch.branchZip) : branch.branchZip != null) return false;
        if (branchRoadCode != null ? !branchRoadCode.equals(branch.branchRoadCode) : branch.branchRoadCode != null)
            return false;
        if (branchAddr != null ? !branchAddr.equals(branch.branchAddr) : branch.branchAddr != null) return false;
        if (branchAddrDetl != null ? !branchAddrDetl.equals(branch.branchAddrDetl) : branch.branchAddrDetl != null)
            return false;
        if (branchExp != null ? !branchExp.equals(branch.branchExp) : branch.branchExp != null) return false;
        if (branchGroup != null ? !branchGroup.equals(branch.branchGroup) : branch.branchGroup != null) return false;
        if (branchSort != null ? !branchSort.equals(branch.branchSort) : branch.branchSort != null) return false;
        if (branchLevel != null ? !branchLevel.equals(branch.branchLevel) : branch.branchLevel != null) return false;
        if (branchStatus != null ? !branchStatus.equals(branch.branchStatus) : branch.branchStatus != null)
            return false;
        if (branchStatusDate != null ? !branchStatusDate.equals(branch.branchStatusDate) : branch.branchStatusDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = branchCode != null ? branchCode.hashCode() : 0;
        result = 31 * result + (branchName != null ? branchName.hashCode() : 0);
        result = 31 * result + (branchCorpRegNum != null ? branchCorpRegNum.hashCode() : 0);
        result = 31 * result + (branchEntrRegNum != null ? branchEntrRegNum.hashCode() : 0);
        result = 31 * result + (branchTel != null ? branchTel.hashCode() : 0);
        result = 31 * result + (branchFax != null ? branchFax.hashCode() : 0);
        result = 31 * result + (branchZip != null ? branchZip.hashCode() : 0);
        result = 31 * result + (branchRoadCode != null ? branchRoadCode.hashCode() : 0);
        result = 31 * result + (branchAddr != null ? branchAddr.hashCode() : 0);
        result = 31 * result + (branchAddrDetl != null ? branchAddrDetl.hashCode() : 0);
        result = 31 * result + (branchExp != null ? branchExp.hashCode() : 0);
        result = 31 * result + (branchGroup != null ? branchGroup.hashCode() : 0);
        result = 31 * result + (branchSort != null ? branchSort.hashCode() : 0);
        result = 31 * result + (branchLevel != null ? branchLevel.hashCode() : 0);
        result = 31 * result + (branchStatus != null ? branchStatus.hashCode() : 0);
        result = 31 * result + (branchStatusDate != null ? branchStatusDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "BRANCH_GROUP", referencedColumnName = "BRANCH_CODE", nullable = false)
    public Branch getBranchByBranchGroup() {
        return branchByBranchGroup;
    }

    public void setBranchByBranchGroup(Branch branchByBranchGroup) {
        this.branchByBranchGroup = branchByBranchGroup;
    }

    @OneToMany(mappedBy = "branchByBranchGroup")
    public Collection<Branch> getBranchesByBranchCode() {
        return branchesByBranchCode;
    }

    public void setBranchesByBranchCode(Collection<Branch> branchesByBranchCode) {
        this.branchesByBranchCode = branchesByBranchCode;
    }

    @OneToMany(mappedBy = "branchByBranchCode")
    public Collection<Department> getDepartmentsByBranchCode() {
        return departmentsByBranchCode;
    }

    public void setDepartmentsByBranchCode(Collection<Department> departmentsByBranchCode) {
        this.departmentsByBranchCode = departmentsByBranchCode;
    }

    @OneToMany(mappedBy = "branchByBranchCode")
    public Collection<SignUpInfo> getSignUpInfosByBranchCode() {
        return signUpInfosByBranchCode;
    }

    public void setSignUpInfosByBranchCode(Collection<SignUpInfo> signUpInfosByBranchCode) {
        this.signUpInfosByBranchCode = signUpInfosByBranchCode;
    }
}
