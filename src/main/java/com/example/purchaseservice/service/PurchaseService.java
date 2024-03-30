package com.example.purchaseservice.service;

import com.example.purchaseservice.client.StockServiceClient;
import com.example.purchaseservice.domain.PurchaseDto;
import com.example.purchaseservice.domain.StockDto;
import com.example.purchaseservice.domain.entity.Purchase;
import com.example.purchaseservice.repository.PurchaseRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final StockServiceClient stockServiceClient;

    @Transactional
    public String purchasePreOrderProduct(PurchaseDto purchaseDto,Double prob) {

        if(prob<0.2){
            log.error("잔액 부족으로 결제 취소");
            try{
                StockDto increaseStock = stockServiceClient.increaseStock(purchaseDto.getProductId());
                log.info("재고 + 1 : {}",increaseStock);
            }catch (FeignException e){
                log.error(e.getMessage());

            }finally {
                return "fail-2";
            }

        }

        // 주문 완료
        Purchase purchase = Purchase.builder()
                .productId(purchaseDto.getProductId())
                .userId(purchaseDto.getUserId())
                .quantity(1)
                .build();

        purchaseRepository.save(purchase);

        return purchase.getId().toString();

    }
}
