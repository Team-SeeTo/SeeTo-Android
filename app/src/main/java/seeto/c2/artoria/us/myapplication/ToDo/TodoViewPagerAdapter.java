package seeto.c2.artoria.us.myapplication.ToDo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class TodoViewPagerAdapter extends FragmentPagerAdapter {
    public TodoViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    CreateTodoFragment createTodoFragment;
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return SelectCategoryFragment.newInstance();
            case 1:
                return SelectModeFragment.newInstance();
            case 2:
                return SelectDueDateFragment.newInstance();
            case 3:
                createTodoFragment = CreateTodoFragment.newInstance();
//                return CreateTodoFragment.newInstance();
                return createTodoFragment;
        }
        return SelectCategoryFragment.newInstance();
    }



    @Override
    public int getCount() {
        return 4;
    }
}
