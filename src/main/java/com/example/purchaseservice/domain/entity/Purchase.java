package com.example.purchaseservice.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "purchase")
public class Purchase extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "user_id")
    private String userId; // 구매자

    @Column(nullable = false, name = "product_id")
    private String productId; // 구입한 상품 번호

    @Column(nullable = false)
    private int quantity; // 주문 수량

    @Builder
    public Purchase(String userId, String productId, int quantity){
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

}
