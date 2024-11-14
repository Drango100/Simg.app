package com.example.simg.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAdapte {

    private static RetrofitService _serv;

    private static String Base_url = "http://10.0.2.2:4000/";

    public static RetrofitService getService(){
        if(_serv == null){
            //crea una nueva instacia de retrofit con el servicio
            Retrofit retro = new Retrofit.Builder()
                    .baseUrl(Base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            _serv = retro.create(RetrofitService.class);
            return _serv;
        }
        //el servicio ya esta instaciado
        return _serv;
    }


}
