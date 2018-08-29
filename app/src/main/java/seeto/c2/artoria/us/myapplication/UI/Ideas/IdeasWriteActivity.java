package seeto.c2.artoria.us.myapplication.UI.Ideas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import seeto.c2.artoria.us.myapplication.R;

public class IdeasWriteActivity extends AppCompatActivity{

    EditText ideas_write_title_et;
    EditText ideas_write_content_et;
    TextView ideas_write_finish_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideaswrite);

        ideas_write_title_et = findViewById(R.id.ideas_wirte_title_et);
        ideas_write_content_et = findViewById(R.id.ideas_write_content_et);
        ideas_write_finish_btn = findViewById(R.id.ideas_write_fin_btn);

        ideas_write_finish_btn.setOnClickListener(view -> {
            if(ideas_write_title_et.getText().toString().isEmpty() || ideas_write_content_et.getText().toString().isEmpty()){
                Toast.makeText(this, "내용을 입력해주세요.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "작성이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
