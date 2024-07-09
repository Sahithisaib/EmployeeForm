package org.example.demo2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest
class EmployeeRepoTests {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Test
    void testSaveAndFindEmployee() {
        Employee employee = new Employee("John", "Doe", "john.doe@example.com", "1234567890", "Male", "Engineering");
        employeeRepo.save(employee);

        Employee foundEmployee = employeeRepo.findById(employee.getId()).orElse(null);

        assertThat(foundEmployee).isNotNull();
        assertThat(foundEmployee.getFirstName()).isEqualTo("John");
        assertThat(foundEmployee.getLastName()).isEqualTo("Doe");
        assertThat(foundEmployee.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(foundEmployee.getPhone()).isEqualTo("1234567890");
        assertThat(foundEmployee.getGender()).isEqualTo("Male");
        assertThat(foundEmployee.getDepartment()).isEqualTo("Engineering");
    }
}
