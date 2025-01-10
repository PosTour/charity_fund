package ru.bmstu.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bmstu.charity.domain.Fund;
import ru.bmstu.charity.repository.FundRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FundService {

    private final FundRepository fundRepository;

    public Optional<Fund> findById(int id) {
        return fundRepository.findById(id);
    }
}
