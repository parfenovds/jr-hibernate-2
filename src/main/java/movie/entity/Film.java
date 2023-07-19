package movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.Year;
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
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(exclude = {"categories", "actors", "inventories"})
@Builder
@Entity
@Table(name = "film", schema = "movie")
public class Film extends AuditableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "film_id")
  private Integer id;

  @Column(name = "title", length = 128, nullable = false)
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "release_year")
  private Year year;

  @ManyToOne
  @JoinColumn(name = "language_id")
  private Language language;

  @ManyToOne
  @JoinColumn(name = "original_language_id")
  private Language originalLanguage;

  @Column(name = "rental_duration", nullable = false)
  private Integer rentalDuration;

  @Column(name = "rental_rate", nullable = false)
  private Double rentalRate;

  @Column(name = "length")
  private Integer length;

  @Column(name = "replacement_cost")
  private Double replacementCost;

  @Column(name = "rating", columnDefinition = "ENUM('G', 'PG', 'PG-13', 'R', 'NC-17')")
  private String rating;

  @Column(name = "special_features", columnDefinition = "SET('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
  private String specialFeatures;

  @Builder.Default
  @ManyToMany
  @JoinTable(name = "film_category",
      joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
  private Set<Category> categories = new HashSet<>();

  @Builder.Default
  @ManyToMany
  @JoinTable(name = "film_actor",
      joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
      inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
  private Set<Actor> actors = new HashSet<>();

  @Builder.Default
  @OneToMany(mappedBy = "film")
  private Set<Inventory> inventories = new HashSet<>();
}
