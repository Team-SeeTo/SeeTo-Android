package seeto.c2.artoria.us.myapplication.UI.Setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import seeto.c2.artoria.us.myapplication.R;

public class SettingActivity extends AppCompatActivity implements SettingContract.View{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

    }


}
