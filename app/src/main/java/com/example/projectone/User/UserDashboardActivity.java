package com.example.projectone.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.projectone.HelperClasses.FeaturedAdpater;
import com.example.projectone.HelperClasses.FeaturedHelperClass;
import com.example.projectone.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboardActivity extends AppCompatActivity  {

    RecyclerView featuredRecycler, mostViewedRecycler;
    RecyclerView.Adapter adapter;
    ImageView menuIcon;

    //Drawer Menu
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_ProjectOne);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.mostViewed_Recyler);
        menuIcon = findViewById(R.id.menu_tab);


        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        Toast.makeText(UserDashboardActivity.this, "Menu is clicked ", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.nav_login:
                        Intent intent = new Intent(UserDashboardActivity.this, LoginActivity.class);
                        startActivity(intent);
                        return true;
                }


                return false;
            }
        });



        //Recycler Views Function
        featuredRecycler();
        mostViewedRecycler();
        navigationDrawer();

    }


    //Navigation Drawer Functions
    private void navigationDrawer() {
        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setCheckedItem(R.id.nav_home);


        menuIcon.setOnClickListener(view -> {

            if (drawerLayout.isDrawerVisible(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            else drawerLayout.openDrawer(GravityCompat.START);
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();

    }




    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.bosphorus_2, "Bosphorus", "Bosphorus is a restaurant serving traditional Turkish food, with a few nods to other international cuisines."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.movenpick, "Mövenpick", "Taste the good life at Mövenpick Hotels & Resorts, where every moment is designed to be savoured and every stay is full of possibilities to relish."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.mole_entrance, "Mole Nation Park", "Mole National Park protects an area of savannah and forest in northern Ghana. It’s home to elephants, leopards and rare birds such as the white-backed vulture."));


        adapter = new FeaturedAdpater(featuredLocations);
        featuredRecycler.setAdapter(adapter);

    }

    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.bosphorus_2, "Bosphorus", "Bosphorus is a restaurant serving traditional Turkish food, with a few nods to other international cuisines."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.movenpick, "Mövenpick", "Taste the good life at Mövenpick Hotels & Resorts, where every moment is designed to be savoured and every stay is full of possibilities to relish."));

        adapter = new FeaturedAdpater(featuredLocations);
        mostViewedRecycler.setAdapter(adapter);
    }


}