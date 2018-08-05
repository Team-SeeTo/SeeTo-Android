package seeto.c2.artoria.us.myapplication.QM;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import seeto.c2.artoria.us.myapplication.R;

public class ViewMemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmemo);
        TextView viewmemo = (TextView)findViewById(R.id.viewMemo);
        final FloatingActionButton editfab = (FloatingActionButton) findViewById(R.id.editFab);
        final FloatingActionButton checkfab = (FloatingActionButton) findViewById(R.id.checkFab);

        editfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        checkfab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(ViewMemoActivity.this, "편집을 완료하였습니다.", Toast.LENGTH_SHORT).show();
                checkfab.setVisibility(View.INVISIBLE);
                editfab.setVisibility(View.VISIBLE);
            }
        });
    }
}