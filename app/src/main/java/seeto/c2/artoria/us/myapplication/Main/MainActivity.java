package seeto.c2.artoria.us.myapplication.Main;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import seeto.c2.artoria.us.myapplication.Ideas.IdeasFragment;
import seeto.c2.artoria.us.myapplication.Main.ViewPagerAdapter.CustomViewPagerAdapter;
import seeto.c2.artoria.us.myapplication.QM.QuickMemoFragment;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.Store.StoreActivity;
import seeto.c2.artoria.us.myapplication.TimeLine.TimeLineFragment;
import seeto.c2.artoria.us.myapplication.ToDo.ToDoFragment;

public class MainActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener, MainContract.View {

    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpagerinit();

        navigationinit();

        //        final View view = findViewById(R.id.memo_view);
        final FloatingActionButton main_fab = findViewById(R.id.main_fab);
        final FloatingActionButton memo_fab = findViewById(R.id.memo_fab);
        final FloatingActionButton ideas_fab = findViewById(R.id.ideas_fab);
        final FloatingActionButton todo_fab = findViewById(R.id.todo_fab);

        main_fab.bringToFront();

        final Animation mainfab_animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.main_fab_rotate_anim1);
        final Animation mainfab_animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.main_fab_rotate_anim2);

        final Animation memofab_animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.memo_fab_scale_anim1);
        final Animation memofab_animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.memo_fab_scale_anim2);

        final Animation ideasfab_animaition1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ideas_fab_scale_anim1);
        final Animation ideasfab_animaition2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ideas_fab_scale_anim2);

        final Animation todofab_animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.todo_fab_scale_anim1);
        final Animation todofab_animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.todo_fab_scale_anim2);


        main_fab.setOnClickListener(v -> {
            if (!flag) {
                flag = true;
                main_fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#A079E6")));
                main_fab.startAnimation(mainfab_animation1);
                memo_fab.startAnimation(memofab_animation1);
                ideas_fab.startAnimation(ideasfab_animaition1);
                todo_fab.startAnimation(todofab_animation1);

                main_fab.invalidate();
                memo_fab.invalidate();
                ideas_fab.invalidate();
                todo_fab.invalidate();
            } else {
                flag = false;
                main_fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                main_fab.startAnimation(mainfab_animation2);
                memo_fab.startAnimation(memofab_animation2);
                ideas_fab.startAnimation(ideasfab_animaition2);
                todo_fab.startAnimation(todofab_animation2);

                main_fab.invalidate();
                memo_fab.invalidate();
                ideas_fab.invalidate();
                todo_fab.invalidate();
            }
        });

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "눌리긴 함", Toast.LENGTH_SHORT).show();
//            }
//        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_shop_btn:
                Intent intent = new Intent(MainActivity.this, StoreActivity.class);
                startActivity(intent);
                finish();
        }
        return false;
    }

    @Override
    public void viewpagerinit() {
        TabLayout tabs = findViewById(R.id.main_tab);
        ViewPager viewPager = findViewById(R.id.main_viewpager);

        CustomViewPagerAdapter customViewPagerAdapter = new CustomViewPagerAdapter(getSupportFragmentManager());
        customViewPagerAdapter.addFragment(R.drawable.check_square, new ToDoFragment());
        customViewPagerAdapter.addFragment(R.drawable.time_left, new TimeLineFragment());
        customViewPagerAdapter.addFragment(R.drawable.light_bulb, new IdeasFragment());
        customViewPagerAdapter.addFragment(R.drawable.notebook, new QuickMemoFragment());
        viewPager.setAdapter(customViewPagerAdapter);

        tabs.setupWithViewPager(viewPager);

        for (int i = 0; i < 4; i++) {
            tabs.getTabAt(i).setIcon(customViewPagerAdapter.getFragmentInfo(i).getIconResid());
        }
    }

    @Override
    public void navigationinit() {
        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        ImageView main_drawer_btn = findViewById(R.id.main_navidraw);
        main_drawer_btn.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navi_view = findViewById(R.id.navigation_view);
        navi_view.setNavigationItemSelectedListener(this);
    }
}
