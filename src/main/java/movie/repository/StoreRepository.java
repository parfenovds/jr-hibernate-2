package movie.repository;

import movie.entity.Store;

public class StoreRepository extends BaseRepositoryImpl<Integer, Store> {
  public StoreRepository() {
    super(Store.class);
  }
}
