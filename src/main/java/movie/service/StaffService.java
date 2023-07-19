package movie.service;

import java.util.List;
import movie.entity.Staff;
import movie.exception.NotFoundException;
import movie.repository.StaffRepository;

public class StaffService implements BaseService<Integer, Staff> {
  private final StaffRepository staffRepository;

  public StaffService(StaffRepository staffRepository) {
    this.staffRepository = staffRepository;
  }

  @Override
  public Staff save(Staff entity) {
    return null;
  }

  @Override
  public Staff findById(Integer id) {
    Staff staff = staffRepository.findById(id).orElseThrow(() -> new NotFoundException(Staff.class, id));
    return staff;
  }

  @Override
  public List<Staff> findAll() {
    return null;
  }

  @Override
  public Staff update(Integer id, Staff entity) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {

  }
}
