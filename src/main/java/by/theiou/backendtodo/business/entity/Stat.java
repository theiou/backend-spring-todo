package by.theiou.backendtodo.business.entity;

import by.theiou.backendtodo.auth.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class Stat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "completed_total")
    private Long completedTotal;

    @Column(name = "uncompleted_total")
    private Long uncompletedTotal;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
