package movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "address", schema = "movie")
public class Address extends AuditableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "address_id")
  private Integer id;

  @Column(name = "address", length = 50, nullable = false)
  private String address;

  @Column(name = "address2", length = 50)
  private String address2;

  @Column(name = "district", length = 20, nullable = false)
  private String district;

  @ManyToOne
  @JoinColumn(name = "city_id")
  private City city;

  @Column(name = "postal_code", length = 10)
  private String postalCode;

  @Column(name = "phone", length = 20)
  private String phone;
}
