package seeto.c2.artoria.us.myapplication.baseline;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import seeto.c2.artoria.us.myapplication.R;

public class SigninActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Button signin_button = findViewById(R.id.signin_main_button);
        signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
