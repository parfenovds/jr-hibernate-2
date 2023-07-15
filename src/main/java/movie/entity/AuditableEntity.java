package movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.Instant;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class AuditableEntity {
  @Column(name = "last_update", nullable = false)
  private Instant lastUpdate;

  public AuditableEntity() {
  }

  public Instant getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Instant lastChangeTime) {
    this.lastUpdate = lastChangeTime;
  }
}
