package seeto.c2.artoria.us.myapplication.UI.QM;

import java.lang.*;
import java.util.ArrayList;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;
import seeto.c2.artoria.us.myapplication.UI.Main.MainActivity;

public class WriteMemoActivity extends AppCompatActivity {

    EditText contentEditText;
    String sContent;
    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_writememo);

        contentEditText = (EditText) findViewById(R.id.contentEditText);
        Button btn_finish = (Button)findViewById(R.id.finishButton);
        ImageButton btn_cancel = (ImageButton)findViewById(R.id.xIcon);

        btn_finish.setOnClickListener(v -> {
            if(contentEditText.getText().toString().isEmpty()){
                Toast.makeText(WriteMemoActivity.this,"내용을 입력하세요",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(WriteMemoActivity.this, "작성을 완료합니다.", Toast.LENGTH_SHORT).show();
                SharedPreferenceKt.saveQM(WriteMemoActivity.this,contentEditText.getText().toString());
                finish();
            }
        });

        btn_cancel.setOnClickListener(v -> {
            AlertDialog.Builder alert_confirm = new AlertDialog.Builder(WriteMemoActivity.this);
            alert_confirm.setMessage("작성을 취소하시겠습니까?").setCancelable(false).setPositiveButton("확인",
                    (dialog, which) -> {

                finish();
//                                Intent intent = new Intent(WriteMemoActivity.this, ViewMemoActivity.class);
//                                startActivity(intent);

                        Intent intent = new Intent(WriteMemoActivity.this, ViewMemoActivity.class);
                        startActivity(intent);

                    }).setNegativeButton("취소",
                    (dialog, which) -> {
                        // 'No'
                        return;
                    });
            AlertDialog alert = alert_confirm.create();
            alert.show();
        });
    }
}