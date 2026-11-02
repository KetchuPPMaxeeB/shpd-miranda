package com.miranda.shpd.service;

import com.miranda.shpd.entity.CatalogServiceItem;
import com.miranda.shpd.repository.CatalogServiceItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceItemService {

    private final CatalogServiceItemRepository catalogServiceItemRepository;

    public CatalogServiceItemService(CatalogServiceItemRepository catalogServiceItemRepository) {
        this.catalogServiceItemRepository = catalogServiceItemRepository;
    }

    public List<CatalogServiceItem> findAllCatalogServiceItems() {
        return catalogServiceItemRepository.findAll();
    }

    public CatalogServiceItem findCatalogServiceItemById(Long id) {
        return catalogServiceItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CatalogServiceItem was not found with given id (" + id + ")"));
    }

    public CatalogServiceItem updateCatalogServiceItem(CatalogServiceItem catalogServiceItem) {
        return catalogServiceItemRepository.save(catalogServiceItem);
    }

    public void deleteCatalogServiceItemById(Long id) {
        catalogServiceItemRepository.deleteById(id);
    }
}
