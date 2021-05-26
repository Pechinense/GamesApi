package com.example.projectGames;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.projectGames.adapter.AdapterGamesOfBrowser;
import com.example.projectGames.webServiceClient.WebServiceClient;

public class MainActivity extends AppCompatActivity {

    private WebServiceClient webServiceClient;
    private AdapterGamesOfBrowser adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Parte de Antonio




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);

        // Parte de pechin

        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return true ;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true ;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:

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