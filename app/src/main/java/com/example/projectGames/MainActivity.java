package com.example.projectGames;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.projectGames.webServiceClient.WebServiceClient;

public class MainActivity extends AppCompatActivity {

    private WebServiceClient webServiceClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        // Parte de Antonio




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
<<<<<<< Updated upstream
        return true;
=======

        // Parte de pechin

        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                adapter.getFilter().filter(query);
                return true ;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
                return true ;
            }
        });
        return super.onCreateOptionsMenu(menu);

>>>>>>> Stashed changes
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                // Parte de pechin
                return true;
            case R.id.menu_computerGames:
                // Parte de Piter
                return true;
            case R.id.menu_browserGames:
                Intent intent = new Intent(MainActivity.this, GamesOfBrowserActivity.class);
                startActivity(intent);

                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}