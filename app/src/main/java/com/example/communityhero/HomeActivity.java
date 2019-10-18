package com.example.communityhero;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.navigation.NavigationView;
import com.parse.ParseUser;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    RecyclerView recyclerView;
    PostAdapter adapter;
    List<Post> postList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Drawer
        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.bringToFront();
        //Drawer item selection
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);

                    case R.id.tasks:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TasksFragment()).commit();
                        break;

                    case R.id.settings:
//                        ParseUser.getCurrentUser().logOut();
//                        intent = new Intent(getApplicationContext(), LoginActivity.class);
//                        startActivity(intent);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        //To open and close drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Recycler view to contain the cards (posts)
        postList = new ArrayList<>();
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        postList.add(
                new Post(
                        1,
                        "Clearing neighborhood garbabge",
                        "There's a lot of garbage left unattended these days. So I thought we could clean it up",
                        "Contributors: 4"));

        postList.add(
                new Post(
                        1,
                        "Clearing neighborhood garbabge",
                        "There's a lot of garbage left unattended these days. So I thought we could clean it up",
                        "Contributors: 4"));

        postList.add(
                new Post(
                        1,
                        "Clearing neighborhood garbabge",
                        "There's a lot of garbage left unattended these days. So I thought we could clean it up",
                        "Contributors: 4"));

        postList.add(
                new Post(
                        1,
                        "Clearing neighborhood garbabge",
                        "There's a lot of garbage left unattended these days. So I thought we could clean it up",
                        "Contributors: 4"));

        postList.add(
                new Post(
                        1,
                        "Clearing neighborhood garbabge",
                        "There's a lot of garbage left unattended these days. So I thought we could clean it up",
                        "Contributors: 4"));

        postList.add(
                new Post(
                        1,
                        "Clearing neighborhood garbabge",
                        "There's a lot of garbage left unattended these days. So I thought we could clean it up",
                        "Contributors: 4"));

        adapter = new PostAdapter(this, postList);
        recyclerView.setAdapter(adapter);
    }

    //Drawer on back press
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    // To bookmark a post
    public void save(View view) {
        Toast.makeText(this, "SAVED", Toast.LENGTH_SHORT).show();
    }

    // To create a post
    public void add(View view) {
        Log.i("info", "added");
    }
}
