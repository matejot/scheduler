package ironhack.com.scheduler.service;

import ironhack.com.scheduler.model.Calendar;
import ironhack.com.scheduler.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class CalndarService {
    @Autowired
    private CalendarRepository calendarRepository;

    public List<Calendar> getAll() {
        log.info("Getting all calendar entries");
        return calendarRepository.findAll();
    }

    public Calendar addCalendarEntry(Calendar calendar) {
        log.info("Creating new calendar entry {}", calendar);
        return calendarRepository.save(calendar);
    }

    public Calendar updateCalendarEntry(int calendarId, Calendar calendar){
        log.info("Updating calendar with id {}", calendarId);
        var calendarToUpdate = calendarRepository.findById(calendarId).orElseThrow();
        calendarToUpdate.setDate(calendar.getDate());
        calendarToUpdate.setShiftType(calendar.getShiftType());

        return calendarRepository.save(calendarToUpdate);
    }

    public void deleteCalendarEntry(int calendarId) {
        log.info("Deleting calendar entry with id {}", calendarId);
        calendarRepository.deleteById(calendarId);
    }

    public List<Calendar> getCalendarEntriesBetweenDates(LocalDateTime start, LocalDateTime end) {
        log.info("Listing calendar entries between range {} and {}", start, end);
        return calendarRepository.findAllByDateBetween(start, end);
    }


}
