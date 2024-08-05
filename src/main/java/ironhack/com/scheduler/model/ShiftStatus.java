package ironhack.com.scheduler.model;

public enum ShiftStatus {
    AVAILABLE,
    ON, // Assigned shift
    OFF, // On 4-day off
    SICK_LEAVE,
    VACATION,
    BUSINESS_DAYS,
}
