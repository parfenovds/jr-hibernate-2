package movie.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@MappedSuperclass
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public abstract class Person extends AuditableEntity {
  @Column(name = "first_name", length = 45, nullable = false)
  private String firstname;

  @Column(name = "last_name", length = 45, nullable = false)
  private String lastname;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "address_id")
  private Address address;

  @Column(name = "email", length = 50)
  private String email;

  @ManyToOne
  @JoinColumn(name = "store_id")
  private Store store;

  @Column(name = "active", columnDefinition = "TINYINT(1)", nullable = false)
  private Boolean active;
}
