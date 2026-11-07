package com.miranda.shpd.service;

import com.miranda.shpd.dto.CatalogServiceItemCreateDto;
import com.miranda.shpd.entity.CatalogServiceItem;
import com.miranda.shpd.repository.CatalogServiceItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public CatalogServiceItem createCatalogServiceItem(CatalogServiceItemCreateDto dto) {
        CatalogServiceItem catalogServiceItem = new CatalogServiceItem();
        catalogServiceItem.setName(dto.name());
        catalogServiceItem.setDescription(dto.description());
        catalogServiceItem.setPrice(dto.price());
        catalogServiceItem.setAvailable(dto.isAvailable());
        catalogServiceItem.setInstallationUrl(dto.installationUrl());
        return catalogServiceItemRepository.save(catalogServiceItem);
    }

    @Transactional
    public CatalogServiceItem updateCatalogServiceItem(Long id, CatalogServiceItemCreateDto dto) {
        CatalogServiceItem catalogServiceItem = findCatalogServiceItemById(id);
        catalogServiceItem.setName(dto.name());
        catalogServiceItem.setDescription(dto.description());
        catalogServiceItem.setPrice(dto.price());
        catalogServiceItem.setAvailable(dto.isAvailable());
        catalogServiceItem.setInstallationUrl(dto.installationUrl());
        return catalogServiceItemRepository.save(catalogServiceItem);
    }

    @Transactional
    public void deleteCatalogServiceItemById(Long id) {
        CatalogServiceItem catalogServiceItem = findCatalogServiceItemById(id);
        catalogServiceItemRepository.delete(catalogServiceItem);
    }
}
