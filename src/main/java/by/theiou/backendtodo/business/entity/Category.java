package by.theiou.backendtodo.business.entity;

import by.theiou.backendtodo.auth.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Collection;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "completed_count")
    private Long completedCount;

    @Column(name = "uncompleted_count")
    private Long uncompletedCount;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}
