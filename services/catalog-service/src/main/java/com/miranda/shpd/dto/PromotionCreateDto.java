package com.miranda.shpd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PromotionCreateDto(
        @NotBlank(message = "Promotion title should not be blank")
        @Size(max = 50, min = 3, message = "Promotion title should be at least 3 characters and at most 50 characters")
        String title,

        @Size(max = 50, min = 3, message = "Promotion description should be between 3 and 50 characters")
        String description,

        @Size(max = 255, message = "Image URL should be at most 255 characters")
        String imageUrl
) {
}
