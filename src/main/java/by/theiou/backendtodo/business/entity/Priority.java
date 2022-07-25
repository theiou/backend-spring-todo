package by.theiou.backendtodo.business.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Priority {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;
    @Basic
    @Column(name = "color", nullable = false, length = -1)
    private String color;
    @Basic
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserData userDataByUserId;
    @OneToMany(mappedBy = "priorityByPriorityId")
    private Collection<Task> tasksById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        Priority priority = (Priority) o;
        return Objects.equals(id, priority.id) && Objects.equals(title, priority.title) && Objects.equals(color, priority.color) && Objects.equals(userId, priority.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, color, userId);
    }

    public UserData getUserDataByUserId() {
        return userDataByUserId;
    }

    public void setUserDataByUserId(UserData userDataByUserId) {
        this.userDataByUserId = userDataByUserId;
    }

    public Collection<Task> getTasksById() {
        return tasksById;
    }

    public void setTasksById(Collection<Task> tasksById) {
        this.tasksById = tasksById;
    }
}
