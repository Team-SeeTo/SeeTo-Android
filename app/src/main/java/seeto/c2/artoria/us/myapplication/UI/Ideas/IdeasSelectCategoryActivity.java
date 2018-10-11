package seeto.c2.artoria.us.myapplication.UI.Ideas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.ScrollingTabContainerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import seeto.c2.artoria.us.myapplication.R;



public class IdeasSelectCategoryActivity extends AppCompatActivity {

    TextView next_btn;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_categoty_newidea);

        next_btn = findViewById(R.id.newidea_category_next);

        String[] categoryList = {
                "IT", "Life", "Food"
        };

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                categoryList
        );


        MaterialBetterSpinner materialBetterSpinner;

        materialBetterSpinner = findViewById(R.id.newidea_category_spinner);
        materialBetterSpinner.setAdapter(categoryAdapter);
        materialBetterSpinner.setText(categoryAdapter.getItem(0).toString());
        materialBetterSpinner.setTextSize(20);

        next_btn.setOnClickListener(v -> {
            Intent intent = new Intent(IdeasSelectCategoryActivity.this, IdeasWriteActivity.class);
            intent.putExtra("category",materialBetterSpinner.getText().toString());
            startActivity(intent);
            finish();
        });

        TextView nextText = (TextView) findViewById(R.id.newidea_category_next);


    }

}
