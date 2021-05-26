package com.example.projectGames.webServiceClient;

import com.example.projectGames.models.ListGames;
import com.example.projectGames.models.ListGamesBrowser;
import com.example.projectGames.models.ListGamesPc;
import com.example.projectGames.models.OneGame;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServiceClient {

    String BASE_URL = "https://www.freetogame.com/api/";

    @GET("games")
    Call<List<ListGames>> getAllGames();

    @GET("games/?platform=pc")
    Call<List<ListGamesPc>> getAllGamesPc();

    @GET("games/?platform=browser")
    Call<List<ListGamesBrowser>> getAllGamesBrowser();

    @GET("game")
    Call<OneGame> getOneGame(@Query("id") int id);




}
