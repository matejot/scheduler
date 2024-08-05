package ironhack.com.scheduler.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "shifts")

public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shiftId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    private ShiftType shiftType;

    @Enumerated(EnumType.STRING)
    private LeaveStatus leaveStatus;

    public Shift(Employee employee,
                 Site site,
                 LocalDateTime startDate,
                 LocalDateTime endDate,
                 ShiftType shiftType,
                 LeaveStatus leaveStatus) {
        this.employee = employee;
        this.site = site;
        this.startDate = startDate;
        this.endDate = endDate;
        this.shiftType = shiftType;
        this.leaveStatus = leaveStatus;
    }


}
