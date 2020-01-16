package com.pedrosoares.cotacaoapp.model.mapper

import com.pedrosoares.cotacaoapp.data.entity.ARS
import com.pedrosoares.cotacaoapp.data.entity.BTC
import com.pedrosoares.cotacaoapp.data.entity.CurrencyResponse
import com.pedrosoares.cotacaoapp.data.entity.EUR
import com.pedrosoares.cotacaoapp.data.entity.GBP
import com.pedrosoares.cotacaoapp.data.entity.LTC
import com.pedrosoares.cotacaoapp.data.entity.USD
import com.pedrosoares.cotacaoapp.model.domain.ARSDomain
import com.pedrosoares.cotacaoapp.model.domain.BTCDomain
import com.pedrosoares.cotacaoapp.model.domain.CurrencyDomain
import com.pedrosoares.cotacaoapp.model.domain.EURDomain
import com.pedrosoares.cotacaoapp.model.domain.GBPDomain
import com.pedrosoares.cotacaoapp.model.domain.LTCDomain
import com.pedrosoares.cotacaoapp.model.domain.USDDomain

object CurrencyMapper {

    fun transformEntityToDomain(currencyResponse: CurrencyResponse?): CurrencyDomain {

        val currencyResponseDomain = CurrencyDomain()
        currencyResponse?.let{
            currencyResponseDomain.usd = transformObjectEntityToDomain(it.usd!!)
            currencyResponseDomain.eur = transformObjectEntityToDomain(it.eur!!)
            currencyResponseDomain.btc = transformObjectEntityToDomain(it.btc!!)
            currencyResponseDomain.ltc = transformObjectEntityToDomain(it.ltc!!)
            currencyResponseDomain.gbp = transformObjectEntityToDomain(it.gbp!!)
            currencyResponseDomain.ars = transformObjectEntityToDomain(it.ars!!)
        }
        return currencyResponseDomain
    }

    private fun transformObjectEntityToDomain(usdEntity: USD): USDDomain {
        val usdDomain = USDDomain()
        usdDomain.name = usdEntity.name
        usdDomain.bid = usdEntity.bid
        usdDomain.low = usdEntity.low
        usdDomain.high = usdEntity.high

        return usdDomain
    }

    private fun transformObjectEntityToDomain(eurEntity: EUR): EURDomain {
        val eurDomain = EURDomain()
        eurDomain.name = eurEntity.name
        eurDomain.bid = eurEntity.bid
        eurDomain.low = eurEntity.low
        eurDomain.high = eurEntity.high


        return eurDomain
    }

    private fun transformObjectEntityToDomain(btcEntity: BTC): BTCDomain {
        val btcDomain = BTCDomain()


        btcDomain.name = btcEntity.name
        btcDomain.bid = btcEntity.bid
        btcDomain.low = btcEntity.low
        btcDomain.high = btcEntity.high
        btcDomain.createDate = btcEntity.createDate


        return btcDomain
    }

    private fun transformObjectEntityToDomain(ltcEntity: LTC): LTCDomain {
        val ltcDomain = LTCDomain()

        ltcDomain.name = ltcEntity.name
        ltcDomain.bid = ltcEntity.bid
        ltcDomain.low = ltcEntity.low
        ltcDomain.high = ltcEntity.high

        return ltcDomain

    }

    private fun transformObjectEntityToDomain(gbpEntity: GBP): GBPDomain {
        val gbpDomain = GBPDomain()


        gbpDomain.name = gbpEntity.name
        gbpDomain.bid = gbpEntity.bid
        gbpDomain.low = gbpEntity.low
        gbpDomain.high = gbpEntity.high


        return gbpDomain
    }

    private fun transformObjectEntityToDomain(arsEntity: ARS): ARSDomain {
        val arsDomain = ARSDomain()


        arsDomain.name = arsEntity.name
        arsDomain.bid = arsEntity.bid
        arsDomain.low = arsEntity.low
        arsDomain.high = arsEntity.high


        return arsDomain
    }
}
