package seeto.c2.artoria.us.myapplication.baseline.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.baseline.Fragment.InventoryFragment;
import seeto.c2.artoria.us.myapplication.baseline.Fragment.StoreFragment;
import seeto.c2.artoria.us.myapplication.baseline.ViewPagerAdapter.CustomViewPagerAdapter;

public class StoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        TabLayout tabLayout = findViewById(R.id.store_tabs);
        ViewPager viewPager = findViewById(R.id.store_viewpager);

        tabLayout.setRotationX(180);

        CustomViewPagerAdapter customViewPagerAdapter = new CustomViewPagerAdapter(getSupportFragmentManager());
        customViewPagerAdapter.addFragment(R.drawable.outline_store_mall_directory_24px,new StoreFragment());
        customViewPagerAdapter.addFragment(R.drawable.outline_inbox_24px,new InventoryFragment());
        viewPager.setAdapter(customViewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i< 2; i++){
            tabLayout.getTabAt(i).setIcon(customViewPagerAdapter.getFragmentInfo(i).getIconResid());
        }

    }
}
