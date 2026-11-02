package com.miranda.shpd.dto;

import com.miranda.shpd.entity.Tariff;

import java.math.BigDecimal;

public record TariffDto(
        Long id,
        String name,
        Integer speed,
        BigDecimal price,
        String description
) {
    public static TariffDto fromEntity(Tariff tariff) {
        return new TariffDto(
                tariff.getId(),
                tariff.getName(),
                tariff.getSpeed(),
                tariff.getPrice(),
                tariff.getDescription()
        );
    }
}
