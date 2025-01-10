package ru.bmstu.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bmstu.charity.domain.Application;
import ru.bmstu.charity.domain.Client;
import ru.bmstu.charity.domain.Fund;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    List<Application> findAllApplicationByIsApproved(Boolean isApproved);

    List<Application> findAllByClient(Client client);

    List<Application> findAllApplicationByIsApprovedAndClient(Boolean isApproved, Client client);

    List<Application> findAllByFund(Fund fund);
}
