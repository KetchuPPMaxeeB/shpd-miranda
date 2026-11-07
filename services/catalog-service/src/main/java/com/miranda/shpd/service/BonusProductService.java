package com.miranda.shpd.service;

import com.miranda.shpd.dto.BonusProductCreateDto;
import com.miranda.shpd.entity.BonusProduct;
import com.miranda.shpd.repository.BonusProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public BonusProduct createBonusProduct(BonusProductCreateDto dto) {
        BonusProduct bonusProduct = new BonusProduct();
        bonusProduct.setName(dto.name());
        bonusProduct.setPointsCost(dto.pointsCost());
        bonusProduct.setDescription(dto.description());
        bonusProduct.setType(dto.type());
        return bonusProductRepository.save(bonusProduct);
    }

    @Transactional
    public BonusProduct updateBonusProduct(Long id, BonusProductCreateDto dto) {
        BonusProduct bonusProduct = findBonusProductById(id);
        bonusProduct.setName(dto.name());
        bonusProduct.setPointsCost(dto.pointsCost());
        bonusProduct.setDescription(dto.description());
        bonusProduct.setType(dto.type());
        return bonusProductRepository.save(bonusProduct);
    }

    @Transactional
    public void deleteBonusProductById(Long id) {
        BonusProduct bonusProduct = findBonusProductById(id);
        bonusProductRepository.delete(bonusProduct);
    }
}
