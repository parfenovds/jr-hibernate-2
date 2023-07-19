package movie.repository;

import java.util.Optional;
import movie.entity.Inventory;
import movie.entity.Rental;

public class RentalRepository extends BaseRepositoryImpl<Integer, Rental> {
  public RentalRepository() {
    super(Rental.class);
  }

  public Optional<Rental> findLastForInventory(Inventory inventory) {
    return sessionFactory.getCurrentSession()
        .createQuery("""
            SELECT r FROM Rental r
            WHERE r.inventory.id = :inventoryId
            ORDER BY r.rentalDate DESC
            """, Rental.class)
        .setMaxResults(1)
        .setParameter("inventoryId", inventory.getId())
        .uniqueResultOptional();
  }
}
