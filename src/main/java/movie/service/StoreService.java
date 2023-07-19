package movie.service;

import java.util.List;
import movie.entity.City;
import movie.entity.Customer;
import movie.entity.Store;
import movie.exception.NotFoundException;
import movie.repository.StoreRepository;
import movie.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
//    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//    session.getTransaction().begin();
    Store store = storeRepository.findById(id).orElseThrow(() -> new NotFoundException(Store.class, id));
//    session.getTransaction().commit();
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
