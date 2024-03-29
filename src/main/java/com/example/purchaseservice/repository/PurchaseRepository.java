package com.example.purchaseservice.repository;

import com.example.purchaseservice.domain.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
}
