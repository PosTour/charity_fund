package ru.bmstu.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bmstu.charity.domain.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
