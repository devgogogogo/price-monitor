package com.fastcampus.pricemonitor.controller;

import com.fastcampus.pricemonitor.model.coinbase.SpotPriceResponse;
import com.fastcampus.pricemonitor.model.price.PriceResponse;
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
    public ResponseEntity<PriceResponse> getMarketPrice(@PathVariable String currencyPair) {
        SpotPriceResponse spotPriceResponse = coinbaseService.getSpotPriceByCurrencyPair(currencyPair);
        PriceResponse priceResponse = PriceResponse.from(spotPriceResponse);
        return ResponseEntity.ok(priceResponse);
    }

}
