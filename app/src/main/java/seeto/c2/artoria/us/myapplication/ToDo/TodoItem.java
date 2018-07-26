package seeto.c2.artoria.us.myapplication.ToDo;

import java.util.Date;

public class TodoItem {
    private String text;
    private Boolean isChecked;
    private Date date;

    public TodoItem(String text, Boolean isChecked){
        this.text = text;
        this.isChecked = isChecked;
    }

    public String getText() {
        return text;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }

    public void setText(String text) {
        this.text = text;
    }
}
