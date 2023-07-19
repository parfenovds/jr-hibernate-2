package movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "films")
@Entity
@Builder
@Table(name = "actor", schema = "movie")
public class Actor extends AuditableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "actor_id")
  private Integer id;

  @Column(name = "first_name", length = 45, nullable = false)
  private String firstname;

  @Column(name = "last_name", length = 45, nullable = false)
  private String lastname;

  @Builder.Default
  @ManyToMany(mappedBy = "actors")
  private Set<Film> films = new HashSet<>();
}
