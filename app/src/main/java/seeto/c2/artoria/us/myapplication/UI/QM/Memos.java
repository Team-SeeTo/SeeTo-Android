package seeto.c2.artoria.us.myapplication.UI.QM;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Memos implements Parcelable {
    private ArrayList<String> memos;

    protected Memos(Parcel in) {
        memos = in.createStringArrayList();
    }

    public static final Creator<Memos> CREATOR = new Creator<Memos>() {
        @Override
        public Memos createFromParcel(Parcel in) {
            return new Memos(in);
        }

        @Override
        public Memos[] newArray(int size) {
            return new Memos[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(memos);
    }

    public ArrayList<String> getMemos() {
        return memos;
    }

    public void setMemos(ArrayList<String> memos) {
        this.memos = memos;
    }
}
