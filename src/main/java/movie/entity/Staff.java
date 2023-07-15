package movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
@Table(name = "staff", schema = "movie")
public class Staff extends AuditableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "staff_id")
  private Integer id;

  @Column(name = "first_name", length = 45, nullable = false)
  private String firstname;

  @Column(name = "last_name", length = 45, nullable = false)
  private String lastname;

  @ManyToOne
  @JoinColumn(name = "address_id")
  private Address address;

  @Lob
  @Column(name = "picture", columnDefinition="BLOB")
  private byte[] picture;

  @Column(name = "email", length = 50)
  private String email;

  @ManyToOne
  @JoinColumn(name = "store_id")
  private Store store;

  @Column(name = "active", columnDefinition = "TINYINT(1)", nullable = false)
  private Boolean active;

  @Column(name = "username", length = 16, nullable = false)
  private String username;

  @Column(name = "password", length = 40)
  private String password;
}
