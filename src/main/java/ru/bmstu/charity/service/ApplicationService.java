package ru.bmstu.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bmstu.charity.domain.Application;
import ru.bmstu.charity.repository.ApplicationRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ClientService clientService;
    private final FundService fundService;

    @Transactional
    public void save(Application application) {
        var client = clientService.findCurrentClient().get();
        application.setClient(client);
        application.setCreatedAt(new Date());

        applicationRepository.save(application);
    }

    @Transactional
    public void approve(int id) {
        setApprovalStatus(id, true);
    }

    @Transactional
    public void disapprove(int id) {
        setApprovalStatus(id, false);
    }

    public Optional<Application> findById(int id) {
        return applicationRepository.findById(id);
    }

    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    public List<Application> findApproved() {
        return applicationRepository.findAllApplicationByIsApproved(true);
    }

    public List<Application> findDisapproved() {
        return applicationRepository.findAllApplicationByIsApproved(false);
    }

    public List<Application> findPending() {
        return applicationRepository.findAllApplicationByIsApproved(null);
    }

    public List<Application> findAllForCurrentClient() {
        var clientOpt = clientService.findCurrentClient();

        if (clientOpt.isPresent()) {
            return applicationRepository.findAllByClient(clientOpt.get());
        }
        return Collections.emptyList();
    }

    public List<Application> findAllByClientId(int id) {
        var clientOpt = clientService.findById(id);
        if (clientOpt.isPresent()) {
            return applicationRepository.findAllByClient(clientOpt.get());
        }
        return Collections.emptyList();
    }

    public List<Application> findApprovedByClientId(int id) {
        return findByClientIdAndApprovalStatus(id, true);
    }

    public List<Application> findDisapprovedByClientId(int id) {
        return findByClientIdAndApprovalStatus(id, false);
    }

    public List<Application> findPendingByClientId(int id) {
        return findByClientIdAndApprovalStatus(id, null);
    }

    public List<Application> findAllByFundId(int id) {
        var fundOpt = fundService.findById(id);
        if (fundOpt.isPresent()) {
            return applicationRepository.findAllByFund(fundOpt.get());
        }
        return Collections.emptyList();
    }

    private void setApprovalStatus(int id, Boolean isApproved) {
        var applicationOpt = applicationRepository.findById(id);
        if (applicationOpt.isPresent()) {
            var application = applicationOpt.get();
            application.setIsApproved(isApproved);
            applicationRepository.save(application);
        }
    }

    private List<Application> findByClientIdAndApprovalStatus(int id, Boolean isApproved) {
        var clientOpt = clientService.findById(id);
        if (clientOpt.isPresent()) {
            return applicationRepository.findAllApplicationByIsApprovedAndClient(isApproved, clientOpt.get());
        }
        return Collections.emptyList();
    }
}