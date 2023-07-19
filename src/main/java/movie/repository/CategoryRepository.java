package movie.repository;

import movie.entity.Category;

public class CategoryRepository extends BaseRepositoryImpl<Integer, Category> {

  public CategoryRepository() {
    super(Category.class);
  }
}
