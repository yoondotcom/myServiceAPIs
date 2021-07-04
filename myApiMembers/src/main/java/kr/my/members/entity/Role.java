package kr.my.members.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@Entity
public class Role {
    private String roleCode;
    private String roleName;
    private String roleDescription;
    private Integer roleSort;
    private Integer roleLevel;
    private String roleGroup;
    private String roleStatus;
    private Timestamp roleStatusDate;
    private Role roleByRoleGroup;
    private Collection<Role> rolesByRoleCode;
    private Collection<RoleUseResources> roleUseResourcesByRoleCode;

    @Id
    @Column(name = "ROLE_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Basic
    @Column(name = "ROLE_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "ROLE_DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 300)
    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Basic
    @Column(name = "ROLE_SORT", nullable = true, insertable = true, updatable = true)
    public Integer getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    @Basic
    @Column(name = "ROLE_LEVEL", nullable = true, insertable = true, updatable = true)
    public Integer getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }

    @Basic
    @Column(name = "ROLE_GROUP", nullable = false, insertable = true, updatable = true, length = 15)
    public String getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }

    @Basic
    @Column(name = "ROLE_STATUS", nullable = false, insertable = true, updatable = true, length = 2)
    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    @Basic
    @Column(name = "ROLE_STATUS_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getRoleStatusDate() {
        return roleStatusDate;
    }

    public void setRoleStatusDate(Timestamp roleStatusDate) {
        this.roleStatusDate = roleStatusDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (roleCode != null ? !roleCode.equals(role.roleCode) : role.roleCode != null) return false;
        if (roleName != null ? !roleName.equals(role.roleName) : role.roleName != null) return false;
        if (roleDescription != null ? !roleDescription.equals(role.roleDescription) : role.roleDescription != null)
            return false;
        if (roleSort != null ? !roleSort.equals(role.roleSort) : role.roleSort != null) return false;
        if (roleLevel != null ? !roleLevel.equals(role.roleLevel) : role.roleLevel != null) return false;
        if (roleGroup != null ? !roleGroup.equals(role.roleGroup) : role.roleGroup != null) return false;
        if (roleStatus != null ? !roleStatus.equals(role.roleStatus) : role.roleStatus != null) return false;
        return roleStatusDate != null ? roleStatusDate.equals(role.roleStatusDate) : role.roleStatusDate == null;
    }

    @Override
    public int hashCode() {
        int result = roleCode != null ? roleCode.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (roleDescription != null ? roleDescription.hashCode() : 0);
        result = 31 * result + (roleSort != null ? roleSort.hashCode() : 0);
        result = 31 * result + (roleLevel != null ? roleLevel.hashCode() : 0);
        result = 31 * result + (roleGroup != null ? roleGroup.hashCode() : 0);
        result = 31 * result + (roleStatus != null ? roleStatus.hashCode() : 0);
        result = 31 * result + (roleStatusDate != null ? roleStatusDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ROLE_GROUP", referencedColumnName = "ROLE_CODE", nullable = false)
    public Role getRoleByRoleGroup() {
        return roleByRoleGroup;
    }

    public void setRoleByRoleGroup(Role roleByRoleGroup) {
        this.roleByRoleGroup = roleByRoleGroup;
    }

    @OneToMany(mappedBy = "roleByRoleGroup")
    public Collection<Role> getRolesByRoleCode() {
        return rolesByRoleCode;
    }

    public void setRolesByRoleCode(Collection<Role> rolesByRoleCode) {
        this.rolesByRoleCode = rolesByRoleCode;
    }

    @OneToMany(mappedBy = "roleByRoleCode")
    public Collection<RoleUseResources> getRoleUseResourcesByRoleCode() {
        return roleUseResourcesByRoleCode;
    }

    public void setRoleUseResourcesByRoleCode(Collection<RoleUseResources> roleUseResourcesByRoleCode) {
        this.roleUseResourcesByRoleCode = roleUseResourcesByRoleCode;
    }
}
