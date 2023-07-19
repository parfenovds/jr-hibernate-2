package movie.service;

import java.util.List;
import movie.entity.Category;
import movie.exception.NotFoundException;
import movie.repository.CategoryRepository;

public class CategoryService implements BaseService<Integer, Category> {

  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public Category save(Category entity) {
    return null;
  }

  @Override
  public Category findById(Integer id) {
    return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(Category.class, id));
  }

  @Override
  public List<Category> findAll() {
    return null;
  }

  @Override
  public Category update(Integer id, Category entity) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {

  }
}
