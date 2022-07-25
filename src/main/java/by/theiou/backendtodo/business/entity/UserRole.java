package by.theiou.backendtodo.business.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_role", schema = "tasklist", catalog = "postgres")
public class UserRole {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Basic
    @Column(name = "role_id", nullable = false)
    private Long roleId;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserData userDataByUserId;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private RoleData roleDataByRoleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(userId, userRole.userId) && Objects.equals(roleId, userRole.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }

    public UserData getUserDataByUserId() {
        return userDataByUserId;
    }

    public void setUserDataByUserId(UserData userDataByUserId) {
        this.userDataByUserId = userDataByUserId;
    }

    public RoleData getRoleDataByRoleId() {
        return roleDataByRoleId;
    }

    public void setRoleDataByRoleId(RoleData roleDataByRoleId) {
        this.roleDataByRoleId = roleDataByRoleId;
    }
}
