package movie.service;

import java.util.List;
import movie.entity.Store;
import movie.exception.NotFoundException;
import movie.repository.StoreRepository;

public class StoreService implements BaseService<Integer, Store> {

  private final StoreRepository storeRepository;

  public StoreService(StoreRepository storeRepository) {
    this.storeRepository = storeRepository;
  }

  @Override
  public Store save(Store entity) {
    return null;
  }

  @Override
  public Store findById(Integer id) {
    Store store = storeRepository.findById(id).orElseThrow(() -> new NotFoundException(Store.class, id));
    return store;
  }

  @Override
  public List<Store> findAll() {
    return null;
  }

  @Override
  public Store update(Integer id, Store entity) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {

  }
}
