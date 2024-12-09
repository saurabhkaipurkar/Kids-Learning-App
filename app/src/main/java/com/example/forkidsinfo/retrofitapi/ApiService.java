package com.example.forkidsinfo.retrofitapi;

import com.example.forkidsinfo.responses.StoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("customsearch/v1")
    Call<StoryResponse> searchStory(
            @Query("key") String apiKey,
            @Query("cx") String cx,
            @Query("q") String query
    );
}
