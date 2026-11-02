package com.miranda.shpd.dto;

import com.miranda.shpd.entity.Promotion;

public record PromotionDto(
        Long id,
        String title,
        String description,
        String image_url
) {
    public static PromotionDto fromEntity(Promotion promotion) {
        return new PromotionDto(
                promotion.getId(),
                promotion.getTitle(),
                promotion.getDescription(),
                promotion.getImageUrl()
        );
    }
}
