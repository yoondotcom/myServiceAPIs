package kr.my.members.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
public class Stipulation {
    private String stipCode;
    private String stipName;
    private String stipContents;
    private Integer stipStep;
    private String stipStatus;
    private Timestamp stipStatusDate;
    private String stipGroup;
    private Collection<EmpAgreeys> empAgreeysesByStipCode;
    private Collection<MemAgreeys> memAgreeysesByStipCode;
    private Stipulation stipulationByStipGroup;
    private Collection<Stipulation> stipulationsByStipCode;

    @Id
    @Column(name = "STIP_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getStipCode() {
        return stipCode;
    }

    public void setStipCode(String stipCode) {
        this.stipCode = stipCode;
    }

    @Basic
    @Column(name = "STIP_NAME", nullable = false, insertable = true, updatable = true, length = 200)
    public String getStipName() {
        return stipName;
    }

    public void setStipName(String stipName) {
        this.stipName = stipName;
    }

    @Basic
    @Column(name = "STIP_CONTENTS", nullable = false, insertable = true, updatable = true, length = 5000)
    public String getStipContents() {
        return stipContents;
    }

    public void setStipContents(String stipContents) {
        this.stipContents = stipContents;
    }

    @Basic
    @Column(name = "STIP_STEP", nullable = false, insertable = true, updatable = true)
    public Integer getStipStep() {
        return stipStep;
    }

    public void setStipStep(Integer stipStep) {
        this.stipStep = stipStep;
    }

    @Basic
    @Column(name = "STIP_STATUS", nullable = false, insertable = true, updatable = true, length = 2)
    public String getStipStatus() {
        return stipStatus;
    }

    public void setStipStatus(String stipStatus) {
        this.stipStatus = stipStatus;
    }

    @Basic
    @Column(name = "STIP_STATUS_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getStipStatusDate() {
        return stipStatusDate;
    }

    public void setStipStatusDate(Timestamp stipStatusDate) {
        this.stipStatusDate = stipStatusDate;
    }

    @Basic
    @Column(name = "STIP_GROUP", nullable = false, insertable = true, updatable = true, length = 15)
    public String getStipGroup() {
        return stipGroup;
    }

    public void setStipGroup(String stipGroup) {
        this.stipGroup = stipGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stipulation that = (Stipulation) o;

        if (stipCode != null ? !stipCode.equals(that.stipCode) : that.stipCode != null) return false;
        if (stipName != null ? !stipName.equals(that.stipName) : that.stipName != null) return false;
        if (stipContents != null ? !stipContents.equals(that.stipContents) : that.stipContents != null) return false;
        if (stipStep != null ? !stipStep.equals(that.stipStep) : that.stipStep != null) return false;
        if (stipStatus != null ? !stipStatus.equals(that.stipStatus) : that.stipStatus != null) return false;
        if (stipStatusDate != null ? !stipStatusDate.equals(that.stipStatusDate) : that.stipStatusDate != null)
            return false;
        return stipGroup != null ? stipGroup.equals(that.stipGroup) : that.stipGroup == null;
    }

    @Override
    public int hashCode() {
        int result = stipCode != null ? stipCode.hashCode() : 0;
        result = 31 * result + (stipName != null ? stipName.hashCode() : 0);
        result = 31 * result + (stipContents != null ? stipContents.hashCode() : 0);
        result = 31 * result + (stipStep != null ? stipStep.hashCode() : 0);
        result = 31 * result + (stipStatus != null ? stipStatus.hashCode() : 0);
        result = 31 * result + (stipStatusDate != null ? stipStatusDate.hashCode() : 0);
        result = 31 * result + (stipGroup != null ? stipGroup.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "stipulationByStipulationStipCode")
    public Collection<EmpAgreeys> getEmpAgreeysesByStipCode() {
        return empAgreeysesByStipCode;
    }

    public void setEmpAgreeysesByStipCode(Collection<EmpAgreeys> empAgreeysesByStipCode) {
        this.empAgreeysesByStipCode = empAgreeysesByStipCode;
    }

    @OneToMany(mappedBy = "stipulationByStipCode")
    public Collection<MemAgreeys> getMemAgreeysesByStipCode() {
        return memAgreeysesByStipCode;
    }

    public void setMemAgreeysesByStipCode(Collection<MemAgreeys> memAgreeysesByStipCode) {
        this.memAgreeysesByStipCode = memAgreeysesByStipCode;
    }

    @ManyToOne
    @JoinColumn(name = "STIP_GROUP", referencedColumnName = "STIP_CODE", nullable = false)
    public Stipulation getStipulationByStipGroup() {
        return stipulationByStipGroup;
    }

    public void setStipulationByStipGroup(Stipulation stipulationByStipGroup) {
        this.stipulationByStipGroup = stipulationByStipGroup;
    }

    @OneToMany(mappedBy = "stipulationByStipGroup")
    public Collection<Stipulation> getStipulationsByStipCode() {
        return stipulationsByStipCode;
    }

    public void setStipulationsByStipCode(Collection<Stipulation> stipulationsByStipCode) {
        this.stipulationsByStipCode = stipulationsByStipCode;
    }
}
