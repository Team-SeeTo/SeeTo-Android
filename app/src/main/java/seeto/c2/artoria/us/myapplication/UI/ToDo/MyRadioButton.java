package seeto.c2.artoria.us.myapplication.UI.ToDo;

import android.content.Context;
import android.util.AttributeSet;

public class MyRadioButton extends android.support.v7.widget.AppCompatRadioButton{

    public MyRadioButton(Context context) {
        super(context);
    }

    public MyRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void toggle() {
        if (isChecked()) {
            setChecked(false);
        } else {
            setChecked(true);
        }
    }
}
