package com.miranda.shpd.service;

import com.miranda.shpd.entity.BonusProduct;
import com.miranda.shpd.repository.BonusProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonusProductService {

    private final BonusProductRepository bonusProductRepository;

    public BonusProductService(BonusProductRepository bonusProductRepository) {
        this.bonusProductRepository = bonusProductRepository;
    }

    public List<BonusProduct> findAllBonusProducts() {
        return bonusProductRepository.findAll();
    }

    public BonusProduct findBonusProductById(Long id) {
        return bonusProductRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BonusProduct was not found with given id (" + id + ")"));
    }

    public BonusProduct updateBonusProduct(BonusProduct bonusProduct) {
        return bonusProductRepository.save(bonusProduct);
    }

    public void deleteBonusProductById(Long id) {
        bonusProductRepository.deleteById(id);
    }
}
