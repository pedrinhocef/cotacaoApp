package com.pedrosoares.cotacaoapp.model.mapper;

import com.pedrosoares.cotacaoapp.data.entity.CoinsResponse;
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;

public class CoinsMapper {

    public static CoinsDomain transformEntityToDomain(CoinsResponse coinsResponse) {
        CoinsDomain coinsDomain = new CoinsDomain();


        return coinsDomain;
    }
}
