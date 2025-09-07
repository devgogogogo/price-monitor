package com.fastcampus.pricemonitor.model.controller;

import com.fastcampus.pricemonitor.model.coinbase.SpotPriceResponse;
import com.fastcampus.pricemonitor.service.CoinbaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prices")
@RequiredArgsConstructor
public class PriceController {

    private final CoinbaseService coinbaseService;

    @GetMapping("/{currencyPair}/market-price")
    public ResponseEntity<SpotPriceResponse> getMarketPrice(@PathVariable String currencyPair) {
        SpotPriceResponse spotPriceResponse = coinbaseService.getSpotPriceByCurrencyPair(currencyPair);
        return ResponseEntity.ok(spotPriceResponse);
    }

}
