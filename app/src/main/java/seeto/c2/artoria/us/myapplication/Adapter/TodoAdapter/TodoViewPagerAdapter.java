package seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Item.TodoItem;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment.CreateTodoFragment;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment.ModifyTodoFragment;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment.SelectCategoryFragment;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment.SelectDueDateFragment;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment.SelectModeFragment;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment.SetTodoTitleFragment;

public class TodoViewPagerAdapter extends FragmentStatePagerAdapter {
    String todoType, id, title, mode, expiration;
    ArrayList<TodoItem> items;

    public TodoViewPagerAdapter(FragmentManager fm, String todoType) {
        super(fm);
        Log.d("TODO viewpager todotype", todoType);
        this.todoType = todoType;
    }

    public TodoViewPagerAdapter(FragmentManager fm, String todoType, String id, String title, String mode, String expiration, ArrayList<TodoItem> items) {
        super(fm);
        Log.d("TODO viewpager todotype", todoType);
        this.todoType = todoType;
        this.id = id;
        this.title = title;
        this.mode = mode;
        this.expiration = expiration;
        this.items = items;
    }

    @Override
    public Fragment getItem(int position) {
        if(todoType.equals("create")) {
            switch (position){
                case 0:
                    return SetTodoTitleFragment.newInstance();
                case 1:
                    return SelectModeFragment.newInstance();
                case 2:
                    return SelectDueDateFragment.newInstance();
                case 3:
                    return CreateTodoFragment.newInstance();
            }
        }else {
            switch (position){
                case 0:
                    return ModifyTodoFragment.newInstance(title);
            }
        }
        return SetTodoTitleFragment.newInstance(todoType);
    }



    @Override
    public int getCount() {
        if (todoType.equals("create")) {
            return 4;
        }else {
            return 1;
        }
    }
}
