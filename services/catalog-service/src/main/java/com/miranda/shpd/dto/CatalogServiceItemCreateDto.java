package com.miranda.shpd.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CatalogServiceItemCreateDto(
        @NotBlank(message = "Catalog item name should not be blank")
        @Size(max = 50, min = 3, message = "Catalog item name should be at least 3 characters and at most 50 characters")
        String name,

        @Size(max = 255, message = "Catalog item description should be at most 255 characters")
        String description,

        @PositiveOrZero
        @Digits(integer = 8, fraction = 2)
        @NotNull
        BigDecimal price,

        @NotNull(message = "Catalog item availability must be specified")
        Boolean isAvailable,

        @Size(max = 255, message = "Installation URL should be at most 255 characters")
        String installationUrl
) {
}
