package seeto.c2.artoria.us.myapplication.TimeLine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Time;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.ToDo.ToDoFragment;

public class TimeLineFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return (ViewGroup) inflater.inflate(R.layout.fragment_timeline,container,false);
    }

    public static TimeLineFragment newInstance(){
        Bundle args = new Bundle();
        TimeLineFragment fragment = new TimeLineFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
