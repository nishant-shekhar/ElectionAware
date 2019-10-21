package com.nsappsstudio.electionaware;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        mDrawerLayout=findViewById(R.id.drawer_layout);

        LoadMenu();

        final CoordinatorLayout content = findViewById(R.id.coordinatorLayout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close) {
            private float scaleFactor = 6f;

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float slideX = drawerView.getWidth() * slideOffset;
                content.setTranslationX(slideX);
                content.setScaleX(1 - (slideOffset / scaleFactor));
                content.setScaleY(1 - (slideOffset / scaleFactor));
            }
        };

        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        mDrawerLayout.setDrawerElevation(0f);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);


    }
    private void LoadMenu(){
        RecyclerView recyclerView = findViewById(R.id.main_option_rv);
        recyclerView.hasFixedSize();
        recyclerView.setVisibility(View.VISIBLE);
        RecyclerView.LayoutManager recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        String[] menu={"Know Your Candidate","Centralize Contact","Locate Booth","Important Dates","How to Vote", "Message from ECI"};
        List<MainMenuItems> mainMenuItems=new ArrayList<>();
        for (String aMenu : menu) {
            MainMenuItems mainMenuItem;
            if (aMenu.equals("Know Your Candidate")) {
                mainMenuItem = new MainMenuItems(aMenu, "12");
            }else {
                mainMenuItem = new MainMenuItems(aMenu, null);
            }
            mainMenuItems.add(mainMenuItem);
            RecyclerView.Adapter adapter = new MainMenuAdapter(mainMenuItems, this);
            recyclerView.setAdapter(adapter);
        }



    }
    /*private void LoadSection1(){
        RecyclerView recyclerViewSection1 = findViewById(R.id.section1_rv);
        recyclerViewSection1.hasFixedSize();
        recyclerViewSection1.setVisibility(View.VISIBLE);
        RecyclerView.LayoutManager recyclerViewLayoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewSection1.setLayoutManager(recyclerViewLayoutManager1);
        String[] subject={"Breakfast","Break","Lunch","Snack","Dinner"};
        List<ScrollItem> scrollItems=new ArrayList<>();
        for (String aSubject : subject) {
            ScrollItem scrollItem = new ScrollItem(aSubject, 1,null);
            scrollItems.add(scrollItem);
            RecyclerView.Adapter adapter = new ScrollItemAdapter(scrollItems, this);
            recyclerViewSection1.setAdapter(adapter);
        }
    }
    private void LoadSection2(){
        RecyclerView recyclerViewSection1 = findViewById(R.id.section2_rv);
        recyclerViewSection1.hasFixedSize();
        recyclerViewSection1.setVisibility(View.VISIBLE);
        RecyclerView.LayoutManager recyclerViewLayoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewSection1.setLayoutManager(recyclerViewLayoutManager1);
        String[] subject={"Maths","Science","Geography","History","English","Chemistry","Physics"};
        List<ScrollItem> scrollItems=new ArrayList<>();
        for (String aSubject : subject) {
            ScrollItem scrollItem = new ScrollItem(aSubject, 1,null);
            scrollItems.add(scrollItem);
            RecyclerView.Adapter adapter = new ScrollItemAdapter(scrollItems, this);
            recyclerViewSection1.setAdapter(adapter);
        }
    }
    private void LoadSection3(){
        RecyclerView recyclerViewSection1 = findViewById(R.id.section3_rv);
        recyclerViewSection1.hasFixedSize();
        recyclerViewSection1.setVisibility(View.VISIBLE);
        RecyclerView.LayoutManager recyclerViewLayoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewSection1.setLayoutManager(recyclerViewLayoutManager1);
        String[] subject={"Maths","Science","Geography","History","English","Chemistry","Physics"};
        List<ScrollItem> scrollItems=new ArrayList<>();
        for (String aSubject : subject) {
            ScrollItem scrollItem = new ScrollItem(aSubject, 1,null);
            scrollItems.add(scrollItem);
            RecyclerView.Adapter adapter = new ScrollItemAdapter(scrollItems, this);
            recyclerViewSection1.setAdapter(adapter);
        }
    }*/
    public void playAnim(View view){
        YoYo.with(Techniques.Wobble)
                .duration(1000)
                .playOn(view);
        Intent intent= new Intent(MainActivity.this,EciWebsite.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
