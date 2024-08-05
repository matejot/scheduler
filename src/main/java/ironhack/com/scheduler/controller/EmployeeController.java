package ironhack.com.scheduler.controller;

import ironhack.com.scheduler.model.Site;
import ironhack.com.scheduler.repository.SiteRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ironhack.com.scheduler.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ironhack.com.scheduler.service.EmployeeService;


import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor


public class EmployeeController {
    private final EmployeeService employeeService;
    private final SiteRepository siteRepository;

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody @Valid Employee employee) {
        if(employee.getSite() != null && employee.getSite().getSiteId() != 0) {
            Site site = siteRepository.findById(employee.getSite().getSiteId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid site ID: " + employee.getSite().getSiteId()));
            employee.setSite(site);
        }
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable ("employeeId") int employeeId,
                                   @RequestBody Employee employee) {
        return employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable ("employeeId") int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

}
