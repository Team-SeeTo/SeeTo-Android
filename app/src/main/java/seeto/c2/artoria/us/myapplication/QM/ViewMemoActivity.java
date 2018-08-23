package seeto.c2.artoria.us.myapplication.QM;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import seeto.c2.artoria.us.myapplication.R;

public class ViewMemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmemo);

        final FloatingActionButton editfab = (FloatingActionButton) findViewById(R.id.viewMemo_editFab);
        ImageButton searchbtn = findViewById(R.id.search_btn);

        editfab.bringToFront();

        editfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewMemoActivity.this, WriteMemoActivity.class);
                startActivity(intent);
//                Intent intent = new Intent(ViewMemoActivity.this, WriteMemoActivity.class);
//                ViewMemoActivity.this.startActivity(intent);
            }
        });
    }
}