package movie.repository;

import movie.entity.Country;

public class CountryRepository extends BaseRepositoryImpl<Integer, Country> {
  public CountryRepository() {
    super(Country.class);
  }
}
