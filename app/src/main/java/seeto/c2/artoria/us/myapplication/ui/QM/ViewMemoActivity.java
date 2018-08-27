package seeto.c2.artoria.us.myapplication.ui.QM;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import seeto.c2.artoria.us.myapplication.R;

public class ViewMemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmemo);

        final FloatingActionButton editfab = (FloatingActionButton) findViewById(R.id.viewMemo_editFab);
        ImageButton searchbtn = findViewById(R.id.search_btn);

        editfab.bringToFront();

        editfab.setOnClickListener(v -> {
            Intent intent = new Intent(ViewMemoActivity.this, WriteMemoActivity.class);
            startActivity(intent);

//                Intent intent = new Intent(ViewMemoActivity.this, WriteMemoActivity.class);
//                ViewMemoActivity.this.startActivity(intent);
        });
    }
}