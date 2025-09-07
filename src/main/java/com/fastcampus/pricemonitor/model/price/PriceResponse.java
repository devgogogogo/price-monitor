package com.fastcampus.pricemonitor.model.price;

import com.fastcampus.pricemonitor.model.coinbase.SpotPriceResponse;

public record PriceResponse (Double amount, String base, String currency) {

    public static PriceResponse from(SpotPriceResponse spotPriceResponse) {
        return new PriceResponse(
                Double.parseDouble(spotPriceResponse.data().amount()),
                spotPriceResponse.data().base(),
                spotPriceResponse.data().currency()
        );
    }

}
