package com.miranda.shpd.dto;

import com.miranda.shpd.entity.BonusProduct;

public record BonusProductDto(
        Long id,
        String name,
        Integer points_cost,
        String description,
        String type
) {
    public static BonusProductDto fromEntity(BonusProduct bonusProduct) {
        return new BonusProductDto(
                bonusProduct.getId(),
                bonusProduct.getName(),
                bonusProduct.getPointsCost(),
                bonusProduct.getDescription(),
                bonusProduct.getType()
        );
    }
}
