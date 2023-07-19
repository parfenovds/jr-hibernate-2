package movie.service;

import java.util.List;
import movie.entity.Customer;
import movie.entity.Staff;
import movie.exception.NotFoundException;
import movie.repository.CustomerRepository;

public class CustomerService implements BaseService<Integer, Customer> {

  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public Customer save(Customer entity) {
    return customerRepository.save(entity);
  }

  @Override
  public Customer findById(Integer id) {
    return customerRepository.findById(id).orElseThrow(() -> new NotFoundException(Staff.class, id));
  }

  @Override
  public List<Customer> findAll() {
    return null;
  }

  @Override
  public Customer update(Integer id, Customer entity) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {

  }
}
