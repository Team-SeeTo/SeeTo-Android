package seeto.c2.artoria.us.myapplication.UI.Ideas;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;


import seeto.c2.artoria.us.myapplication.Adapter.IdeasRecyclerAdapter;
import seeto.c2.artoria.us.myapplication.Item.IdeasItem;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;
import seeto.c2.artoria.us.myapplication.UI.Main.MainActivity;

public class IdeasFragment extends Fragment implements IdeasContract.View {

    static boolean search;
    boolean startflag = true;
    int startrank , end;
    RecyclerView ideaslist;
    IdeasRecyclerAdapter adapter;
    ArrayList<IdeasItem> listdata = new ArrayList<>();
    IdeasPresenter ideasPresenter;
    ViewPager viewPager;
    MainActivity context;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_ideas, container, false);

        context = new MainActivity();
        ideaslist = rootView.findViewById(R.id.ideas_recycler);
        ideasPresenter = new IdeasPresenter(getActivity());
        viewPager = getActivity().findViewById(R.id.main_viewpager);

        View item_view = getLayoutInflater().inflate(R.layout.item_ideas, container, false);
        TextView rank = item_view.findViewById(R.id.item_ideas_rank_text);


        rank.bringToFront();

        if (startflag) {
//            startflag = false;
            recyclerdatainit();

            adapter = new IdeasRecyclerAdapter(listdata, getActivity());
            ideaslist.setAdapter(adapter);
        } else {
//            adapter = new IdeasRecyclerAdapter(listdata, getActivity());
//            ideaslist.setAdapter(adapter);
        }

        ideaslist.setOnScrollChangeListener((view, i, i1, i2, i3) -> {
            if (!ideaslist.canScrollVertically(1)) {

                Toast.makeText(getActivity(), "Loading ...", Toast.LENGTH_SHORT).show();

                loadMore();


            }
        });


        return rootView;
    }

    @Override
    public void recyclerdatainit() {

        if (viewPager.getCurrentItem() == 2) {
            ideasPresenter.getListDataRequest(SharedPreferenceKt.getToken(Objects.requireNonNull(getActivity()),true), "filterBy", startrank);

            listdata.clear();

            for (int i = 1; i <= 30; i++) {
                listdata.add(new IdeasItem("Title", "Body", "#" + i, "23.1K", "411"));
            }

        }

    }

    @Override
    public void loadMore() {

        ideasPresenter.getListDataRequest(SharedPreferenceKt.getToken(Objects.requireNonNull(getActivity()),true),"filterBy", startrank + 30);

        new Handler().postDelayed(() -> {

            startrank = adapter.getItemCount();
            end = startrank + 30;

            for (int i = startrank + 1; i <= end; i++){
                listdata.add(new IdeasItem("Title","Body","#"+i,"23.1K","411"));
            }

            adapter.addItemMore(listdata);

        },1000);


    }

    @Override
    public void IdeasSearchRequest(String search_string) {
        ideasPresenter.SearchRequest(SharedPreferenceKt.getToken(getActivity(),true),search_string," ",1);

    }

}
