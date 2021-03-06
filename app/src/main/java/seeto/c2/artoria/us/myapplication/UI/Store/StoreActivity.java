package seeto.c2.artoria.us.myapplication.UI.Store;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import seeto.c2.artoria.us.myapplication.Adapter.MainViewPagerAdapter.CustomViewPagerAdapter;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;
import seeto.c2.artoria.us.myapplication.UI.Inventory.InventoryFragment;

public class StoreActivity extends AppCompatActivity implements StoreContract.View{
    TextView point;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        tabsinit();

        point = findViewById(R.id.store_point);
        point.setText(SharedPreferenceKt.getInfo(this,"point")+"p");

    }

    @Override
    public void tabsinit() {
        TabLayout tabLayout = findViewById(R.id.store_tabs);
        ViewPager viewPager = findViewById(R.id.store_viewpager);

        tabLayout.setRotationX(180);

        CustomViewPagerAdapter customViewPagerAdapter = new CustomViewPagerAdapter(getSupportFragmentManager());
        customViewPagerAdapter.addFragment(R.drawable.ic_baseline_store_24px,new StoreFragment());
        customViewPagerAdapter.addFragment(R.drawable.ic_baseline_inbox_24px,new InventoryFragment());
        viewPager.setAdapter(customViewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);


        for (int i = 0; i< 2; i++){
            tabLayout.getTabAt(i).setIcon(customViewPagerAdapter.getFragmentInfo(i).getIconResid());
        }
    }

    @Override
    public void listinit() {

    }

}
