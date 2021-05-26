package com.example.projectGames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.projectGames.Utils.CustomItemClick;
import com.example.projectGames.adapter.AdapterGamesOfBrowser;
import com.example.projectGames.models.ListGamesBrowser;
import com.example.projectGames.webServiceClient.WebServiceClient;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GamesOfBrowserActivity extends AppCompatActivity {

    private RecyclerView rvBrowserGames;
    private AdapterGamesOfBrowser adapterGamesOfBrowser;
    private WebServiceClient webServiceClient;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private List<ListGamesBrowser> gamesBrowsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_of_browser);

        rvBrowserGames = findViewById(R.id.rvBrowserGames);

        setupView();
        initRetrofit();
        throwPetition();


    }

    private void setupView() {
        rvBrowserGames = findViewById(R.id.rvBrowserGames);

        adapterGamesOfBrowser = new AdapterGamesOfBrowser(this, new CustomItemClick() {
            @Override
            public void onItemClick(int position) {

                int id = gamesBrowsers.get(position).getId();

                Intent intent = new Intent(GamesOfBrowserActivity.this, DetailGamesActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);


            }
        });


        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvBrowserGames.setLayoutManager(staggeredGridLayoutManager);
        rvBrowserGames.setAdapter(adapterGamesOfBrowser);

    }

    private void initRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WebServiceClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        webServiceClient = retrofit.create(WebServiceClient.class);
    }

    private void throwPetition() {
        Call<List<ListGamesBrowser>> petition = webServiceClient.getAllGamesBrowser();
        petition.enqueue(new Callback<List<ListGamesBrowser>>() {
            @Override
            public void onResponse(@NotNull Call<List<ListGamesBrowser>> call, @NotNull Response<List<ListGamesBrowser>> response) {

                if (response.isSuccessful()) {
                    int code = response.code();

                    gamesBrowsers = response.body();
                    adapterGamesOfBrowser.setList(gamesBrowsers);
                } else {
                    int code = response.code();
                    showErrorMessage();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<ListGamesBrowser>> call, @NotNull Throwable t) {

                Log.d("RETROFIT", "Error: " + t.getMessage());
            }
        });
    }

    private void showErrorMessage() {
        Toast.makeText(this, "Ha ocurrido un error desconocido. Por favor, vuelve a intentarlo más tarde.", Toast.LENGTH_SHORT).show();
    }








}