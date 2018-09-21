package seeto.c2.artoria.us.myapplication.UI.QM;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.DialogPlusBuilder;
import com.orhanobut.dialogplus.ViewHolder;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.UI.Main.MainActivity;

public class ViewMemoActivity extends AppCompatActivity {
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmemo);

        final FloatingActionButton editfab = (FloatingActionButton) findViewById(R.id.viewMemo_editFab);
        final EditText viewmemo = findViewById(R.id.qm_search_et);
        ImageButton qm_search_btn = findViewById(R.id.qm_search_btn);
        ImageView memo_search_btn = findViewById(R.id.memo_search_btn);

        qm_search_btn.setOnClickListener(v -> {
                    showQMSearchDialog();
                }
        );

        editfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("작성", "카운트: " + count);
                if (count == 0) {
                    editfab.setImageResource(R.drawable.memo_check);
                    viewmemo.setFocusableInTouchMode(true);
                    ++count;
                } else if (count == 1) {
                    --count;
                    Toast.makeText(ViewMemoActivity.this, "작성을 완료합니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ViewMemoActivity.this, MainActivity.class)
                            .putExtra("Memo", true);
                    startActivity(intent);
                    viewmemo.setFocusableInTouchMode(false);
                }
            }
        });
    }

    private void showQMSearchDialog() {
        DialogPlus QMdialogPlus = DialogPlus.newDialog(this)
                .setContentHolder(new ViewHolder(R.layout.memo_search))
                .setGravity(Gravity.TOP)
                .setCancelable(true)
                .create();

        EditText memo_search_et = (EditText) QMdialogPlus.findViewById(R.id.memo_search_et);
        ImageView memo_search_btn = (ImageView) QMdialogPlus.findViewById(R.id.memo_search_btn);
        QMdialogPlus.show();

        memo_search_btn.setOnClickListener(v -> {
            if (memo_search_et.getText().toString().isEmpty()) {
                Toast.makeText(ViewMemoActivity.this, "내용을 입력하세요", Toast.LENGTH_SHORT).show();
            } else {
                for (int i = 0; i < memo_search_et.getText().toString().length(); i++) {
                    if (memo_search_et.getText().toString().equals("")) {

                    }
                    else {
                        Toast.makeText(ViewMemoActivity.this, "해당 단어를 찾을 수 없습니다", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        memo_search_et.setFocusableInTouchMode(true);
        memo_search_et.requestFocus();
    }
}