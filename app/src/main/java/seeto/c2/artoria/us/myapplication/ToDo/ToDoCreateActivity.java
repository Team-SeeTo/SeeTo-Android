package seeto.c2.artoria.us.myapplication.ToDo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import seeto.c2.artoria.us.myapplication.R;

public class ToDoCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_create);

        Spinner categorySpinner = (Spinner) findViewById(R.id.spinner_category);
        ArrayAdapter categoryAdapter = ArrayAdapter.createFromResource(this,
                R.array.category , android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
    }
}
