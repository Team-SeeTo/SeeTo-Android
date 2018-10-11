
package seeto.c2.artoria.us.myapplication.Item;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.Date;

import seeto.c2.artoria.us.myapplication.Model.TodoMainModel;

public class TodoItem implements Parcelable{
    private String text;
    public String milestoneId;
    private Boolean isChecked;

    public TodoItem(String text, Boolean isChecked, String milestoneId){
        this.text = text;
        this.isChecked = isChecked;
        this.milestoneId = milestoneId;
        Log.d("TODO item", milestoneId);
    }

    protected TodoItem(Parcel in) {
        text = in.readString();
        milestoneId = in.readString();
        byte tmpIsChecked = in.readByte();
        isChecked = tmpIsChecked == 0 ? null : tmpIsChecked == 1;
    }

    public static final Creator<TodoItem> CREATOR = new Creator<TodoItem>() {
        @Override
        public TodoItem createFromParcel(Parcel in) {
            return new TodoItem(in);
        }

        @Override
        public TodoItem[] newArray(int size) {
            return new TodoItem[size];
        }
    };

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

    public String getMilestoneId() {
        return milestoneId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(milestoneId);
        dest.writeByte((byte) (isChecked == null ? 0 : isChecked ? 1 : 2));
    }
}