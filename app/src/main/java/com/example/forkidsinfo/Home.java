package com.example.forkidsinfo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;


public class Home extends AppCompatActivity
{
    LinearLayout layout, table,story,drawing,games,wiki,calci;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        layout=findViewById(R.id.layout_1);
        table=findViewById(R.id.table_layout);
        story=findViewById(R.id.story_layout);
        drawing=findViewById(R.id.drawing_layout);
        games=findViewById(R.id.games_layout);
        wiki =findViewById(R.id.wiki_layout);
        calci = findViewById(R.id.calci_layout);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation_view);

        // Initialize Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout);

        // Set up ActionBarDrawerToggle
        toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open,  // Update your strings.xml for these values
                R.string.close
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Initialize NavigationView
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            // Handle navigation menu item clicks here
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home)
            {
                Toast.makeText(this, "Home Selected", Toast.LENGTH_SHORT).show();
            }
            else if (itemId == R.id.nav_settings)
            {
                Toast.makeText(this, "Setting opened", Toast.LENGTH_SHORT).show();
            }
            drawerLayout.closeDrawers();
            return true;
        });

        // Handle back press using OnBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.closeDrawers();
                } else {
                    finish(); // Close the activity
                }
            }
        });

        layout.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), Animal.class);
            startActivity(intent);
        });
//       second layout coding
        table.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), MultiplicationTables.class);
            startActivity(intent);
        });
//      Story layout coding
        story.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), Stories.class);
            startActivity(intent);
        });
//      drawing layout coding
        drawing.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), drawingPad.class);
            startActivity(intent);
        });
//       Games layout coding
        games.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), Games.class);
            startActivity(intent);
        });
        wiki.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),Wikipedia.class);
            startActivity(intent);
        });
        calci.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),Calculator.class);
            startActivity(intent);
        });

    }
}