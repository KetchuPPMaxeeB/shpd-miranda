package com.miranda.shpd.controller;

import com.miranda.shpd.dto.PromotionCreateDto;
import com.miranda.shpd.dto.PromotionDto;
import com.miranda.shpd.service.PromotionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public List<PromotionDto> findAllPromotions() {
        return promotionService.findAllPromotions().stream()
                .map(PromotionDto::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public PromotionDto findPromotionById(@PathVariable Long id) {
        return PromotionDto.fromEntity(promotionService.findPromotionById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PromotionDto createPromotion(@Valid @RequestBody PromotionCreateDto dto) {
        return PromotionDto.fromEntity(promotionService.createPromotion(dto));
    }

    @PutMapping("/{id}")
    public PromotionDto updatePromotion(@PathVariable Long id, @Valid @RequestBody PromotionCreateDto dto) {
        return PromotionDto.fromEntity(promotionService.updatePromotion(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePromotion(@PathVariable Long id) {
        promotionService.deletePromotionById(id);
    }
}
