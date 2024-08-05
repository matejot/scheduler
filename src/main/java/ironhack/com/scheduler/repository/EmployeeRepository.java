package ironhack.com.scheduler.repository;

import ironhack.com.scheduler.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
}
