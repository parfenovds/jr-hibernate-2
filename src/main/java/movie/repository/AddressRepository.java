package movie.repository;

import movie.entity.Address;

public class AddressRepository extends BaseRepositoryImpl<Integer, Address> {
  public AddressRepository() {
    super(Address.class);
  }
}
