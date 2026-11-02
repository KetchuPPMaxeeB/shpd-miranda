package com.miranda.shpd.service;

import com.miranda.shpd.entity.Tariff;
import com.miranda.shpd.repository.TariffRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TariffService {

    private final TariffRepository tariffRepository;

    public TariffService(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    public List<Tariff> findAllTariffs() {
        return tariffRepository.findAll();
    }

    public Tariff findTariffById(Long id) {
        return tariffRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tariff was not found with given id (" + id + ")"));
    }

    public Tariff updateTariff(Tariff tariff) {
        return tariffRepository.save(tariff);
    }

    public void deleteTariffById(Long id) {
        tariffRepository.deleteById(id);
    }
}
