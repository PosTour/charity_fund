package ru.bmstu.charity.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bmstu.charity.repository.ServiceRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public Optional<ru.bmstu.charity.domain.Service> findById(int id) {
        return serviceRepository.findById(id);
    }

    public List<ru.bmstu.charity.domain.Service> findAll() {
        return serviceRepository.findAll();
    }
}
