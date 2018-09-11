package seeto.c2.artoria.us.myapplication.UI.QM;

<<<<<<< HEAD:app/src/main/java/seeto/c2/artoria/us/myapplication/QM/ViewMemoActivity.java
import android.app.Fragment;
=======
>>>>>>> master:app/src/main/java/seeto/c2/artoria/us/myapplication/UI/QM/ViewMemoActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
<<<<<<< HEAD:app/src/main/java/seeto/c2/artoria/us/myapplication/QM/ViewMemoActivity.java
import android.widget.Toast;

import seeto.c2.artoria.us.myapplication.MainActivity;
=======

>>>>>>> master:app/src/main/java/seeto/c2/artoria/us/myapplication/UI/QM/ViewMemoActivity.java
import seeto.c2.artoria.us.myapplication.R;

public class ViewMemoActivity extends AppCompatActivity {
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmemo);

        final FloatingActionButton editfab = (FloatingActionButton) findViewById(R.id.viewMemo_editFab);
        ImageButton searchbtn = findViewById(R.id.search_btn);
        final EditText searchbar = findViewById(R.id.search_bar);
        final EditText viewmemo = findViewById(R.id.viewMemo);

        editfab.bringToFront();

<<<<<<< HEAD:app/src/main/java/seeto/c2/artoria/us/myapplication/QM/ViewMemoActivity.java
        editfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("작성", "카운트: "+count);
                if(count == 0) {
                    editfab.setImageResource(R.drawable.memo_check);
                    // textview to edittext focusableInTouchMode
                    viewmemo.setFocusableInTouchMode(true);
                    ++count;
                }else if (count == 1){
                    --count;
                    Toast.makeText(ViewMemoActivity.this, "작성을 완료합니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ViewMemoActivity.this, MainActivity.class);
                    viewmemo.setFocusableInTouchMode(false);

                }
            }
=======
        editfab.setOnClickListener(v -> {
            Intent intent = new Intent(ViewMemoActivity.this, WriteMemoActivity.class);
            startActivity(intent);

//                Intent intent = new Intent(ViewMemoActivity.this, WriteMemoActivity.class);
//                ViewMemoActivity.this.startActivity(intent);
>>>>>>> master:app/src/main/java/seeto/c2/artoria/us/myapplication/UI/QM/ViewMemoActivity.java
        });

        findViewById(R.id.search_btn).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(ViewMemoActivity.this, "검색하기" , Toast.LENGTH_SHORT).show();
                        searchbar.setVisibility(searchbar.VISIBLE);

                        if(searchbar.getText().toString().isEmpty()){
                            Toast.makeText(ViewMemoActivity.this,"내용을 입력하세요",Toast.LENGTH_SHORT).show();
                        } else {
                            if(searchbar.getText().toString().equals("")){
                                //문자열 비교
                            }
                            else{
                                Toast.makeText(ViewMemoActivity.this,"해당 단어를 찾을 수 없습니다",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
        );
    }
}