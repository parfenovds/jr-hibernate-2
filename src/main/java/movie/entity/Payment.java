package movie.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "payment", schema = "movie")
public class Payment extends AuditableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "payment_id")
  private Integer id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "staff_id", nullable = false)
  private Staff staff;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rental_id")
  private Rental rental;

  @Column(name = "amount", nullable = false)
  private Double amount;

  @CreationTimestamp
  @Column(name = "payment_date", nullable = false)
  private LocalDateTime paymentDate;
}
