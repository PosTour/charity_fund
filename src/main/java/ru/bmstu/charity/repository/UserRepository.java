package ru.bmstu.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bmstu.charity.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
