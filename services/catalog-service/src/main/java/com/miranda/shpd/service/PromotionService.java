package com.miranda.shpd.service;

import com.miranda.shpd.dto.PromotionCreateDto;
import com.miranda.shpd.entity.Promotion;
import com.miranda.shpd.repository.PromotionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PromotionService {

    private final PromotionRepository promotionRepository;

    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public List<Promotion> findAllPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion findPromotionById(Long id) {
        return promotionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Promotion was not found with given id (" + id + ")"));
    }

    @Transactional
    public Promotion createPromotion(PromotionCreateDto dto) {
        Promotion promotion = new Promotion();
        promotion.setTitle(dto.title());
        promotion.setDescription(dto.description());
        promotion.setImageUrl(dto.imageUrl());
        return promotionRepository.save(promotion);
    }

    @Transactional
    public Promotion updatePromotion(Long id, PromotionCreateDto dto) {
        Promotion promotion = findPromotionById(id);
        promotion.setTitle(dto.title());
        promotion.setDescription(dto.description());
        promotion.setImageUrl(dto.imageUrl());
        return promotionRepository.save(promotion);
    }

    @Transactional
    public void deletePromotionById(Long id) {
        Promotion promotion = findPromotionById(id);
        promotionRepository.delete(promotion);
    }
}
