package movie.service;

import java.util.List;
import movie.entity.Film;
import movie.entity.Inventory;
import movie.entity.Store;
import movie.exception.NotFoundException;
import movie.repository.InventoryRepository;

public class InventoryService implements BaseService<Integer, Inventory> {
  private final InventoryRepository inventoryRepository;

  public InventoryService(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  @Override
  public Inventory save(Inventory entity) {
    return null;
  }

  public Inventory createInventoryForFilm(Film film, Store store) {
    Inventory inventory = Inventory.builder()
        .film(film)
        .store(store)
        .build();
    return save(inventory);
  }

  @Override
  public Inventory findById(Integer id) {
    return inventoryRepository.findById(id).orElseThrow(() -> new NotFoundException(Inventory.class, id));
  }

  @Override
  public List<Inventory> findAll() {
    return null;
  }

  @Override
  public Inventory update(Integer id, Inventory entity) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {

  }
}
