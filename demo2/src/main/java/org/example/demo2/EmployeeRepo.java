package org.example.demo2;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface EmployeeRepo extends MongoRepository<Employee, String> {
}
