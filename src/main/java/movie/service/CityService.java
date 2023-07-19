package movie.service;

import java.util.List;
import movie.entity.City;
import movie.exception.NotFoundException;
import movie.repository.CityRepository;

public class CityService implements BaseService<Integer, City> {

  private final CityRepository cityRepository;

  public CityService(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  @Override
  public City save(City entity) {
    return null;
  }

  @Override
  public City findById(Integer id) {
    return cityRepository.findById(id).orElseThrow(() -> new NotFoundException(City.class, id));
  }

  @Override
  public List<City> findAll() {
    return null;
  }

  @Override
  public City update(Integer id, City entity) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {

  }
}
