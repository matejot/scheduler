package ironhack.com.scheduler.service;

import ironhack.com.scheduler.model.Site;
import ironhack.com.scheduler.repository.SiteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ironhack.com.scheduler.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ironhack.com.scheduler.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j


public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SiteRepository siteRepository;


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        log.info("Creating new employee {}", employee);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee (int employeeId) {
        log.info("Deleting employee with id {}", employeeId);
        employeeRepository.deleteById(employeeId);
    }

    public Employee updateEmployee(int employeeId, Employee updatedEmployee) {
        log.info("Updating employee with id {}", employeeId);
        Employee employeeToUpdate = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        // Update only the fields present in the request
        if (updatedEmployee.getFullName() != null) {
            employeeToUpdate.setFullName(updatedEmployee.getFullName());
        }
        if (updatedEmployee.getUsername() != null) {
            employeeToUpdate.setUsername(updatedEmployee.getUsername());
        }
        if (updatedEmployee.getShiftStatus() != null) {
            employeeToUpdate.setShiftStatus(updatedEmployee.getShiftStatus());
        }
        employeeToUpdate.setTotalWorkingDays(updatedEmployee.getTotalWorkingDays());
        employeeToUpdate.setTotalWorkingHours(updatedEmployee.getTotalWorkingHours());
        employeeToUpdate.setOvertimeHours(updatedEmployee.getOvertimeHours());

        // Update site field
        if (updatedEmployee.getSite() != null && updatedEmployee.getSite().getSiteId() != 0) {
            Site site = siteRepository.findById(updatedEmployee.getSite().getSiteId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid site ID: " + updatedEmployee.getSite().getSiteId()));
            employeeToUpdate.setSite(site);
        }

        return employeeRepository.save(employeeToUpdate);
    }



}
