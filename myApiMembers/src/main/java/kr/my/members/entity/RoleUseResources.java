package kr.my.members.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
@Table(name = "ROLE_USE_RESOURCES", schema = "", catalog = "MY_MEMBER")
public class RoleUseResources {
    private Long rurSeq;
    private String roleCode;
    private String secrCode;
    private Timestamp rsMapRegDate;
    private Role roleByRoleCode;
    private SecuredResources securedResourcesBySecrCode;

    @Id
    @Column(name = "RUR_SEQ", nullable = false, insertable = true, updatable = true)
    public Long getRurSeq() {
        return rurSeq;
    }

    public void setRurSeq(Long rurSeq) {
        this.rurSeq = rurSeq;
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
    @Column(name = "SECR_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getSecrCode() {
        return secrCode;
    }

    public void setSecrCode(String secrCode) {
        this.secrCode = secrCode;
    }

    @Basic
    @Column(name = "RS_MAP_REG_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getRsMapRegDate() {
        return rsMapRegDate;
    }

    public void setRsMapRegDate(Timestamp rsMapRegDate) {
        this.rsMapRegDate = rsMapRegDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleUseResources that = (RoleUseResources) o;

        if (rurSeq != null ? !rurSeq.equals(that.rurSeq) : that.rurSeq != null) return false;
        if (roleCode != null ? !roleCode.equals(that.roleCode) : that.roleCode != null) return false;
        if (secrCode != null ? !secrCode.equals(that.secrCode) : that.secrCode != null) return false;
        if (rsMapRegDate != null ? !rsMapRegDate.equals(that.rsMapRegDate) : that.rsMapRegDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rurSeq != null ? rurSeq.hashCode() : 0;
        result = 31 * result + (roleCode != null ? roleCode.hashCode() : 0);
        result = 31 * result + (secrCode != null ? secrCode.hashCode() : 0);
        result = 31 * result + (rsMapRegDate != null ? rsMapRegDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ROLE_CODE", referencedColumnName = "ROLE_CODE", nullable = false)
    public Role getRoleByRoleCode() {
        return roleByRoleCode;
    }

    public void setRoleByRoleCode(Role roleByRoleCode) {
        this.roleByRoleCode = roleByRoleCode;
    }

    @ManyToOne
    @JoinColumn(name = "SECR_CODE", referencedColumnName = "SECR_CODE", nullable = false)
    public SecuredResources getSecuredResourcesBySecrCode() {
        return securedResourcesBySecrCode;
    }

    public void setSecuredResourcesBySecrCode(SecuredResources securedResourcesBySecrCode) {
        this.securedResourcesBySecrCode = securedResourcesBySecrCode;
    }
}
