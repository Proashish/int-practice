package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
public class EmployeeController {

    @RestController
    @RequestMapping("/api/employees")
    public class EmployeeController {

        @Autowired
        private EmployeeService employeeService;

        // Create Employee
        @PostMapping
        public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
            Employee savedEmployee = employeeService.saveEmployee(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        }

        // Get All Employees
        @GetMapping
        public ResponseEntity<List<Employee>> getAllEmployees() {
            return ResponseEntity.ok(employeeService.getAllEmployees());
        }
        System.out.println("Hello");

        // Get Employee By Id
        @GetMapping("/{id}")
        public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
            Employee employee = employeeService.getEmployeeById(id);
            return ResponseEntity.ok(employee);
        }

        // Update Employee
        @PutMapping("/{id}")
        public ResponseEntity<Employee> updateEmployee(
                @PathVariable Long id,
                @RequestBody Employee employee) {

            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            return ResponseEntity.ok(updatedEmployee);
        }

        // Delete Employee
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {

            employeeService.deleteEmployee(id);
            return ResponseEntity.ok("Employee deleted successfully.");
        }
    }
}
