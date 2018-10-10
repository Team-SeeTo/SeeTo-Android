package seeto.c2.artoria.us.myapplication.UI.Store;

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

import seeto.c2.artoria.us.myapplication.Adapter.StoreRecyclerAdapter;
import seeto.c2.artoria.us.myapplication.Item.StoreItem;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;

public class StoreFragment extends Fragment implements StoreContract.View{
    ArrayList<StoreItem> data = new ArrayList<>();
    RecyclerView store_item_list;
    StoreRecyclerAdapter adapter;
    TextView point;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.fragment_store,container,false);

        store_item_list = rootView.findViewById(R.id.store_recycler);

        listinit();

       return rootView;
    }


    @Override
    public void tabsinit() {

    }

    @Override
    public void listinit() {
        data.add(new StoreItem("Streak Freeze","You can rest today!","3000xp"));
        data.add(new StoreItem("ToDo Bonus","double today's\ntodo point","1000xp"));
        data.add(new StoreItem("Ideas Bonus","double today's\nIdeas point","1000xp"));
        data.add(new StoreItem("Double 24","double today's\ntotal point","2000xp"));

        adapter = new StoreRecyclerAdapter(data,getActivity());
        store_item_list.setAdapter(adapter);
    }
}
