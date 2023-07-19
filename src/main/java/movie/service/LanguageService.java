package movie.service;

import java.util.List;
import movie.entity.Language;
import movie.exception.NotFoundException;
import movie.repository.LanguageRepository;

public class LanguageService implements BaseService<Integer, Language> {
  private final LanguageRepository languageRepository;

  public LanguageService(LanguageRepository languageRepository) {
    this.languageRepository = languageRepository;
  }

  @Override
  public Language save(Language entity) {
    return null;
  }

  @Override
  public Language findById(Integer id) {
    return languageRepository.findById(id).orElseThrow(() -> new NotFoundException(Language.class, id));
  }

  @Override
  public List<Language> findAll() {
    return null;
  }

  @Override
  public Language update(Integer id, Language entity) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {

  }
}
