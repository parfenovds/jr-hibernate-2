package movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.Instant;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
public abstract class AuditableEntity {

  @UpdateTimestamp
  @Column(name = "last_update", nullable = false)
  private Instant lastUpdate;

  public AuditableEntity(Instant lastUpdate) {
    this.lastUpdate = lastUpdate;
  }
}
