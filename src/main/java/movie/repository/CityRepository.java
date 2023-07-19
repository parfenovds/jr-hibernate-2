package movie.repository;

import movie.entity.City;

public class CityRepository extends BaseRepositoryImpl<Integer, City> {
  public CityRepository() {
    super(City.class);
  }
}
