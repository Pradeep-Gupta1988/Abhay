package com.poc.firbaseretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIs {

    @POST(URLs.ADD_USER)
    Call<User> addUser(@Path("new") String s1, @Body User loginRequest);

    @GET(URLs.GET_USERS)
    Call<DynamicUser> getData();

}
