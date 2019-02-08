package com.pedrosoares.cotacaoapp.data.remote.service;

import com.pedrosoares.cotacaoapp.data.entity.CoinsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {

    @GET("all")
    Observable<CoinsResponse> getCoins();

}
