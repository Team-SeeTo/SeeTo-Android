package seeto.c2.artoria.us.myapplication.UI.TimeLine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Adapter.TimeLineRecyclerAdapter;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.Item.TimeLineItem;

public class TimeLineFragment extends Fragment implements TImeLineContract.View {

    ArrayList<TimeLineItem> datas = new ArrayList<>();
    RecyclerView timeline_item_list;
    TimeLineRecyclerAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.fragment_timeline,container,false);

        setData();

        timeline_item_list = rootView.findViewById(R.id.timeline_recycler);
        adapter = new TimeLineRecyclerAdapter(datas,getContext());
        timeline_item_list.setAdapter(adapter);

        return rootView;
    }

    public static TimeLineFragment newInstance(){
        Bundle args = new Bundle();
        TimeLineFragment fragment = new TimeLineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setData() {
        datas.add(new TimeLineItem("Todo","0","0","0","milestones completed",
                "Todos completed", "Todos created","  0P"));

        datas.add(new TimeLineItem("Ideas","0","0","0","Ideas voted",
                "Ideas commented", "Ideas created","  0P"));

    }

}
