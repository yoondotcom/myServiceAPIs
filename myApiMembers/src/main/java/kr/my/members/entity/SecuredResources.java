package kr.my.members.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "SECURED_RESOURCES", schema = "", catalog = "MY_MEMBER")
public class SecuredResources {
    private String secrCode;
    private String secrName;
    private String secrPattern;
    private String secrDescription;
    private String secrType;
    private String secrStatus;
    private Timestamp secrStatusDate;
    private Collection<RoleUseResources> roleUseResourcesBySecrCode;

    @Id
    @Column(name = "SECR_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getSecrCode() {
        return secrCode;
    }

    public void setSecrCode(String secrCode) {
        this.secrCode = secrCode;
    }

    @Basic
    @Column(name = "SECR_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getSecrName() {
        return secrName;
    }

    public void setSecrName(String secrName) {
        this.secrName = secrName;
    }

    @Basic
    @Column(name = "SECR_PATTERN", nullable = false, insertable = true, updatable = true, length = 200)
    public String getSecrPattern() {
        return secrPattern;
    }

    public void setSecrPattern(String secrPattern) {
        this.secrPattern = secrPattern;
    }

    @Basic
    @Column(name = "SECR_DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 300)
    public String getSecrDescription() {
        return secrDescription;
    }

    public void setSecrDescription(String secrDescription) {
        this.secrDescription = secrDescription;
    }

    @Basic
    @Column(name = "SECR_TYPE", nullable = false, insertable = true, updatable = true, length = 2)
    public String getSecrType() {
        return secrType;
    }

    public void setSecrType(String secrType) {
        this.secrType = secrType;
    }

    @Basic
    @Column(name = "SECR_STATUS", nullable = false, insertable = true, updatable = true, length = 2)
    public String getSecrStatus() {
        return secrStatus;
    }

    public void setSecrStatus(String secrStatus) {
        this.secrStatus = secrStatus;
    }

    @Basic
    @Column(name = "SECR_STATUS_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getSecrStatusDate() {
        return secrStatusDate;
    }

    public void setSecrStatusDate(Timestamp secrStatusDate) {
        this.secrStatusDate = secrStatusDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecuredResources that = (SecuredResources) o;

        if (secrCode != null ? !secrCode.equals(that.secrCode) : that.secrCode != null) return false;
        if (secrName != null ? !secrName.equals(that.secrName) : that.secrName != null) return false;
        if (secrPattern != null ? !secrPattern.equals(that.secrPattern) : that.secrPattern != null) return false;
        if (secrDescription != null ? !secrDescription.equals(that.secrDescription) : that.secrDescription != null)
            return false;
        if (secrType != null ? !secrType.equals(that.secrType) : that.secrType != null) return false;
        if (secrStatus != null ? !secrStatus.equals(that.secrStatus) : that.secrStatus != null) return false;
        if (secrStatusDate != null ? !secrStatusDate.equals(that.secrStatusDate) : that.secrStatusDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = secrCode != null ? secrCode.hashCode() : 0;
        result = 31 * result + (secrName != null ? secrName.hashCode() : 0);
        result = 31 * result + (secrPattern != null ? secrPattern.hashCode() : 0);
        result = 31 * result + (secrDescription != null ? secrDescription.hashCode() : 0);
        result = 31 * result + (secrType != null ? secrType.hashCode() : 0);
        result = 31 * result + (secrStatus != null ? secrStatus.hashCode() : 0);
        result = 31 * result + (secrStatusDate != null ? secrStatusDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "securedResourcesBySecrCode")
    public Collection<RoleUseResources> getRoleUseResourcesBySecrCode() {
        return roleUseResourcesBySecrCode;
    }

    public void setRoleUseResourcesBySecrCode(Collection<RoleUseResources> roleUseResourcesBySecrCode) {
        this.roleUseResourcesBySecrCode = roleUseResourcesBySecrCode;
    }
}
