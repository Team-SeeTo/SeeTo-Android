package seeto.c2.artoria.us.myapplication.UI.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import seeto.c2.artoria.us.myapplication.UI.Signin.SigninActivity;

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(Splash.this, SigninActivity.class);
        startActivity(intent);
        finish();
    }
}
