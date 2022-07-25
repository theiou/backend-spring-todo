package by.theiou.backendtodo.business.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;
    @Basic
    @Column(name = "completed", nullable = true)
    private Short completed;
    @Basic
    @Column(name = "task_date", nullable = true)
    private Timestamp taskDate;
    @Basic
    @Column(name = "priority_id", nullable = true)
    private Long priorityId;
    @Basic
    @Column(name = "category_id", nullable = true)
    private Long categoryId;
    @Basic
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    private Priority priorityByPriorityId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category categoryByCategoryId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserData userDataByUserId;

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

    public Short getCompleted() {
        return completed;
    }

    public void setCompleted(Short completed) {
        this.completed = completed;
    }

    public Timestamp getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Timestamp taskDate) {
        this.taskDate = taskDate;
    }

    public Long getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Long priorityId) {
        this.priorityId = priorityId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(completed, task.completed) && Objects.equals(taskDate, task.taskDate) && Objects.equals(priorityId, task.priorityId) && Objects.equals(categoryId, task.categoryId) && Objects.equals(userId, task.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, completed, taskDate, priorityId, categoryId, userId);
    }

    public Priority getPriorityByPriorityId() {
        return priorityByPriorityId;
    }

    public void setPriorityByPriorityId(Priority priorityByPriorityId) {
        this.priorityByPriorityId = priorityByPriorityId;
    }

    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    public UserData getUserDataByUserId() {
        return userDataByUserId;
    }

    public void setUserDataByUserId(UserData userDataByUserId) {
        this.userDataByUserId = userDataByUserId;
    }
}
