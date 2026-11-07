package com.miranda.shpd.controller;

import com.miranda.shpd.dto.BonusProductCreateDto;
import com.miranda.shpd.dto.BonusProductDto;
import com.miranda.shpd.service.BonusProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bonuses")
public class BonusProductController {

    private final BonusProductService bonusProductService;

    public BonusProductController(BonusProductService bonusProductService) {
        this.bonusProductService = bonusProductService;
    }

    @GetMapping
    public List<BonusProductDto> findAllBonusProducts() {
        return bonusProductService.findAllBonusProducts().stream()
                .map(BonusProductDto::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public BonusProductDto findBonusProductById(@PathVariable Long id) {
        return BonusProductDto.fromEntity(bonusProductService.findBonusProductById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BonusProductDto createBonusProduct(@Valid @RequestBody BonusProductCreateDto dto) {
        return BonusProductDto.fromEntity(bonusProductService.createBonusProduct(dto));
    }

    @PutMapping("/{id}")
    public BonusProductDto updateBonusProduct(@PathVariable Long id, @Valid @RequestBody BonusProductCreateDto dto) {
        return BonusProductDto.fromEntity(bonusProductService.updateBonusProduct(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBonusProduct(@PathVariable Long id) {
        bonusProductService.deleteBonusProductById(id);
    }
}
