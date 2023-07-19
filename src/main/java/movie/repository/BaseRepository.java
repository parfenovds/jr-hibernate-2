package movie.repository;

import java.util.List;
import java.util.Optional;
import movie.entity.AuditableEntity;

public interface BaseRepository<K, E extends AuditableEntity> {

  E save(E entity);

  Optional<E> findById(K id);

  List<E> findAll();

  E update(E entity);

  void deleteById(K id);


  void delete(E entity);

}