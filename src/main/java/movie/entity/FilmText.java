package movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "film_text", schema = "movie")
public class FilmText extends AuditableEntity {
  @Id
  @Column(name = "film_id")
  private Integer id;

  @OneToOne
  @JoinColumn(name = "film_id")
  private Film film;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description")
  private String description;
}
