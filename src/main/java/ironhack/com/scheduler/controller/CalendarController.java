package ironhack.com.scheduler.controller;

import ironhack.com.scheduler.model.Calendar;
import ironhack.com.scheduler.model.DateUtil;
import ironhack.com.scheduler.service.CalndarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/calendar")
@RequiredArgsConstructor

public class CalendarController {

    private final CalndarService calndarService;

    @GetMapping
    public List<Calendar> getAll(){
        return calndarService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Calendar addCalendarEntry(@RequestBody @Valid Calendar calendar) {
        return calndarService.addCalendarEntry(calendar);
    }

    @PutMapping("/{calendarId}")
    public Calendar updateCalendarEntry(@PathVariable("calendarId") int calendarId,
                                        @RequestBody Calendar calendar){
        return calndarService.updateCalendarEntry(calendarId, calendar);
    }

    @DeleteMapping("/{calendarId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCalendarEntry(@PathVariable("calendarId") int calendarId){
        calndarService.deleteCalendarEntry(calendarId);
    }

    @GetMapping("/range")
    public List<Calendar> getCalendarEntriesBetweenDates(@RequestParam String start,
                                                         @RequestParam String end) {
        LocalDateTime startDate = DateUtil.parseDate(start);
        LocalDateTime endDate = DateUtil.parseDate(end);

        return calndarService.getCalendarEntriesBetweenDates(startDate, endDate);
    }




}
