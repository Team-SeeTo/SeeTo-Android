package seeto.c2.artoria.us.myapplication.UI.Signin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.Query;

import seeto.c2.artoria.us.myapplication.UI.Main.MainActivity;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.UI.Signup.SignupActivity;

public class SigninActivity extends AppCompatActivity implements SigninContract.View {

    EditText id_et, password_et;
    SigninPresenter signinPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        id_et = findViewById(R.id.signin_id_input);
        password_et = findViewById(R.id.signin_password_input);
        signinPresenter = new SigninPresenter(this);

        Button signin_button = findViewById(R.id.signin_main_button);
        signin_button.setOnClickListener(v -> {

            signinPresenter.SigninRequest(id_et.getText().toString(),password_et.getText().toString());

        });

        
        TextView signup_button = findViewById(R.id.signin_signup_button);
        signup_button.setOnClickListener(v -> {
            Intent intent = new Intent(SigninActivity.this,SignupActivity.class);
            startActivity(intent);
        });
    }


}
