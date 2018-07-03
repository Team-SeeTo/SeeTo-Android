package seeto.c2.artoria.us.myapplication;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import seeto.c2.artoria.us.myapplication.Ideas.IdeasFragment;
import seeto.c2.artoria.us.myapplication.QM.QuickMemoFragment;
import seeto.c2.artoria.us.myapplication.TimeLine.TimeLineFragment;
import seeto.c2.artoria.us.myapplication.ToDo.ToDoFragment;
import seeto.c2.artoria.us.myapplication.ViewPagerAdapter.CustomViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabs = findViewById(R.id.main_tab);
        ViewPager viewPager = findViewById(R.id.main_viewpager);
        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        final FloatingActionButton main_fab = findViewById(R.id.main_fab);
        final FloatingActionButton memo_fab = findViewById(R.id.memo_fab);
        final FloatingActionButton ideas_fab = findViewById(R.id.ideas_fab);
        final FloatingActionButton todo_fab = findViewById(R.id.todo_fab);

        CustomViewPagerAdapter customViewPagerAdapter = new CustomViewPagerAdapter(getSupportFragmentManager());
        customViewPagerAdapter.addFragment(R.drawable.outline_done_all_black_36dp,new ToDoFragment());
        customViewPagerAdapter.addFragment(R.drawable.outline_restore_black_36dp,new TimeLineFragment());
        customViewPagerAdapter.addFragment(R.drawable.outline_flash_on_black_36dp,new IdeasFragment());
        customViewPagerAdapter.addFragment(R.drawable.outline_format_quote_black_36dp,new QuickMemoFragment());
        viewPager.setAdapter(customViewPagerAdapter);

        tabs.setupWithViewPager(viewPager);

        for (int i = 0; i< 4; i++){
            tabs.getTabAt(i).setIcon(customViewPagerAdapter.getFragmentInfo(i).getIconResid());
        }

        ImageView main_drawer_btn = findViewById(R.id.main_navidraw);
        main_drawer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        final Animation mainfab_animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.main_fab_rotate_anim1);
        final Animation mainfab_animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.main_fab_rotate_anim2);

        final Animation memofab_animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.memo_fab_scale_anim1);
        final Animation memofab_animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.memo_fab_scale_anim2);

        final Animation ideasfab_animaition1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ideas_fab_scale_anim1);
        final Animation ideasfab_animaition2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ideas_fab_scale_anim2);

        final Animation todofab_animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.todo_fab_scale_anim1);
        final Animation todofab_animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.todo_fab_scale_anim2);

        main_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });

        todo_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "눌리긴 함", Toast.LENGTH_SHORT).show();
            }
        });

     }
}
