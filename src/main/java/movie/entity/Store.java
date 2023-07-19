package movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, of = {"id"})
@ToString(exclude = {"staff", "customers", "inventories"})
@Builder
@Entity
@Table(name = "store", schema = "movie")
public class Store extends AuditableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "store_id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "manager_staff_id")
  private Staff managerStaff;

  @ManyToOne
  @JoinColumn(name = "address_id")
  private Address address;

  @Builder.Default
  @OneToMany(mappedBy = "store")
  private Set<Staff> staff = new HashSet<>();

  @Builder.Default
  @OneToMany(mappedBy = "store")
  private Set<Customer> customers = new HashSet<>();

  @Builder.Default
  @OneToMany(mappedBy = "store")
  private Set<Inventory> inventories = new HashSet<>();
}
