package com.miranda.shpd.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record TariffCreateDto(
        @NotBlank(message = "Tariff name should not be blank")
        @Size(max = 50, min = 3, message = "Tariff name should be at least 3 characters and at most 50 characters")
        String name,

        @NotNull(message = "Speed of the tariff should not be blank")
        @Positive
        Integer speed,

        @Digits(integer = 8, fraction = 2)
        @NotNull(message = "Tariff price should not be blank")
        @PositiveOrZero
        BigDecimal price,

        @Size(max = 255, message = "Tariff description should be at most 255 characters")
        String description
) {
}
