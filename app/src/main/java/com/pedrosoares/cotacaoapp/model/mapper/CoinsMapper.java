package com.pedrosoares.cotacaoapp.model.mapper;

import com.pedrosoares.cotacaoapp.data.entity.CoinsResponse;
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;
import com.pedrosoares.cotacaoapp.model.domain.USD;

public class CoinsMapper {

    public static CoinsDomain transformEntityToDomain(CoinsResponse coinsResponse) {

        CoinsDomain coinsResponseDomain = new CoinsDomain();
        if (coinsResponse != null){
           //coinsResponseDomain.setUSD(transformObjectEntityToDomain(coinsResponse.getUSD()));
        }


        return coinsResponseDomain;
    }

    private static USD transformObjectEntityToDomain(USD usd) {

        return null;
    }
}
