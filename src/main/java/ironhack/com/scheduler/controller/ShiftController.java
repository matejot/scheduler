package ironhack.com.scheduler.controller;

import ironhack.com.scheduler.model.DateUtil;
import ironhack.com.scheduler.model.ShiftType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ironhack.com.scheduler.model.Shift;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ironhack.com.scheduler.service.ShiftService;

import java.time.LocalDateTime;
import java.util.List;


@RequestMapping("/shifts")
@RestController
@RequiredArgsConstructor


public class ShiftController {

    private  final ShiftService shiftService;

    @GetMapping
    public List<Shift> findAll() {
        return shiftService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Shift addShift(@RequestBody @Valid Shift shift) {
        return shiftService.addShift(shift);
    }

    @PutMapping("/{shiftId}")
    public Shift updateShift(@PathVariable ("shiftId") int shiftId,
                             @RequestBody Shift shift) {
        return shiftService.updateShift(shiftId, shift);
    }

    @DeleteMapping("/{shiftId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShift(@PathVariable ("shiftId") int shiftId){
        shiftService.deleteShift(shiftId);
    }

    @GetMapping("/findByTypeAndDateRange")
    public List<Shift> getShiftsByTypeAndDateRange(@RequestParam ShiftType shiftType,
                                                             @RequestParam String start,
                                                             @RequestParam String end) {
        LocalDateTime startDate = DateUtil.parseDate(start);
        LocalDateTime endDate = DateUtil.parseDate(end);

        return shiftService.getShiftsByTypeAndDateRange(shiftType, startDate, endDate);
    }

}
