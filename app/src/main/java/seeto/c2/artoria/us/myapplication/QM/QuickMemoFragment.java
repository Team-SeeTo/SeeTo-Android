package seeto.c2.artoria.us.myapplication.QM;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Ideas.IdeasFragment;

import seeto.c2.artoria.us.myapplication.R;

public class QuickMemoFragment extends Fragment implements QuickMemoContract.View{
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.fragment_quickmemo,null);

        ArrayList<Item> item=new ArrayList<>();

        item.add(new Item("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "));
        item.add(new Item("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "));
        item.add(new Item("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "));
        item.add(new Item("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "));
        item.add(new Item("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "));
        item.add(new Item("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "));
        item.add(new Item("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "));
        item.add(new Item("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "));
        item.add(new Item("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "));
        item.add(new Item("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "));

        RecyclerView myrv = (RecyclerView) rootView.findViewById(R.id.qm_recycler);
        MyAdapter myAdapter = new MyAdapter(item);
        myrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrv.setAdapter(myAdapter);

        return rootView;
    }

    public static QuickMemoFragment newInstance(){
        Bundle args = new Bundle();
        QuickMemoFragment fragment = new QuickMemoFragment();
        fragment.setArguments(args);
        return fragment;
    }


<<<<<<< HEAD
    @Override
    public void showToast(String text) {

    }
=======
>>>>>>> See-To-Android-Quick-Memo
}

