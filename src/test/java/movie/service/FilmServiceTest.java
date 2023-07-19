package movie.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import java.time.Year;
import movie.entity.Film;
import movie.entity.Language;
import movie.entity.Store;
import movie.repository.ActorRepository;
import movie.repository.CategoryRepository;
import movie.repository.CityRepository;
import movie.repository.CustomerRepository;
import movie.repository.FilmRepository;
import movie.repository.InventoryRepository;
import movie.repository.LanguageRepository;
import movie.repository.PaymentRepository;
import movie.repository.RentalRepository;
import movie.repository.StaffRepository;
import movie.repository.StoreRepository;
import movie.util.HibernateUtil;
import org.hibernate.Session;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FilmServiceTest {
  private final CustomerRepository customerRepository = new CustomerRepository();
  private final CustomerService customerService = new CustomerService(customerRepository);
  private final CityRepository cityRepository = new CityRepository();
  private final CityService cityService = new CityService(cityRepository);
  private final StoreRepository storeRepository = new StoreRepository();
  private final StoreService storeService = new StoreService(storeRepository);
  private final FilmRepository filmRepository = new FilmRepository();
  private final RentalRepository rentalRepository = new RentalRepository();
  private final RentalService rentalService = new RentalService(rentalRepository);
  private final PaymentRepository paymentRepository = new PaymentRepository();
  private final PaymentService paymentService = new PaymentService(paymentRepository);
  private final StaffRepository staffRepository = new StaffRepository();
  private final StaffService staffService = new StaffService(staffRepository);
  private final InventoryRepository inventoryRepository = new InventoryRepository();
  private final InventoryService inventoryService = new InventoryService(inventoryRepository);
  private final FilmService filmService = new FilmService(filmRepository, rentalService, paymentService, customerService, storeService, staffService,
      inventoryService
  );
  private final LanguageRepository languageRepository = new LanguageRepository();
  private final LanguageService languageService = new LanguageService(languageRepository);
  private final CategoryRepository categoryRepository = new CategoryRepository();
  private final CategoryService categoryService = new CategoryService(categoryRepository);
  private final ActorRepository actorRepository = new ActorRepository();
  private final ActorService actorService = new ActorService(actorRepository);

  @Test
  void rentFilm() {
    assertTrue(filmService.rentFilm(1, 1, 1, "ACADEMY DINOSAUR"));
  }

  @Test
  void returnFilm() {
    assertTrue(filmService.returnFilm(1));
  }

  @Test
  void createNewFilmCopy() {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.getTransaction().begin();
    Store store = storeService.findById(1);
    Film film = Film.builder()
        .originalLanguage(languageService.findById(1))
        .description("description")
        .language(languageService.findById(1))
        .rating("PG-13")
        .year(Year.of(1999))
        .replacementCost(15.5)
        .rentalDuration(1)
        .rentalRate(5.1)
        .title("FooBar")
        .build();
    film.getCategories().add(categoryService.findById(1));
    film.getActors().add(actorService.findById(1));
    filmService.createNewFilmCopy(film, store);
    session.getTransaction().commit();
  }
}
