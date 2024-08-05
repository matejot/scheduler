package ironhack.com.scheduler.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @Column(nullable = false, unique = true)
    private String username;
    private String fullName;
    @Enumerated(EnumType.STRING)
    private ShiftStatus shiftStatus;
    private int totalWorkingDays;
    private int totalWorkingHours;
    private int overtimeHours;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "site_id")
    private Site site;

    public Employee(String username,
                    String fullName,
                    ShiftStatus shiftStatus,
                    int totalWorkingDays,
                    int totalWorkingHours,
                    int overtimeHours){
        this.username = username;
        this.fullName = fullName;
        this.shiftStatus = shiftStatus;
        this.totalWorkingDays = totalWorkingDays;
        this.totalWorkingHours = totalWorkingHours;
        this.overtimeHours = overtimeHours;

    }

}
