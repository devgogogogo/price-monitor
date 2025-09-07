package com.fastcampus.pricemonitor.service;

import com.fastcampus.pricemonitor.model.coinbase.SpotPriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class CoinbaseService {

    private static final RestClient restClient = RestClient.create();

    //코인베이스에서 비트코인을 달러로 조회하는 메서드
    public SpotPriceResponse getSpotPriceByCurrencyPair(String currencyPair) {
        SpotPriceResponse body = restClient
                .get()
                .uri("https://api.coinbase.com/v2/prices/{currencyPair}/spot", currencyPair)
                .retrieve()
                .body(SpotPriceResponse.class);
        return body;
    }
}
