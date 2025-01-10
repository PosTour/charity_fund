package ru.bmstu.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bmstu.charity.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
