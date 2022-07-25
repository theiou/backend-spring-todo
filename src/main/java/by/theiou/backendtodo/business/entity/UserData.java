package by.theiou.backendtodo.business.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user_data", schema = "tasklist", catalog = "postgres")
public class UserData {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;
    @Basic
    @Column(name = "username", nullable = false, length = -1)
    private String username;
    @OneToMany(mappedBy = "userDataByUserId")
    private Collection<Activity> activitiesById;
    @OneToMany(mappedBy = "userDataByUserId")
    private Collection<Category> categoriesById;
    @OneToMany(mappedBy = "userDataByUserId")
    private Collection<Priority> prioritiesById;
    @OneToMany(mappedBy = "userDataByUserId")
    private Collection<Stat> statsById;
    @OneToMany(mappedBy = "userDataByUserId")
    private Collection<Task> tasksById;
    @OneToOne(mappedBy = "userDataByUserId")
    private UserRole userRoleById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return Objects.equals(id, userData.id) && Objects.equals(email, userData.email) && Objects.equals(password, userData.password) && Objects.equals(username, userData.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, username);
    }

    public Collection<Activity> getActivitiesById() {
        return activitiesById;
    }

    public void setActivitiesById(Collection<Activity> activitiesById) {
        this.activitiesById = activitiesById;
    }

    public Collection<Category> getCategoriesById() {
        return categoriesById;
    }

    public void setCategoriesById(Collection<Category> categoriesById) {
        this.categoriesById = categoriesById;
    }

    public Collection<Priority> getPrioritiesById() {
        return prioritiesById;
    }

    public void setPrioritiesById(Collection<Priority> prioritiesById) {
        this.prioritiesById = prioritiesById;
    }

    public Collection<Stat> getStatsById() {
        return statsById;
    }

    public void setStatsById(Collection<Stat> statsById) {
        this.statsById = statsById;
    }

    public Collection<Task> getTasksById() {
        return tasksById;
    }

    public void setTasksById(Collection<Task> tasksById) {
        this.tasksById = tasksById;
    }

    public UserRole getUserRoleById() {
        return userRoleById;
    }

    public void setUserRoleById(UserRole userRoleById) {
        this.userRoleById = userRoleById;
    }
}
