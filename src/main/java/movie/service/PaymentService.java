package movie.service;

import java.util.List;
import movie.entity.Payment;
import movie.repository.PaymentRepository;

public class PaymentService implements BaseService<Integer, Payment> {
  private final PaymentRepository paymentRepository;

  public PaymentService(PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
  }

  @Override
  public Payment save(Payment entity) {
    return paymentRepository.save(entity);
  }

  @Override
  public Payment findById(Integer id) {
    return null;
  }

  @Override
  public List<Payment> findAll() {
    return null;
  }

  @Override
  public Payment update(Integer id, Payment entity) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {

  }
}
