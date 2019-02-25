package com.pedrosoares.cotacaoapp.data.remote.service;

import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {

    @GET("all")
    Observable<CoinsDomain> getAllCoins();

}
