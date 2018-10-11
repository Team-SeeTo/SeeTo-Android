package seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate;

import android.arch.lifecycle.ViewModelProviders;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter.TodoViewPagerAdapter;
import seeto.c2.artoria.us.myapplication.Item.TodoItem;
import seeto.c2.artoria.us.myapplication.R;

public class CreateTodoActivity extends AppCompatActivity {

    private MaterialBetterSpinner materialBetterSpinner;
    public static ViewPager viewPager;
    SibalLom sibalLom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String editTodoType = getIntent().getExtras().getString("editTodoType");
        sibalLom = ViewModelProviders.of(this).get(SibalLom.class);
        Log.d("TODO create - type: ", editTodoType);
        setContentView(R.layout.activity_to_do_create);

        viewPager = findViewById(R.id.todo_create_view_pager);
        if(editTodoType.equals("create")) {
            viewPager.setAdapter(new TodoViewPagerAdapter(getSupportFragmentManager(), editTodoType));
        } else if(editTodoType.equals("modify")) {
            Bundle bundle = getIntent().getExtras();
            String id = bundle.getString("id");
            sibalLom.getId().setValue(id);
            Log.d("create todo", id);
            String title = bundle.getString("title");
            String expiration = bundle.getString("expiration");
            String mode = bundle.getString("mode");
            ArrayList<TodoItem> items = bundle.getParcelableArrayList("items");
            viewPager.setAdapter(new TodoViewPagerAdapter(getSupportFragmentManager(), editTodoType, id, title, mode, expiration, items));
        } else {
            Log.d("TODO create err", editTodoType);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
