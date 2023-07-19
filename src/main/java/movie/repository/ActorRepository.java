package movie.repository;

import movie.entity.Actor;

public class ActorRepository extends BaseRepositoryImpl<Integer, Actor> {
  public ActorRepository() {
    super(Actor.class);
  }
}
