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
    Customer saved = customerRepository.save(entity);
    return saved;
  }

  @Override
  public Customer findById(Integer id) {
    Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException(Staff.class, id));
    return customer;
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
