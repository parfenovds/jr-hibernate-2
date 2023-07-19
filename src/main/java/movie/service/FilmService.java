package movie.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import movie.entity.Customer;
import movie.entity.Film;
import movie.entity.Inventory;
import movie.entity.Payment;
import movie.entity.Rental;
import movie.entity.Staff;
import movie.entity.Store;
import movie.exception.NotFoundException;
import movie.repository.FilmRepository;
import movie.util.HibernateUtil;
import org.hibernate.Session;

public class FilmService implements BaseService<Integer, Film> {

  private final FilmRepository filmRepository;
  private final RentalService rentalService;
  private final PaymentService paymentService;
  private final CustomerService customerService;
  private final StoreService storeService;
  private final StaffService staffService;
  private final InventoryService inventoryService;

  public FilmService(FilmRepository filmRepository, RentalService rentalService, PaymentService paymentService,
      CustomerService customerService,
      StoreService storeService,
      StaffService staffService, InventoryService inventoryService) {
    this.filmRepository = filmRepository;
    this.rentalService = rentalService;
    this.paymentService = paymentService;
    this.customerService = customerService;
    this.storeService = storeService;
    this.staffService = staffService;
    this.inventoryService = inventoryService;
  }

  @Override
  public Film save(Film entity) {
    return filmRepository.save(entity);
  }

  public Film createNewFilmCopy(Film film, Store store) {
    Film savedFilm = save(film);
    inventoryService.createInventoryForFilm(savedFilm, store);
    return savedFilm;
  }

  public Film findByTitle(String title) {
    return filmRepository.findByTitle(title).orElseThrow(() -> new NotFoundException(Store.class, title));
  }

  @Override
  public Film findById(Integer id) {
    return null;
  }

  @Override
  public List<Film> findAll() {
    return null;
  }

  @Override
  public Film update(Integer id, Film entity) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {

  }

  public Boolean returnFilm(Integer inventoryId) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.getTransaction().begin();
    Inventory inventory = inventoryService.findById(inventoryId);
    Optional<Rental> lastForInventory = rentalService.findLastForInventory(inventory);
    if(lastForInventory.isPresent()) {
      Rental rental = lastForInventory.get();
      if(rental.getReturnDate() == null) {
        rental.setReturnDate(LocalDateTime.now());
        session.getTransaction().commit();
        return true;
      }
    }
    session.getTransaction().rollback();
    return false;
  }

  public Boolean rentFilm(Integer customerId, Integer storeId, Integer staffId, String title) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.getTransaction().begin();
    Customer customer = customerService.findById(customerId);
    Store store = storeService.findById(storeId);
    Staff staff = staffService.findById(staffId);
    Film film = findByTitle(title);
    session.merge(customer);
    session.merge(store);
    session.merge(staff);
    Optional<Rental> freeRental = getFreeRental(store, film);
    if(freeRental.isPresent()) {
      Rental rental = createRentalForInventory(customer, staff, freeRental.get().getInventory());
      createPaymentForFilmRent(customer, film, rental, staff);
    } else {
      Optional<Inventory> inventory = film.getInventories().stream().filter(i -> i.getRentals().isEmpty()).findAny();
      if(inventory.isPresent()) {
        Rental rental = createRentalForInventory(customer, staff, inventory.get());
        createPaymentForFilmRent(customer, film, rental, staff);
      } else {
        session.getTransaction().rollback();
        return false;
      }
    }
    session.getTransaction().commit();
    return true;
  }

  private Optional<Rental> getFreeRental(Store store, Film film) {
    return film.getInventories().stream()
        .filter(i -> i.getStore().equals(store))
        .map(rentalService::findLastForInventory)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .filter(r -> r.getRentalDate() != null)
        .findAny();
  }
  private Boolean checkIfAnyRentalExists(Inventory inventory) {
    return rentalService.findLastForInventory(inventory).isPresent();
  }

  private Rental createRentalForInventory(Customer customer, Staff staff, Inventory inventory) {
    Rental rental = Rental.builder()
        .staff(staff)
        .customer(customer)
        .inventory(inventory)
        .build();
    rentalService.save(rental);
    return rental;
  }

  private void createPaymentForFilmRent(Customer customer, Film film, Rental rental, Staff staff) {
    Payment payment = Payment.builder()
        .staff(staff)
        .amount(film.getRentalRate())
        .customer(customer)
        .rental(rental)
        .build();
    paymentService.save(payment);
  }
}
