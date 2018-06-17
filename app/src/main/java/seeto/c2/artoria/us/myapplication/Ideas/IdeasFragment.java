package seeto.c2.artoria.us.myapplication.Ideas;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.ToDo.ToDoFragment;

public class IdeasFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return (ViewGroup) inflater.inflate(R.layout.fragment_ideas,container,false);
    }

    public static IdeasFragment newInstance(){
        Bundle args = new Bundle();
        IdeasFragment fragment = new IdeasFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
