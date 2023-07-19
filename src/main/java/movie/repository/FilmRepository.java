package movie.repository;

import java.util.Optional;
import movie.entity.Film;
import org.hibernate.Session;

public class FilmRepository extends BaseRepositoryImpl<Integer, Film> {
  public FilmRepository() {
    super(Film.class);
  }

  public Optional<Film> findByTitle(String title) {
    return sessionFactory.getCurrentSession()
        .createQuery("SELECT f FROM Film f WHERE f.title = :title", Film.class)
        .setParameter("title", title)
        .uniqueResultOptional();
  }
}
