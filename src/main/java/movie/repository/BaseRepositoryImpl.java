package movie.repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import movie.entity.AuditableEntity;
import movie.util.HibernateUtil;
import org.hibernate.SessionFactory;

public abstract class BaseRepositoryImpl<K, E extends AuditableEntity>
    implements BaseRepository<K, E> {

  final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
  private final Class<E> entityClass;

  public BaseRepositoryImpl(Class<E> entityClass) {
    this.entityClass = entityClass;
  }

  @Override
  public E save(E entity) {
    sessionFactory.getCurrentSession().persist(entity);
    return entity;
  }

  @Override
  public Optional<E> findById(K id) {
    return Optional.ofNullable(sessionFactory.getCurrentSession().get(entityClass, id));
  }

  @Override
  public List<E> findAll() {
    return sessionFactory.getCurrentSession()
        .createQuery("SELECT entity FROM " + entityClass.getSimpleName() + " entity ORDER BY entity.id", entityClass)
        .getResultList();
  }

  @Override
  public E update(E entity) {
    return sessionFactory.getCurrentSession().merge(entity);
  }

  @Override
  public void deleteById(K id) {
    E entity = sessionFactory.getCurrentSession().get(entityClass, id);
    if (Objects.nonNull(entity)) {
      sessionFactory.getCurrentSession().remove(entity);
    }
  }

  @Override
  public void delete(E entity) {
    sessionFactory.getCurrentSession().remove(entity);
  }
}
