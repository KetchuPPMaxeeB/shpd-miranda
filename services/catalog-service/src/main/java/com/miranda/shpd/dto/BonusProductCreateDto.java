package com.miranda.shpd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record BonusProductCreateDto(
        @NotBlank(message = "Bonus product name should not be blank")
        @Size(max = 50, min = 3, message = "Bonus product name should be at least 3 characters and at most 50 characters")
        String name,

        @PositiveOrZero
        @NotNull
        Integer pointsCost,

        @Size(max = 50, message = "Bonus product description should be at most 50 characters")
        String description,

        @NotBlank(message = "Bonus product type should exist")
        @Size(max = 255, message = "Bonus product type should be at most 255 characters")
        String type
) {
}
