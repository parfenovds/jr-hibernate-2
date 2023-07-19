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
//    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//    Transaction transaction = session.getTransaction();
//    transaction.begin();
    Customer saved = customerRepository.save(entity);
//    transaction.commit();
    return saved;
  }

  @Override
  public Customer findById(Integer id) {
//    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//    session.getTransaction().begin();
    Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException(Staff.class, id));
//    session.getTransaction().commit();
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
