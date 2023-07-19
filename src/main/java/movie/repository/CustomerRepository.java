package movie.repository;

import movie.entity.Customer;

public class CustomerRepository extends BaseRepositoryImpl<Integer, Customer> {

  public CustomerRepository() {
    super(Customer.class);
  }
}
