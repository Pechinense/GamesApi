package com.example.projectGames;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectGames.models.OneGame;
import com.example.projectGames.webServiceClient.WebServiceClient;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailGamesActivity extends AppCompatActivity {

    WebServiceClient webServiceClient;
    private ImageView imgDetail;
    private TextView tvDetailTitle;
    private TextView tvDetailDeveloper;
    private TextView tvShortDescription;
    private TextView tvDescription;
    private int id;
    private OneGame oneGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_games_of_browser);

        setUpView();
        initRetrofit();
        throwPetition();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("id")) {
             id = bundle.getInt("id");

             Log.i("tag", String.valueOf(id));
        }
    }



    public void setUpView() {
        imgDetail = findViewById(R.id.imgdetail);
        tvDetailTitle = findViewById(R.id.tvDetailTitle);
        tvDetailDeveloper = findViewById(R.id.tvDetailDeveloper);
        tvShortDescription = findViewById(R.id.tvShortDescription);
        tvDescription = findViewById(R.id.tvDescription);
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
        Call<OneGame> petition = webServiceClient.getOneGame(id);
        petition.enqueue(new Callback<OneGame>() {
            @Override
            public void onResponse(Call<OneGame> call, Response<OneGame> response) {
                Log.i("tag", response.code()+ "");

                if (response.isSuccessful()) {
                    int code = response.code();

                    oneGame = response.body();
                    Log.i("tag", response.body().toString());

                    setData();

                }
            }

            @Override
            public void onFailure(Call<OneGame> call, Throwable t) {
                Log.d("RETROFIT", "Error: " + t.getMessage());

            }
        });

    }

    private void showErrorMessage() {
        Toast.makeText(this, "Ha ocurrido un error desconocido. Por favor, vuelve a intentarlo más tarde.", Toast.LENGTH_SHORT).show();
    }

    private void setData() {
        tvDetailTitle.setText(oneGame.getTitle());

    }


}