package com.miranda.shpd.controller;

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
    public List<Tariff> findAllTariffs() {
        return tariffService.findAllTariffs();
    }

    @GetMapping("/{id}")
    public Tariff findTariffById(@PathVariable Long id) {
        return tariffService.findTariffById(id);
    }
}
