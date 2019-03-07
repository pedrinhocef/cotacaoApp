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
        usdDomain.setBid(usdEntity.getBid());
        usdDomain.setLow(usdEntity.getLow());
        usdDomain.setHigh(usdEntity.getHigh());

        return usdDomain;
    }

    private static EURDomain transformObjectEntityToDomain(EUR eurEntity) {
        EURDomain eurDomain = new EURDomain();

        eurDomain.setName(eurEntity.getName());
        eurDomain.setBid(eurEntity.getBid());
        eurDomain.setLow(eurEntity.getLow());
        eurDomain.setHigh(eurEntity.getHigh());

        return eurDomain;
    }

    private static BTCDomain transformObjectEntityToDomain(BTC btcEntity) {
        BTCDomain btcDomain = new BTCDomain();

        btcDomain.setName(btcEntity.getName());
        btcDomain.setBid(btcEntity.getBid());
        btcDomain.setLow(btcEntity.getLow());
        btcDomain.setHigh(btcEntity.getHigh());

        return btcDomain;
    }

    private static LTCDomain transformObjectEntityToDomain(LTC ltcEntity) {
        LTCDomain ltcDomain = new LTCDomain();

        ltcDomain.setName(ltcEntity.getName());
        ltcDomain.setBid(ltcEntity.getBid());
        ltcDomain.setLow(ltcEntity.getLow());
        ltcDomain.setHigh(ltcEntity.getHigh());

        return ltcDomain;
    }
}
