package by.theiou.backendtodo.business.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;
    @Basic
    @Column(name = "completed_count", nullable = true)
    private Long completedCount;
    @Basic
    @Column(name = "uncompleted_count", nullable = true)
    private Long uncompletedCount;
    @Basic
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserData userDataByUserId;
    @OneToMany(mappedBy = "categoryByCategoryId")
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

    public Long getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(Long completedCount) {
        this.completedCount = completedCount;
    }

    public Long getUncompletedCount() {
        return uncompletedCount;
    }

    public void setUncompletedCount(Long uncompletedCount) {
        this.uncompletedCount = uncompletedCount;
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
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(title, category.title) && Objects.equals(completedCount, category.completedCount) && Objects.equals(uncompletedCount, category.uncompletedCount) && Objects.equals(userId, category.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, completedCount, uncompletedCount, userId);
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
