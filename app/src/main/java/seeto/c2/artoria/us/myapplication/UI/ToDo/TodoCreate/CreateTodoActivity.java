package seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate;

import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter.TodoViewPagerAdapter;
import seeto.c2.artoria.us.myapplication.R;

public class CreateTodoActivity extends AppCompatActivity {

    private MaterialBetterSpinner materialBetterSpinner;
    public static ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String todoType = "create";
        setContentView(R.layout.activity_to_do_create);

        viewPager = findViewById(R.id.todo_create_view_pager);
        viewPager.setAdapter(new TodoViewPagerAdapter(getSupportFragmentManager(), todoType));

        SharedPreferences sharedPreference = getBaseContext().getSharedPreferences("todoPref", MODE_PRIVATE);

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
