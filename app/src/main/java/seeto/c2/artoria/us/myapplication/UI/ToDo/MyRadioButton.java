package seeto.c2.artoria.us.myapplication.UI.ToDo;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;

public class MyRadioButton extends android.support.v7.widget.AppCompatRadioButton{

    private Context context;

    public MyRadioButton(Context context) {
        super(context);
         this.context = context;
    }

    public MyRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public MyRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    public void toggle() {
        if (isChecked()) {
            setChecked(false);
        } else {
            setChecked(true);
            //TODO: 알람음 설정
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(this.context, notification);
            r.play();
            Log.d("toggle","error");
        }
    }
}
