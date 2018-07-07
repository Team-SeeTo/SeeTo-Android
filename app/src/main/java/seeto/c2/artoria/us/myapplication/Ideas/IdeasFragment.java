package seeto.c2.artoria.us.myapplication.Ideas;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Ideas.IdeasRecyclerAdapter.IdeasRecyclerAdapter;
import seeto.c2.artoria.us.myapplication.Model.IdeasModel;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.ToDo.ToDoFragment;

public class IdeasFragment extends Fragment implements IdeasContract.View {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_ideas,container,false);

        ArrayList<IdeasModel> listdata = new ArrayList<>();

        for (int i = 0; i<15; i++){
           listdata.add(new IdeasModel("title","category","rank","1","1"));
        }

        RecyclerView ideaslist = rootView.findViewById(R.id.ideas_recycler);
        IdeasRecyclerAdapter adapter = new IdeasRecyclerAdapter(listdata,getActivity());
        ideaslist.setAdapter(adapter);

        return rootView;
    }

    public static IdeasFragment newInstance(){
        Bundle args = new Bundle();
        IdeasFragment fragment = new IdeasFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
