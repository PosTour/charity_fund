package ru.bmstu.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bmstu.charity.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
