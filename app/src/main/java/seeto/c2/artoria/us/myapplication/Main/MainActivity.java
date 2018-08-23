package seeto.c2.artoria.us.myapplication.Main;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
    TextView todo_write_btn;
    TextView ideas_write_btn;
    TextView memo_write_btn;
    TabLayout tabs;
    ViewPager viewPager;
    ImageView main_option_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memo_write_btn = findViewById(R.id.memo_write_btn);
        ideas_write_btn = findViewById(R.id.ideas_write_btn);
        todo_write_btn = findViewById(R.id.todo_write_btn);
        tabs = findViewById(R.id.main_tab);
        viewPager = findViewById(R.id.main_viewpager);
        main_option_btn = findViewById(R.id.main_option_btn);

        main_option_btn.setOnClickListener(v -> showOptionDialog() );

        viewpagerinit();

        navigationinit();

        fabinit();

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

    @Override
    public void fabinit() {
        //        final View view = findViewById(R.id.memo_view);
        final FloatingActionButton main_fab = findViewById(R.id.main_fab);
        final FloatingActionButton memo_fab = findViewById(R.id.memo_fab);
        final FloatingActionButton ideas_fab = findViewById(R.id.ideas_fab);
        final FloatingActionButton todo_fab = findViewById(R.id.todo_fab);

        main_fab.bringToFront();



        final Animation mainfab_animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.main_fab_rotate_anim1);
        final Animation mainfab_animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.main_fab_rotate_anim2);

        final Animation memofab_animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.memo_fab_scale_anim1);

        memofab_animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                memo_write_btn.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        final Animation memofab_animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.memo_fab_scale_anim2);

        final Animation ideasfab_animaition1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ideas_fab_scale_anim1);

        ideasfab_animaition1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                ideas_write_btn.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        final Animation ideasfab_animaition2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ideas_fab_scale_anim2);

        final Animation todofab_animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.todo_fab_scale_anim1);

        todofab_animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                todo_write_btn.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        final Animation todofab_animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.todo_fab_scale_anim2);

        main_fab.setOnClickListener(v -> {
            if (!flag) {
                flag = true;
                main_fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#A079E6")));
                main_fab.startAnimation(mainfab_animation1);
                memo_fab.startAnimation(memofab_animation1);
                ideas_fab.startAnimation(ideasfab_animaition1);
                todo_fab.startAnimation(todofab_animation1);

                viewPager.setClickable(false);
                viewPager.setOnTouchListener((view, motionEvent) -> true);
                viewPager.setEnabled(false);


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

                memo_write_btn.setVisibility(View.INVISIBLE);
                ideas_write_btn.setVisibility(View.INVISIBLE);
                todo_write_btn.setVisibility(View.INVISIBLE);

                viewPager.setClickable(true);
                viewPager.setOnTouchListener((view, motionEvent) -> false);
                viewPager.setEnabled(true);

                main_fab.invalidate();
                memo_fab.invalidate();
                ideas_fab.invalidate();
                todo_fab.invalidate();
            }
        });

        memo_write_btn.setOnClickListener(v -> Toast.makeText(this, "눌림", Toast.LENGTH_SHORT).show());
        ideas_write_btn.setOnClickListener(v -> Toast.makeText(this, "이것도 눌림", Toast.LENGTH_SHORT).show());
        todo_write_btn.setOnClickListener(v -> Toast.makeText(this, "이것도", Toast.LENGTH_SHORT).show());

    }

    @Override
    public void showOptionDialog() {
        Dialog dialog = new Dialog(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_options,null);
        dialog.setContentView(R.layout.dialog_options);

        TextView apply_btn = dialog.findViewById(R.id.dialog_options_apply_btn);
        TextView cancel_btn = dialog.findViewById(R.id.dialog_options_cancel_btn);

        dialog.show();

        apply_btn.setOnClickListener(v -> {
            Toast.makeText(this, "apply clicked", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        cancel_btn.setOnClickListener(v -> dialog.dismiss());

        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCanceledOnTouchOutside(false);
    }

    @Override
    public void showToast(String text) {

    }
}
