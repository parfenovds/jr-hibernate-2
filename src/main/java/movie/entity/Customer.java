package movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"rentals", "payments"})
@SuperBuilder
@Entity
@Table(name = "customer", schema = "movie")
public class Customer extends Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private Integer id;

  @CreationTimestamp
  @Column(name = "create_date", nullable = false)
  private LocalDateTime creatDate;

  @Builder.Default
  @OneToMany(mappedBy = "customer")
  private Set<Rental> rentals = new HashSet<>();

  @Builder.Default
  @OneToMany(mappedBy = "customer")
  private Set<Payment> payments = new HashSet<>();
}
