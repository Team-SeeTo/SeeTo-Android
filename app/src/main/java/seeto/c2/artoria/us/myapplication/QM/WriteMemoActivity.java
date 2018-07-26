package seeto.c2.artoria.us.myapplication.QM;

import java.lang.*;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import seeto.c2.artoria.us.myapplication.R;

public abstract class WriteMemoActivity extends AppCompatActivity {

    EditText contentEditText = (EditText)findViewById(R.id.contentEditText);
    String sContent = contentEditText.getText().toString();

    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_writememo);
    }

    public void onButtonClick(View v){
        if(TextUtils.isEmpty(sContent)){
            Toast.makeText(this,"내용을 입력하세요",Toast.LENGTH_LONG).show();
            return;
        } else {
            Toast.makeText(this, "작성을 완료합니다.", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    public void onImageButtonClick(View v){
        AlertDialog.Builder alert_confirm = new AlertDialog.Builder(WriteMemoActivity.this);
        alert_confirm.setMessage("작성을 취소하시겠습니까?").setCancelable(false).setPositiveButton("확인",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(WriteMemoActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }).setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 'No'
                    return;
                    }
                });
        AlertDialog alert = alert_confirm.create();
        alert.show();
    }
}