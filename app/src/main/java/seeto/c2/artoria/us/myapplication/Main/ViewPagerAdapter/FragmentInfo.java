package seeto.c2.artoria.us.myapplication.Main.ViewPagerAdapter;

import android.support.v4.app.Fragment;

public class FragmentInfo {
    private int iconResid;
    private Fragment fragment;

    public FragmentInfo(int iconResid, Fragment fragment){
        this.iconResid = iconResid;
        this.fragment = fragment;
    }


    public int getIconResid() {
        return iconResid;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
