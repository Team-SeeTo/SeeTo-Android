package seeto.c2.artoria.us.myapplication.Store;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Model.StoreModel;
import seeto.c2.artoria.us.myapplication.R;

public class StoreFragment extends Fragment implements StoreContract.View{
    ArrayList<StoreModel> data = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.fragment_store,container,false);


        RecyclerView store_item_list = rootView.findViewById(R.id.store_recycler);

        data.add(new StoreModel("Streak Freeze","You can rest today!","3000xp"));
        data.add(new StoreModel("ToDo Bonus","double today's\ntodo point","1000xp"));
        data.add(new StoreModel("Ideas Bonus","double today's\nIdeas point","1000xp"));
        data.add(new StoreModel("Double 24","double today's\ntotal point","2000xp"));

        StoreRecyclerAdapter adapter = new StoreRecyclerAdapter(data,getActivity());
        store_item_list.setAdapter(adapter);
       return rootView;
    }
}
