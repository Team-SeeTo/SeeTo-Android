package seeto.c2.artoria.us.myapplication.UI.Main;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import seeto.c2.artoria.us.myapplication.UI.LeaderBoard.LeaderBoardActivity;


import seeto.c2.artoria.us.myapplication.UI.Mirror.MirrorActivity;
import seeto.c2.artoria.us.myapplication.UI.Ideas.IdeasFragment;
import seeto.c2.artoria.us.myapplication.UI.Ideas.IdeasSelectCategoryActivity;
import seeto.c2.artoria.us.myapplication.Adapter.MainViewPagerAdapter.CustomViewPagerAdapter;
import seeto.c2.artoria.us.myapplication.UI.QM.QuickMemoFragment;
import seeto.c2.artoria.us.myapplication.UI.QM.WriteMemoActivity;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.UI.Setting.SettingActivity;
import seeto.c2.artoria.us.myapplication.UI.Store.StoreActivity;
import seeto.c2.artoria.us.myapplication.UI.TimeLine.TimeLineFragment;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.CreateTodoActivity;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoFragment;


public class MainActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener, MainContract.View {

    boolean flag;
    View fab_background;
    TextView todo_write_btn, ideas_write_btn, memo_write_btn;
    TabLayout tabs;
    ViewPager viewPager;
    ImageView main_option_btn, main_search_btn;
    FloatingActionButton main_fab, memo_fab, ideas_fab, todo_fab;

    Animation mainfab_animation1 , mainfab_animation2 , memofab_animation1, memofab_animation2
            , ideasfab_animaition1 , ideasfab_animaition2 , todofab_animation1, todofab_animation2;

    MainPresenter mainPresenter = new MainPresenter(this);

    CustomViewPagerAdapter customViewPagerAdapter = new CustomViewPagerAdapter(getSupportFragmentManager());

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
        main_search_btn = findViewById(R.id.main_search_btn);
        fab_background = findViewById(R.id.fab_background);

        main_fab = findViewById(R.id.main_fab);
        memo_fab = findViewById(R.id.memo_fab);
        ideas_fab = findViewById(R.id.ideas_fab);
        todo_fab = findViewById(R.id.todo_fab);


        main_option_btn.setOnClickListener(v -> showOptionDialog() );

        main_search_btn.setOnClickListener(v -> showSearchDialog() );

        viewpagerinit();

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            int current;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                current = position;
                Log.d("POSITION", String.valueOf(current));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        switch (viewPager.getCurrentItem()){
            case 1 :
                main_search_btn.setVisibility(View.INVISIBLE);
                break;

            case 3 :
                main_search_btn.setVisibility(View.INVISIBLE);
                break;
        }

        navigationinit();

       // mainPresenter.SimpleProfileRequest(SharedPreferenceKt.getToken(this,true));

        anmationinit();

        fabinit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.navigation_shop_btn:
                intent = new Intent(MainActivity.this, StoreActivity.class);
                startActivity(intent);
//                finish();
                break;

            case R.id.navigation_leaderboard_btn:
                intent = new Intent(MainActivity.this, LeaderBoardActivity.class);
                startActivity(intent);
                break;
//                finish();

            case R.id.navigation_settings_btn:
                intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                break;

            case R.id.navigation_mirror_btn :
                Intent intent1 = new Intent(MainActivity.this, MirrorActivity.class);
                startActivity(intent1);
                break;
        }
        return false;
    }

    @Override
    public void viewpagerinit() {

        customViewPagerAdapter.addFragment(R.drawable.check_square, new TodoFragment());
        customViewPagerAdapter.addFragment(R.drawable.time_left, new TimeLineFragment());
        customViewPagerAdapter.addFragment(R.drawable.light_bulb, new IdeasFragment());
        customViewPagerAdapter.addFragment(R.drawable.notebook, new QuickMemoFragment());
        viewPager.setAdapter(customViewPagerAdapter);

        tabs.setupWithViewPager(viewPager);

        for (int i = 0; i < 4; i++) {
            tabs.getTabAt(i).setIcon(customViewPagerAdapter.getFragmentInfo(i).getIconResid());
        }


        Intent intent = new Intent();
        if(intent.getBooleanExtra("Memo",false)){
            customViewPagerAdapter.getFragmentInfo(3);
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

        main_fab.bringToFront();

        main_fab.setOnClickListener(v -> {
           main_fabclicked();
        });

        memo_write_btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WriteMemoActivity.class);
            startActivity(intent);
            main_fabclicked();
        });

        ideas_write_btn.setOnClickListener(v -> {
            Intent ideasWriteIntent = new Intent(MainActivity.this, IdeasSelectCategoryActivity.class);
            startActivity(ideasWriteIntent);
            main_fabclicked();
        });

        todo_write_btn.setOnClickListener(v -> {
            Intent todoCreateIntent = new Intent(MainActivity.this, CreateTodoActivity.class);
            startActivity(todoCreateIntent);
            main_fabclicked();

        });

        fab_background.setOnClickListener(v -> main_fabclicked());

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
    public void anmationinit() {


        mainfab_animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.main_fab_rotate_anim1);
        mainfab_animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.main_fab_rotate_anim2);
        memofab_animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.memo_fab_scale_anim1);
        memofab_animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.memo_fab_scale_anim2);
        ideasfab_animaition1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ideas_fab_scale_anim1);
        ideasfab_animaition2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ideas_fab_scale_anim2);
        todofab_animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.todo_fab_scale_anim1);
        todofab_animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.todo_fab_scale_anim2);

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
    }

    @Override
    public void main_fabclicked() {
        if (!flag) {
            flag = true;
            main_fab.startAnimation(mainfab_animation1);
            memo_fab.startAnimation(memofab_animation1);
            ideas_fab.startAnimation(ideasfab_animaition1);
            todo_fab.startAnimation(todofab_animation1);

            fab_background.setVisibility(View.VISIBLE);

            main_fab.invalidate();
            memo_fab.invalidate();
            ideas_fab.invalidate();
            todo_fab.invalidate();
        } else {
            flag = false;
            main_fab.startAnimation(mainfab_animation2);
            memo_fab.startAnimation(memofab_animation2);
            ideas_fab.startAnimation(ideasfab_animaition2);
            todo_fab.startAnimation(todofab_animation2);

            memo_write_btn.setVisibility(View.INVISIBLE);
            ideas_write_btn.setVisibility(View.INVISIBLE);
            todo_write_btn.setVisibility(View.INVISIBLE);

            fab_background.setVisibility(View.GONE);

            main_fab.invalidate();
            memo_fab.invalidate();
            ideas_fab.invalidate();
            todo_fab.invalidate();
        }
    }


    @Override
    public void showSearchDialog() {
        DialogPlus dialogPlus = DialogPlus.newDialog(this)
                .setGravity(Gravity.TOP)
                .setContentHolder(new ViewHolder(R.layout.dialog_search))
                .setCancelable(true)
                .create();

        dialogPlus.show();

        View search_et = dialogPlus.findViewById(R.id.dialog_search_et);
        View search_btn = dialogPlus.findViewById(R.id.dialog_search_btn);


//        search_btn.setOnClickListener(v -> Toast.makeText(this,viewPager.getCurrentItem(),Toast.LENGTH_SHORT).show());


        search_et.setFocusableInTouchMode(true);
        search_et.requestFocus();


    }

    @Override
    public void showToast(String text) {

    }
}
