package seeto.c2.artoria.us.myapplication.UI.Signup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;
import seeto.c2.artoria.us.myapplication.UI.Signin.SigninPresenter;

public class SignupActivity extends AppCompatActivity implements SignupContract.View {

    EditText email_et;
    EditText username_et;
    EditText password_et;
    Button button;
    SignupPresenter signupPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email_et = findViewById(R.id.signup_email_input);
        username_et = findViewById(R.id.signup_username_input);
        password_et = findViewById(R.id.signup_password_input);
        signupPresenter = new SignupPresenter(this);

        button = findViewById(R.id.signup_button);
        button.setOnClickListener(view -> {
            signupPresenter.SignupRequest(email_et.getText().toString(),
                    username_et.getText().toString(),
                    password_et.getText().toString());

//            SharedPreferenceKt.saveInfo(this,"username",username_et.getText().toString());
        });
    }

}
