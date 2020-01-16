package com.pedrosoares.cotacaoapp.model.mapper

import com.pedrosoares.cotacaoapp.data.entity.*
import com.pedrosoares.cotacaoapp.model.domain.*

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
            currencyResponseDomain.xrp = transformObjectEntityToDomain(it.xrp!!)
            currencyResponseDomain.eth = transformObjectEntityToDomain(it.eth!!)
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

    private fun transformObjectEntityToDomain(ethEntity: ETH): ETHDomain {
        val ethDomain = ETHDomain()

        ethDomain.name = ethEntity.name
        ethDomain.bid = ethEntity.bid
        ethDomain.low = ethEntity.low
        ethDomain.high = ethEntity.high

        return ethDomain

    }

    private fun transformObjectEntityToDomain(xrpEntity: XRP): XRPDomain {
        val xrpDomain = XRPDomain()

        xrpDomain.name = xrpEntity.name
        xrpDomain.bid = xrpEntity.bid
        xrpDomain.low = xrpEntity.low
        xrpDomain.high = xrpEntity.high

        return xrpDomain

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
