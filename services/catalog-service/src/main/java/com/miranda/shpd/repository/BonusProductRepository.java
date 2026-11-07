package com.miranda.shpd.repository;

import com.miranda.shpd.entity.BonusProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusProductRepository extends JpaRepository<BonusProduct, Long> {
}
