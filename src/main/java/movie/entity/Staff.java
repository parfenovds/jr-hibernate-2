package movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"managedStores", "rentals", "payments"})
@SuperBuilder
@Entity
@Table(name = "staff", schema = "movie")
public class Staff extends Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "staff_id")
  private Integer id;

  @Lob
  @Column(name = "picture", columnDefinition="BLOB")
  private byte[] picture;

  @Column(name = "username", length = 16, nullable = false)
  private String username;

  @Column(name = "password", length = 40)
  private String password;

  @Builder.Default
  @OneToMany(mappedBy = "managerStaff")
  private Set<Store> managedStores = new HashSet<>();

  @Builder.Default
  @OneToMany(mappedBy = "staff")
  private Set<Rental> rentals = new HashSet<>();

  @Builder.Default
  @OneToMany(mappedBy = "staff")
  private Set<Payment> payments = new HashSet<>();
}
