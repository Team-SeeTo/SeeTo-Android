package seeto.c2.artoria.us.myapplication.QM;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import seeto.c2.artoria.us.myapplication.R;

public class Memo_Activity extends AppCompatActivity{

    private TextView previewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmemo);

        previewText = (TextView)findViewById(R.id.previewText);

        Intent intent = getIntent();
        String previewText = intent.getExtras().getString("Content");

    }

}
