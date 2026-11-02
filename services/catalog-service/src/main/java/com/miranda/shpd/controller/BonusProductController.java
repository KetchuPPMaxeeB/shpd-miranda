package com.miranda.shpd.controller;

import com.miranda.shpd.entity.BonusProduct;
import com.miranda.shpd.service.BonusProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bonuses")
public class BonusProductController {

    private final BonusProductService bonusProductService;

    public BonusProductController(BonusProductService bonusProductService) {
        this.bonusProductService = bonusProductService;
    }

    @GetMapping
    public List<BonusProduct> findAllBonusProducts() {
        return bonusProductService.findAllBonusProducts();
    }

    @GetMapping("/{id}")
    public BonusProduct findBonusProductById(@PathVariable Long id) {
        return bonusProductService.findBonusProductById(id);
    }
}
