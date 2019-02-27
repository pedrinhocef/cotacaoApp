package com.pedrosoares.cotacaoapp.model.mapper;

import com.pedrosoares.cotacaoapp.data.entity.BTC;
import com.pedrosoares.cotacaoapp.data.entity.CoinsResponse;
import com.pedrosoares.cotacaoapp.data.entity.EUR;
import com.pedrosoares.cotacaoapp.data.entity.LTC;
import com.pedrosoares.cotacaoapp.data.entity.USD;
import com.pedrosoares.cotacaoapp.model.domain.BTCDomain;
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;
import com.pedrosoares.cotacaoapp.model.domain.EURDomain;
import com.pedrosoares.cotacaoapp.model.domain.LTCDomain;
import com.pedrosoares.cotacaoapp.model.domain.USDDomain;

public class CoinsMapper {

    public static CoinsDomain transformEntityToDomain(CoinsResponse coinsResponse) {

        CoinsDomain coinsResponseDomain = new CoinsDomain();
        if (coinsResponse != null){
           coinsResponseDomain.setUSD(transformObjectEntityToDomain(coinsResponse.getUSD()));
           coinsResponseDomain.setEUR(transformObjectEntityToDomain(coinsResponse.getEUR()));
           coinsResponseDomain.setBTC(transformObjectEntityToDomain(coinsResponse.getBTC()));
           coinsResponseDomain.setLTC(transformObjectEntityToDomain(coinsResponse.getLTC()));
        }


        return coinsResponseDomain;
    }

    private static USDDomain transformObjectEntityToDomain(USD usdEntity) {
        USDDomain usdDomain = new USDDomain();

        usdDomain.setName(usdEntity.getName());
        usdDomain.setAsk(usdEntity.getAsk());
        usdDomain.setBid(usdEntity.getBid());

        return usdDomain;
    }

    private static EURDomain transformObjectEntityToDomain(EUR eurEntity) {
        EURDomain eurDomain = new EURDomain();

        eurDomain.setName(eurEntity.getName());
        eurDomain.setAsk(eurEntity.getAsk());
        eurDomain.setBid(eurEntity.getBid());

        return eurDomain;
    }

    private static BTCDomain transformObjectEntityToDomain(BTC btcEntity) {
        BTCDomain btcDomain = new BTCDomain();

        btcDomain.setName(btcEntity.getName());
        btcDomain.setAsk(btcEntity.getAsk());
        btcDomain.setBid(btcEntity.getBid());

        return btcDomain;
    }

    private static LTCDomain transformObjectEntityToDomain(LTC ltcEntity) {
        LTCDomain ltcDomain = new LTCDomain();

        ltcDomain.setName(ltcEntity.getName());
        ltcDomain.setAsk(ltcEntity.getAsk());
        ltcDomain.setBid(ltcEntity.getBid());

        return ltcDomain;
    }
}
