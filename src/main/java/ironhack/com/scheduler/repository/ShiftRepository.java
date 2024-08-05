package ironhack.com.scheduler.repository;

import ironhack.com.scheduler.model.Shift;
import ironhack.com.scheduler.model.ShiftType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ShiftRepository extends JpaRepository <Shift, Integer> {

    List<Shift> findAllByShiftTypeAndStartDateBetween(ShiftType shiftType, LocalDateTime startDate, LocalDateTime endDate);
}
