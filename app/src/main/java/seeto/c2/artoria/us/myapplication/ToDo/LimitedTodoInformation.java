package seeto.c2.artoria.us.myapplication.ToDo;

import android.support.annotation.Nullable;

import java.util.Date;

public class LimitedTodoInformation extends UnLimitedTodoInformation {

    private Date limiteday;

    public Date getLimiteday() {
        return limiteday;
    }

    public void setLimiteday(Date limiteday) {
        this.limiteday = limiteday;
    }
}
