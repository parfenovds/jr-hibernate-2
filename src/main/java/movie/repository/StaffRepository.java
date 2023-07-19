package movie.repository;

import movie.entity.Staff;

public class StaffRepository extends BaseRepositoryImpl<Integer, Staff> {
  public StaffRepository() {
    super(Staff.class);
  }
}
