package by.theiou.backendtodo.business.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Activity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "activated", nullable = false)
    private Short activated;
    @Basic
    @Column(name = "uuid", nullable = false, length = -1)
    private String uuid;
    @Basic
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserData userDataByUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getActivated() {
        return activated;
    }

    public void setActivated(Short activated) {
        this.activated = activated;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(id, activity.id) && Objects.equals(activated, activity.activated) && Objects.equals(uuid, activity.uuid) && Objects.equals(userId, activity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activated, uuid, userId);
    }

    public UserData getUserDataByUserId() {
        return userDataByUserId;
    }

    public void setUserDataByUserId(UserData userDataByUserId) {
        this.userDataByUserId = userDataByUserId;
    }
}
