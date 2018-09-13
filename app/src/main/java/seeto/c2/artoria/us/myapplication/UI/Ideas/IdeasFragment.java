package seeto.c2.artoria.us.myapplication.UI.Ideas;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Adapter.IdeasListAdapter;
import seeto.c2.artoria.us.myapplication.Adapter.IdeasRecyclerAdapter;
import seeto.c2.artoria.us.myapplication.Item.IdeasItem;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;

public class IdeasFragment extends Fragment implements IdeasContract.View {

    boolean startflag = true;
    int startrank = 1;
    RecyclerView ideaslist;
    IdeasRecyclerAdapter adapter;
    ArrayList<IdeasItem> listdata = new ArrayList<>();
    IdeasPresenter ideasPresenter = new IdeasPresenter(getActivity());

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_ideas,container,false);

        ideaslist = rootView.findViewById(R.id.ideas_recycler);

        View item_view = getLayoutInflater().inflate(R.layout.item_ideas,container,false);
        TextView rank = item_view.findViewById(R.id.item_ideas_rank_text);


        rank.bringToFront();

        int startrank = 0;

        if(startflag) {
//            startflag = false;
            recyclerdatainit();

            adapter = new IdeasRecyclerAdapter(listdata, getActivity());
            ideaslist.setAdapter(adapter);
        }

        ideaslist.setOnScrollChangeListener((view, i, i1, i2, i3) -> {
            if (!ideaslist.canScrollVertically(1)){

                Toast.makeText(getActivity(), "Loading ...", Toast.LENGTH_SHORT).show();

                loadMore();
//
//                adapter = new IdeasRecyclerAdapter(listdata,getActivity());
//                ideaslist.setAdapter(adapter);
            }
        });


        return rootView;
    }

    public static IdeasFragment newInstance(){
        Bundle args = new Bundle();
        IdeasFragment fragment = new IdeasFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void recyclerdatainit() {

//        ideasPresenter.getListDataRequest(SharedPreferenceKt.getToken(getActivity(),true),"filterBy", String.valueOf(startrank));

        for (int i = 1; i<15; i++){
            listdata.add(new IdeasItem("Title here","Category here","#"+i,"23.1K","411"));
        }


    }

    @Override
    public void loadMore() {
//         ideasPresenter.getListDataRequest(SharedPreferenceKt.getToken(getActivity(),true),"filterBy", String.valueOf(startrank + 20));

        for (int i = 1; i<15; i++){
            listdata.add(new IdeasItem("Title here","Category here","#"+i,"23.1K","411"));
        }


    }

    @Override
    public void showToast(String text) {

    }
}
