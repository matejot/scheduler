package ironhack.com.scheduler.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data


public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int calendarId;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private ShiftType shiftType;

    public Calendar(int calendarId, LocalDateTime date, ShiftType shiftType) {
        this.calendarId = calendarId;
        this.date = date;
        this.shiftType = shiftType;
    }
}

