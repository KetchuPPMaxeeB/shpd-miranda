package com.miranda.shpd.service;

import com.miranda.shpd.entity.Promotion;
import com.miranda.shpd.repository.PromotionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {

    private final PromotionRepository promotionRepository;

    public PromotionService(PromotionRepository promotionRepository) {this.promotionRepository = promotionRepository;}

    public List<Promotion> findAllPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion findPromotionById(Long id) {
        return promotionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Promotion was not found with given id (" + id + ")"));
    }

    public Promotion updatePromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    public void deletePromotionById(Long id) {
        promotionRepository.deleteById(id);
    }
}
