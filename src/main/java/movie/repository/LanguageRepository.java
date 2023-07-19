package movie.repository;

import movie.entity.Language;

public class LanguageRepository extends BaseRepositoryImpl<Integer, Language> {
  public LanguageRepository() {
    super(Language.class);
  }
}
