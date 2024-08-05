package ironhack.com.scheduler.repository;

import ironhack.com.scheduler.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Integer> {

    List<Calendar> findAllByDateBetween(LocalDateTime start, LocalDateTime end);

}
