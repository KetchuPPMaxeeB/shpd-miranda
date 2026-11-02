package com.miranda.shpd.controller;

import com.miranda.shpd.dto.TariffDto;
import com.miranda.shpd.entity.Tariff;
import com.miranda.shpd.service.TariffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tariffs")
public class TariffController {

    private final TariffService tariffService;

    public TariffController(TariffService tariffService) {this.tariffService = tariffService;}

    @GetMapping
    public List<TariffDto> findAllTariffs() {
        return tariffService.findAllTariffs().stream()
                .map(TariffDto::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public TariffDto findTariffById(@PathVariable Long id) {
        return TariffDto.fromEntity(tariffService.findTariffById(id));
    }
}
