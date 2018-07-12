package seeto.c2.artoria.us.myapplication.Ideas;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Ideas.IdeasRecyclerAdapter.IdeasRecyclerAdapter;
import seeto.c2.artoria.us.myapplication.baseline.baseline.Item.IdeasItem;
import seeto.c2.artoria.us.myapplication.R;

public class IdeasFragment extends Fragment implements IdeasContract.View {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_ideas,container,false);

        View item_view = getLayoutInflater().inflate(R.layout.item_ideas,container,false);
        TextView rank = item_view.findViewById(R.id.item_ideas_rank_text);
        RecyclerView ideaslist = rootView.findViewById(R.id.ideas_recycler);
        ArrayList<IdeasItem> listdata = new ArrayList<>();
        IdeasRecyclerAdapter adapter = new IdeasRecyclerAdapter(listdata,getActivity());

        rank.bringToFront();

        for (int i = 0; i<15; i++){
           listdata.add(new IdeasItem("Title here","Category here","#"+i,"23.1K","411"));
        }

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
