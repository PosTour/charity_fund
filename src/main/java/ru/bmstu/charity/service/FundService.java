package ru.bmstu.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bmstu.charity.domain.Fund;
import ru.bmstu.charity.repository.FundRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FundService {

    private final FundRepository fundRepository;

    public Optional<Fund> findById(int id) {
        return fundRepository.findById(id);
    }

    public List<Fund> findAll() {
        return fundRepository.findAll();
    }

    @Transactional
    public void save(Fund fund) {
        fundRepository.save(fund);
    }
}
