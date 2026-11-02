package com.miranda.shpd.controller;

import com.miranda.shpd.entity.CatalogServiceItem;
import com.miranda.shpd.service.CatalogServiceItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class CatalogServiceItemController {
    
    private final CatalogServiceItemService catalogServiceItemService;

    public CatalogServiceItemController(CatalogServiceItemService catalogServiceItemService) {
        this.catalogServiceItemService = catalogServiceItemService;
    }

    @GetMapping
    public List<CatalogServiceItem> findAllCatalogServiceItems() {
        return catalogServiceItemService.findAllCatalogServiceItems();
    }

    @GetMapping("/{id}")
    public CatalogServiceItem findCatalogServiceItemById(@PathVariable Long id) {
        return catalogServiceItemService.findCatalogServiceItemById(id);
    }
}
