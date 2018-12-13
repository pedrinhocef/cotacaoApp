package com.pedrosoares.cotacaoapp.data.remote.service;

import com.pedrosoares.cotacaoapp.data.entity.Coins;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("all")
    Observable<Coins> getCoins(@Path("all")String all);

}
