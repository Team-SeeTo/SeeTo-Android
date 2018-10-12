package seeto.c2.artoria.us.myapplication.UI.Main;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
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
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Model.SimpleProfileModel;
import seeto.c2.artoria.us.myapplication.Model.TimeLineModel;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;
import seeto.c2.artoria.us.myapplication.UI.LeaderBoard.LeaderBoardActivity;


import seeto.c2.artoria.us.myapplication.UI.Mirror.MirrorActivity;
import seeto.c2.artoria.us.myapplication.UI.Ideas.IdeasFragment;
import seeto.c2.artoria.us.myapplication.UI.Ideas.IdeasSelectCategoryActivity;
import seeto.c2.artoria.us.myapplication.Adapter.MainViewPagerAdapter.CustomViewPagerAdapter;
import seeto.c2.artoria.us.myapplication.UI.QM.QuickMemoFragment;
import seeto.c2.artoria.us.myapplication.UI.QM.WriteMemoActivity;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.UI.Setting.SettingActivity;
import seeto.c2.artoria.us.myapplication.UI.Signin.SigninActivity;
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
    String orderBy;
    String current_context;

    Animation mainfab_animation1, mainfab_animation2, memofab_animation1, memofab_animation2, ideasfab_animaition1, ideasfab_animaition2, todofab_animation1, todofab_animation2;

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


        main_option_btn.setOnClickListener(v -> {
            switch (viewPager.getCurrentItem()) {
                case 0:
                    current_context = "Todo";
                    showOptionDialog(current_context);
                    break;

                case 1:
                    current_context = "TimeLine";
                    showSelectDateDialog();
                    break;

                case 2:
                    current_context = "Ideas";
                    showIdeasDialog(current_context);
                    //Todo Ideas 서벼 연결 코드 필요 (정렬)
                    break;

                default:
                    current_context = "default";
            }
        });

        main_search_btn.setOnClickListener(v -> showSearchDialog());

        viewpagerinit();

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            int vp_current;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                vp_current = position;
                Log.d("POSITION", String.valueOf(vp_current));
                switch (vp_current) {
                    case 0 :
                        main_search_btn.setVisibility(View.GONE);
                        main_option_btn.setVisibility(View.GONE);
                        break;

                    case 1:
                        main_option_btn.setVisibility(View.VISIBLE);
                        main_search_btn.setVisibility(View.GONE);
                        break;

                    case 3:
                        main_search_btn.setVisibility(View.GONE);
                        main_option_btn.setVisibility(View.GONE);
                        break;

                    default:
                        main_search_btn.setVisibility(View.VISIBLE);
                        main_option_btn.setVisibility(View.VISIBLE);
                }
            }


            @Override
            public void onPageSelected(int position) {
                vp_current = position;
                Log.d("POSITION", String.valueOf(vp_current));
                switch (vp_current) {
                    case 0 :
                        main_search_btn.setVisibility(View.GONE);
                        main_option_btn.setVisibility(View.GONE);
                        break;

                    case 1:
                        main_option_btn.setVisibility(View.VISIBLE);
                        main_search_btn.setVisibility(View.GONE);
                        break;

                    case 3:
                        main_search_btn.setVisibility(View.GONE);
                        main_option_btn.setVisibility(View.GONE);
                        break;

                    default:
                        main_search_btn.setVisibility(View.VISIBLE);
                        main_option_btn.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        getuserinfo();

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

            case R.id.navigation_Logout_btn:
                intent = new Intent(MainActivity.this, SigninActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.navigation_mirror_btn:
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
        if (intent.getBooleanExtra("Memo", false)) {
            customViewPagerAdapter.getFragmentInfo(3);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void navigationinit() {
        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navi_view = findViewById(R.id.navigation_view);
        navi_view.setNavigationItemSelectedListener(this);


        View view = navi_view.getHeaderView(0);
        TextView username = view.findViewById(R.id.navigation_header_user_name);
        TextView rank = view.findViewById(R.id.navigation_header_rank);
        TextView point = view.findViewById(R.id.navigation_header_point);

        username.setText(SharedPreferenceKt.getInfo(getBaseContext(), "username"));
        rank.setText("#" + SharedPreferenceKt.getInfo(getBaseContext(), "rank"));
        point.setText(SharedPreferenceKt.getInfo(getBaseContext(), "point") + "p");


        ImageView main_drawer_btn = findViewById(R.id.main_navidraw);
        main_drawer_btn.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);

            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


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
            todoCreateIntent.putExtra("editTodoType", "create");
            startActivity(todoCreateIntent);
            main_fabclicked();

        });

        fab_background.setOnClickListener(v -> main_fabclicked());

    }

    @Override
    public void getuserinfo() {
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("token", SharedPreferenceKt.getToken(getBaseContext(), true));

        new Connector(this).getClient().SimpleProfile(queryContainerBuilder)
                .enqueue(new Callback<SimpleProfileModel>() {
                    @Override
                    public void onResponse(Call<SimpleProfileModel> call, Response<SimpleProfileModel> response) {
                        SimpleProfileModel data = response.body();
                        SharedPreferenceKt.saveInfo(getBaseContext(), "username", data.getData().getProfile().getUsername());
                        SharedPreferenceKt.saveInfo(getBaseContext(), "email", data.getData().getProfile().getEmail());
                        SharedPreferenceKt.saveInfo(getBaseContext(), "rank", String.valueOf(data.getData().getProfile().getRank()));
                        SharedPreferenceKt.saveInfo(getBaseContext(), "point", String.valueOf(data.getData().getProfile().getPoint()));
                        SharedPreferenceKt.saveInfo(getBaseContext(), "registerOn", data.getData().getProfile().getRegisterOn());
                    }

                    @Override
                    public void onFailure(Call<SimpleProfileModel> call, Throwable t) {

                    }
                });
    }

    @Override
    public void showOptionDialog(String context) {
        Dialog dialog = new Dialog(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_options, null);
        dialog.setContentView(view);

        TextView apply_btn = dialog.findViewById(R.id.dialog_options_apply_btn);
        TextView cancel_btn = dialog.findViewById(R.id.dialog_options_cancel_btn);
        TextView sct = dialog.findViewById(R.id.dialog_options_sct);
        Switch sct_switch = dialog.findViewById(R.id.dialog_options_sct_switch);

        RadioGroup radioGroup = dialog.findViewById(R.id.dialog_options_radiogroup);

        sct.setVisibility(View.INVISIBLE);
        sct_switch.setVisibility(View.INVISIBLE);

        dialog.show();

        apply_btn.setOnClickListener(v -> {


        });


        cancel_btn.setOnClickListener(v -> dialog.dismiss());


        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCanceledOnTouchOutside(false);
    }

    @Override
    public void showIdeasDialog(String context) {
        Dialog dialog = new Dialog(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_ideas, null);
        dialog.setContentView(view);

        TextView apply_btn = dialog.findViewById(R.id.dialog_ideas_apply_btn);
        TextView cancel_btn = dialog.findViewById(R.id.dialog_ideas_cancel_btn);

        RadioGroup radioGroup = dialog.findViewById(R.id.dialog_ideas_radiogroup);

        dialog.show();

        apply_btn.setOnClickListener(v -> {
            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.dialog_ideas_radio_it:
                    orderBy = "IT";
                    break;

                case R.id.dialog_ideas_radio_life:
                    orderBy = "Life";
                    break;

                case R.id.dialog_ideas_radio_food:
                    orderBy = "Food";
                    break;

            }
            ((IdeasFragment) customViewPagerAdapter.getmFragmentInfoList().get(2).getFragment())
                    .IdeasOrderByRequest(SharedPreferenceKt.getToken(this, true), orderBy, 1);

            dialog.dismiss();
        });
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

        EditText search_et = (EditText) dialogPlus.findViewById(R.id.dialog_search_et);
        ImageView search_btn = (ImageView) dialogPlus.findViewById(R.id.dialog_search_btn);


        search_btn.setOnClickListener(v -> {
            switch (viewPager.getCurrentItem()) {
                case 0:
                    current_context = "Todo";
                    //Todo todo 서버 연결 코드 필요 (검색)
                    break;

                case 2:
                    current_context = "Ideas";
//                    IdeasFragment ideasFragment = new IdeasFragment();
//                    ideasFragment.IdeasSearchRequest(search_et.getText().toString());
                    ((IdeasFragment) customViewPagerAdapter.getmFragmentInfoList().get(2).getFragment()).IdeasSearchRequest(search_et.getText().toString());
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(search_et.getWindowToken(), 0);
                    dialogPlus.dismiss();
                    break;

                default:
                    current_context = "default";
            }
        });

        search_et.setFocusableInTouchMode(true);
        search_et.requestFocus();

    }

    @Override
    public void showSelectDateDialog() {
        Dialog dialog = new Dialog(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_timeline_select_date, null);
        dialog.setContentView(view);

        TextView apply_btn = dialog.findViewById(R.id.dialog_timeline_apply_btn);
        TextView cancel_btn = dialog.findViewById(R.id.dialog_timeline_cancel_btn);
        DatePicker cal = dialog.findViewById(R.id.dialog_timeline_select_date_cal);


        dialog.show();


        apply_btn.setOnClickListener(v -> {

            String date;

            date = String.valueOf(cal.getYear()) + "-" + String.valueOf(cal.getMonth() + 1) + "-" + String.valueOf(cal.getDayOfMonth());
            Log.d("day",date);
            ((TimeLineFragment) customViewPagerAdapter.getmFragmentInfoList().get(1).getFragment()).getTimelineData(SharedPreferenceKt.getToken(this, true), date);

            dialog.dismiss();

        });


        cancel_btn.setOnClickListener(v -> dialog.dismiss());

        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCanceledOnTouchOutside(false);
    }


}
