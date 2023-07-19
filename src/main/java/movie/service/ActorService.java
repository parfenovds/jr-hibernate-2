package movie.service;

import java.util.List;
import movie.entity.Actor;
import movie.exception.NotFoundException;
import movie.repository.ActorRepository;

public class ActorService implements BaseService<Integer, Actor> {
  private final ActorRepository actorRepository;

  public ActorService(ActorRepository actorRepository) {
    this.actorRepository = actorRepository;
  }

  @Override
  public Actor save(Actor entity) {
    return null;
  }

  @Override
  public Actor findById(Integer id) {
    return actorRepository.findById(id).orElseThrow(() -> new NotFoundException(Actor.class, id));
  }

  @Override
  public List<Actor> findAll() {
    return null;
  }

  @Override
  public Actor update(Integer id, Actor entity) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {

  }
}
