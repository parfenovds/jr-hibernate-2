package movie.util;

import lombok.SneakyThrows;
import movie.entity.Actor;
import movie.entity.Address;
import movie.entity.Category;
import movie.entity.City;
import movie.entity.Country;
import movie.entity.Customer;
import movie.entity.Film;
import movie.entity.FilmText;
import movie.entity.Inventory;
import movie.entity.Language;
import movie.entity.Payment;
import movie.entity.Person;
import movie.entity.Rental;
import movie.entity.Staff;
import movie.entity.Store;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public enum HibernateUtil {
  INSTANCE;
  private static final SessionFactory sessionFactory = buildSessionFactory();

  @SneakyThrows
  private static SessionFactory buildSessionFactory() {
    return new Configuration()
        .addAnnotatedClass(Actor.class)
        .addAnnotatedClass(Address.class)
        .addAnnotatedClass(Category.class)
        .addAnnotatedClass(City.class)
        .addAnnotatedClass(Country.class)
        .addAnnotatedClass(Customer.class)
        .addAnnotatedClass(Film.class)
        .addAnnotatedClass(FilmText.class)
        .addAnnotatedClass(Inventory.class)
        .addAnnotatedClass(Language.class)
        .addAnnotatedClass(Payment.class)
        .addAnnotatedClass(Person.class)
        .addAnnotatedClass(Rental.class)
        .addAnnotatedClass(Staff.class)
        .addAnnotatedClass(Store.class)
        .buildSessionFactory();
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
