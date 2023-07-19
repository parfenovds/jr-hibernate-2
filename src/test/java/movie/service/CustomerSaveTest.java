package movie.service;

import movie.entity.Address;
import movie.entity.City;
import movie.entity.Customer;
import movie.entity.Store;
import movie.repository.CityRepository;
import movie.repository.CustomerRepository;
import movie.repository.StoreRepository;
import movie.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

class CustomerSaveTest {
  private final CustomerRepository customerRepository = new CustomerRepository();
  private final CustomerService customerService = new CustomerService(customerRepository);
  private final CityRepository cityRepository = new CityRepository();
  private final CityService cityService = new CityService(cityRepository);
  private final StoreRepository storeRepository = new StoreRepository();
  private final StoreService storeService = new StoreService(storeRepository);
  @Test
  void save() {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.getTransaction().begin();
    City city = cityService.findById(42);
    Address customerAddress = Address.builder()
        .address("second")
        .district("dis 2")
        .city(city)
        .phone("666")
        .address("Street 3")
        .address("Street 4")
        .build();

    Store store = storeService.findById(1);
    Customer customer = Customer.builder()
        .lastname("world")
        .active(true)
        .firstname("hhh")
        .store(store)
        .address(customerAddress)
        .email("customer@wee.com")
        .build();
    customerService.save(customer);
    session.getTransaction().commit();
  }
}