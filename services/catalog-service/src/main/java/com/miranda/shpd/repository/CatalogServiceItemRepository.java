package com.miranda.shpd.repository;

import com.miranda.shpd.entity.CatalogServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogServiceItemRepository extends JpaRepository<CatalogServiceItem, Long> {
}
