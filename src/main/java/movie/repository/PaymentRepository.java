package movie.repository;

import movie.entity.Payment;

public class PaymentRepository extends BaseRepositoryImpl<Integer, Payment> {
  public PaymentRepository() {
    super(Payment.class);
  }
}
