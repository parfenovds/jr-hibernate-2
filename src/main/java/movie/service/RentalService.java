package movie.service;

import java.util.List;
import java.util.Optional;
import movie.entity.Inventory;
import movie.entity.Rental;
import movie.repository.RentalRepository;

public class RentalService implements BaseService<Integer, Rental> {
  private final RentalRepository rentalRepository;

  public RentalService(RentalRepository rentalRepository) {
    this.rentalRepository = rentalRepository;
  }

  @Override
  public Rental save(Rental entity) {
    return rentalRepository.save(entity);
  }

  @Override
  public Rental findById(Integer id) {
    return null;
  }

  @Override
  public List<Rental> findAll() {
    return null;
  }

  public Optional<Rental> findLastForInventory(Inventory inventory) {
    return rentalRepository.findLastForInventory(inventory);
  }

  @Override
  public Rental update(Integer id, Rental entity) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {

  }
}
