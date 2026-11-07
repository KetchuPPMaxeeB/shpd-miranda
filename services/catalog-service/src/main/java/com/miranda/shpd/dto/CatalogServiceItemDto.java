package com.miranda.shpd.dto;

import com.miranda.shpd.entity.CatalogServiceItem;

import java.math.BigDecimal;

public record CatalogServiceItemDto(
        Long id,
        String name,
        String description,
        BigDecimal price,
        boolean isAvailable,
        String installationUrl
) {
    public static CatalogServiceItemDto fromEntity(CatalogServiceItem catalogServiceItem) {
        return new CatalogServiceItemDto(
                catalogServiceItem.getId(),
                catalogServiceItem.getName(),
                catalogServiceItem.getDescription(),
                catalogServiceItem.getPrice(),
                catalogServiceItem.isAvailable(),
                catalogServiceItem.getInstallationUrl()
        );
    }
}
