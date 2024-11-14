package com.example.simg.Retrofit;

import com.example.simg.Models.DtoLogin;
import com.example.simg.Models.DtoInfoLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitService {
    @POST("logins")
    Call<DtoInfoLogin> login(@Body DtoLogin log);






}
