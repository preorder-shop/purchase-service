package com.example.purchaseservice.controller;


import com.example.purchaseservice.domain.PurchaseDto;
import com.example.purchaseservice.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/internal/purchase")
public class InternalController {

    private final PurchaseService purchaseService;

    @PostMapping("")
    public String purchasePreOrderProduct(@RequestBody PurchaseDto purchaseDto) {
        log.info("PurchaseService > InternalController > purchasePreOrderProduct ");

        double prob = Math.random();
        log.info("prob : {}",prob);
        String result = purchaseService.purchasePreOrderProduct(purchaseDto,prob);

        return result;
    }
}
