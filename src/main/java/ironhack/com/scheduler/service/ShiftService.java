package ironhack.com.scheduler.service;

import ironhack.com.scheduler.model.ShiftType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ironhack.com.scheduler.model.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ironhack.com.scheduler.repository.ShiftRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j


public class ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    public List<Shift> findAll() {
        log.info("Get all shifts");
        return shiftRepository.findAll();
    }

    public Shift addShift(Shift shift) {
    log.info("Creating new shift{}", shift);
    return shiftRepository.save(shift);
    }

    public Shift updateShift(int shiftId, Shift shift) {
        log.info("Updating shift with id {}", shiftId);
        var shiftToUpdate = shiftRepository.findById(shiftId).orElseThrow();

        shiftToUpdate.setEmployee(shift.getEmployee());
        shiftToUpdate.setSite(shift.getSite());
        shiftToUpdate.setShiftType(shift.getShiftType());
        shiftToUpdate.setLeaveStatus(shift.getLeaveStatus());
        shiftToUpdate.setStartDate(shift.getStartDate());
        shiftToUpdate.setEndDate(shift.getEndDate());

        return shiftRepository.save(shiftToUpdate);

    }

    public void deleteShift(int shiftId) {
        log.info("Deleting shift with id {}", shiftId);
        shiftRepository.deleteById(shiftId);
    }

    public List<Shift> getShiftsByTypeAndDateRange(ShiftType shiftType, LocalDateTime startDate, LocalDateTime endDate){
        log.info("Listing all {} shifts, between date {} and {}", shiftType, startDate, endDate);
        return shiftRepository.findAllByShiftTypeAndStartDateBetween(shiftType, startDate, endDate);
    }



}
