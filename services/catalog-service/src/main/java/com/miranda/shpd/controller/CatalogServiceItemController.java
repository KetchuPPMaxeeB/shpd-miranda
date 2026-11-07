package com.miranda.shpd.controller;

import com.miranda.shpd.dto.CatalogServiceItemCreateDto;
import com.miranda.shpd.dto.CatalogServiceItemDto;
import com.miranda.shpd.service.CatalogServiceItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class CatalogServiceItemController {

    private final CatalogServiceItemService catalogServiceItemService;

    public CatalogServiceItemController(CatalogServiceItemService catalogServiceItemService) {
        this.catalogServiceItemService = catalogServiceItemService;
    }

    @GetMapping
    public List<CatalogServiceItemDto> findAllCatalogServiceItems() {
        return catalogServiceItemService.findAllCatalogServiceItems().stream()
                .map(CatalogServiceItemDto::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public CatalogServiceItemDto findCatalogServiceItemById(@PathVariable Long id) {
        return CatalogServiceItemDto.fromEntity(catalogServiceItemService.findCatalogServiceItemById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CatalogServiceItemDto createCatalogServiceItem(@Valid @RequestBody CatalogServiceItemCreateDto dto) {
        return CatalogServiceItemDto.fromEntity(catalogServiceItemService.createCatalogServiceItem(dto));
    }

    @PutMapping("/{id}")
    public CatalogServiceItemDto updateCatalogServiceItem(@PathVariable Long id, @Valid @RequestBody CatalogServiceItemCreateDto dto) {
        return CatalogServiceItemDto.fromEntity(catalogServiceItemService.updateCatalogServiceItem(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCatalogServiceItem(@PathVariable Long id) {
        catalogServiceItemService.deleteCatalogServiceItemById(id);
    }
}
