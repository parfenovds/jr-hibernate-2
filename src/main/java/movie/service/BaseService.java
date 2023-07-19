package movie.service;

import java.util.List;
import movie.entity.AuditableEntity;

public interface BaseService<K, E extends AuditableEntity> {

  E save(E entity);

  E findById(K id);

  List<E> findAll();

  E update(K id, E entity);

  void deleteById(K id);
}
