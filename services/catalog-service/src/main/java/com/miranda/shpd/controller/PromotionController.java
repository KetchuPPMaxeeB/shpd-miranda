package com.miranda.shpd.controller;

import com.miranda.shpd.entity.Promotion;
import com.miranda.shpd.service.PromotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public List<Promotion> findAllPromotions() {
        return promotionService.findAllPromotions();
    }

    @GetMapping("/{id}")
    public Promotion findPromotionById(@PathVariable Long id) {
        return promotionService.findPromotionById(id);
    }
}
