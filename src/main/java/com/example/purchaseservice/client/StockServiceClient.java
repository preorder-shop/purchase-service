package com.example.purchaseservice.client;

import com.example.purchaseservice.domain.StockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stockService")
public interface StockServiceClient {


    @GetMapping("/internal/stocks/decrease/{productId}")
    StockDto decreaseStock(@PathVariable("productId") String productId);

    @GetMapping("/internal/stocks/increase/{productId}")
    StockDto increaseStock(@PathVariable("productId") String productId);
}
