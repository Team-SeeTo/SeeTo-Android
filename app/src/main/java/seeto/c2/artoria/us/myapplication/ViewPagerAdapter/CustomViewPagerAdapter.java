package seeto.c2.artoria.us.myapplication.ViewPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomViewPagerAdapter extends FragmentPagerAdapter {

    private final List<FragmentInfo> mFragmentInfoList = new ArrayList<FragmentInfo>();

    public CustomViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(int iconResId, Fragment fragment) {
        FragmentInfo info = new FragmentInfo(iconResId, fragment);
        mFragmentInfoList.add(info);
    }

    public FragmentInfo getFragmentInfo(int position) {
        return mFragmentInfoList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentInfoList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mFragmentInfoList.size();
    }
}
