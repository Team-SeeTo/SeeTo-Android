package seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment.CreateTodoFragment;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment.ModifyTodoFragment;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment.SelectCategoryFragment;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment.SelectDueDateFragment;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment.SelectModeFragment;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment.SetTodoTitleFragment;

public class TodoViewPagerAdapter extends FragmentStatePagerAdapter {
    String todoType;
    public TodoViewPagerAdapter(FragmentManager fm, String todoType) {
        super(fm);
        this.todoType = todoType;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return SetTodoTitleFragment.newInstance(todoType);
            case 1:
                return SelectCategoryFragment.newInstance(todoType);
            case 2:
                return SelectModeFragment.newInstance(todoType);
            case 3:
                return SelectDueDateFragment.newInstance(todoType);
            case 4:
                if(todoType.equals("create")) {
                    Log.d("TODO viewpager", "create");
                    return CreateTodoFragment.newInstance(todoType);
                }else {
                    return ModifyTodoFragment.newInstance(todoType);
                }
        }
        return SetTodoTitleFragment.newInstance(todoType);
    }



    @Override
    public int getCount() {
        return 5;
    }
}
