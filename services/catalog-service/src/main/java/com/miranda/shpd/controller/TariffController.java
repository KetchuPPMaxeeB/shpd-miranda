package com.miranda.shpd.controller;

import com.miranda.shpd.dto.TariffCreateDto;
import com.miranda.shpd.dto.TariffDto;
import com.miranda.shpd.service.TariffService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TariffDto createTariff(@Valid @RequestBody TariffCreateDto tariffCreateDto) {
        return TariffDto.fromEntity(tariffService.createTariff(tariffCreateDto));
    }

    @PutMapping("/{id}")
    public TariffDto updateTariff(@PathVariable Long id, @Valid @RequestBody TariffCreateDto tariffCreateDto) {
        return TariffDto.fromEntity(tariffService.updateTariff(id, tariffCreateDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTariff(@PathVariable Long id) {
        tariffService.deleteTariffById(id);
    }
}
