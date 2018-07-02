package seeto.c2.artoria.us.myapplication;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import seeto.c2.artoria.us.myapplication.Ideas.IdeasFragment;
import seeto.c2.artoria.us.myapplication.QM.QuickMemoFragment;
import seeto.c2.artoria.us.myapplication.TimeLine.TimeLineFragment;
import seeto.c2.artoria.us.myapplication.ToDo.ToDoFragment;
import seeto.c2.artoria.us.myapplication.ViewPagerAdapter.CustomViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = MainActivity.this;

        TabLayout tabs = findViewById(R.id.main_tab);
        ViewPager viewPager = findViewById(R.id.main_viewpager);
        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

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



     }
}
