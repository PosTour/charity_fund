package ru.bmstu.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bmstu.charity.domain.Fund;

@Repository
public interface FundRepository extends JpaRepository<Fund, Integer> {
}
