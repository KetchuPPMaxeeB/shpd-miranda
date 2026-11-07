package com.miranda.shpd.service;

import com.miranda.shpd.dto.TariffCreateDto;
import com.miranda.shpd.entity.Tariff;
import com.miranda.shpd.repository.TariffRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public Tariff createTariff(TariffCreateDto tariffCreateDto) {
        Tariff tariff = Tariff.builder()
                .name(tariffCreateDto.name())
                .speed(tariffCreateDto.speed())
                .price(tariffCreateDto.price())
                .description(tariffCreateDto.description())
                .build();

        return tariffRepository.save(tariff);
    }

    @Transactional
    public Tariff updateTariff(Long id, TariffCreateDto dto) {
        Tariff tariff = findTariffById(id);
        tariff.setName(dto.name());
        tariff.setSpeed(dto.speed());
        tariff.setPrice(dto.price());
        tariff.setDescription(dto.description());
        return tariffRepository.save(tariff);
    }

    @Transactional
    public void deleteTariffById(Long id) {
        Tariff tariff = findTariffById(id);
        tariffRepository.delete(tariff);
    }
}
