package seeto.c2.artoria.us.myapplication.UI.Signin_Signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import seeto.c2.artoria.us.myapplication.R;

public class SignupActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        button = findViewById(R.id.signup_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this,SigninActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
