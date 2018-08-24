package seeto.c2.artoria.us.myapplication.Ideas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import seeto.c2.artoria.us.myapplication.R;

import static seeto.c2.artoria.us.myapplication.ToDo.TodoCreate.CreateTodoActivity.viewPager;

public class IdeasSelectCategoryActivity extends AppCompatActivity {

    TextView next_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_select_category);

        next_btn = findViewById(R.id.category_next);

        next_btn.setOnClickListener(v -> {
            Intent intent = new Intent(IdeasSelectCategoryActivity.this, IdeasWriteActivity.class);
            startActivity(intent);
            finish();
        });

        String[] categoryList = {
                "IT", "Life", "Food"
        };

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                categoryList
        );

        MaterialBetterSpinner materialBetterSpinner;

        materialBetterSpinner = findViewById(R.id.category_spinner);
        materialBetterSpinner.setAdapter(categoryAdapter);
        materialBetterSpinner.setText(categoryAdapter.getItem(0).toString());

        TextView nextText = (TextView) findViewById(R.id.category_next);


    }

}
