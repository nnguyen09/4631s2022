package com.example.catshoppingstoreapplcation.views;

import android.os.Bundle;
import android.widget.Toolbar;

import android.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.catshoppingstoreapplcation.R;

public class Food extends AppCompatActivity {
    private Toolbar toolbar;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

//        getSupportActionBar().hide();
//        toolbar = (Toolbar) findViewById(R.id.action_bar);
//
//
//        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
//    }
}