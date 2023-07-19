package movie.repository;

import movie.entity.FilmText;

public class FilmTextRepository extends BaseRepositoryImpl<Integer, FilmText> {
  public FilmTextRepository() {
    super(FilmText.class);
  }
}
