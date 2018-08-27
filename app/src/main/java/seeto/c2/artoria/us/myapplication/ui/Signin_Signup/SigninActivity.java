package seeto.c2.artoria.us.myapplication.ui.Signin_Signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import seeto.c2.artoria.us.myapplication.ui.Main.MainActivity;
import seeto.c2.artoria.us.myapplication.R;

public class SigninActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Button signin_button = findViewById(R.id.signin_main_button);
        signin_button.setOnClickListener(v -> {
            Intent intent = new Intent(SigninActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        });

        TextView signup_button = findViewById(R.id.signin_signup_button);
        signup_button.setOnClickListener(v -> {
            Intent intent = new Intent(SigninActivity.this,SignupActivity.class);
            startActivity(intent);
        });
    }
}
