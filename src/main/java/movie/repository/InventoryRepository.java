package movie.repository;

import movie.entity.Inventory;

public class InventoryRepository extends BaseRepositoryImpl<Integer, Inventory> {
  public InventoryRepository() {
    super(Inventory.class);
  }
}
