package com.example.ashu.tlt;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DrawerLayout drawer1 = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer1.openDrawer(GravityCompat.START);


        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.colorBlank)); //Changes the color of text when collapsed
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.colorTransparent));//Changes the color of text when expanded

        collapsingToolbar.setContentScrimColor(getResources().getColor(R.color.colorPrimary));//Changes the color of toolbar when collapsed


        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.content_frame, new SecondFragment());
        tx.commit(); //Creating default layout


        Toolbar toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState(); //This is for creating the hamburger button


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this); //This is for traversing using drawer buttons


        navigationView.setCheckedItem(R.id.nav_second_layout); //Highlighting the first layout
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);}
        //Forcing to 'Potrait' mode after setting the same in Manifest
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_second_layout) {
             fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new SecondFragment())
                    .commit(); //Linking the second button to the second fragment

        } else if (id == R.id.nav_third_layout) {
             fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new ThirdFragment())
                    .commit(); //Linking the third button to the third fragment

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void kerala(View view) {
        Intent kerala = new Intent(this,ContentDisplay.class);
        startActivity(kerala);
    }

    public void triangle(View view) {
        Intent triangle = new Intent(this,ContentDisplayTri.class);
        startActivity(triangle);
    }

    public void north(View view) {
        Intent north = new Intent(this,ContentDisplayNorth.class);
        startActivity(north);
    }

    public void tiger(View view) {
        Intent tiger = new Intent(this,ContentDisplayTiger.class);
        startActivity(tiger);
    }

    public void panther(View view) {
        Intent panther = new Intent(this,ContentDisplayPanther.class);
        startActivity(panther);
    }

    public void review(View view){
        Uri uri = Uri.parse("https://m.facebook.com/pg/Tour-de-India-with-Umed-629028100456191/reviews/?mt_nav=1");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        startActivity(intent);
    }
}
