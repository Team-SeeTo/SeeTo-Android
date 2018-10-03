package seeto.c2.artoria.us.myapplication.UI.QM;

import android.content.SharedPreferences;
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

import seeto.c2.artoria.us.myapplication.Adapter.QMRecyclerAdapter;
import seeto.c2.artoria.us.myapplication.Item.QMItem;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;

public class QuickMemoFragment extends Fragment implements QuickMemoContract.View{

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.fragment_quickmemo,null);

        ArrayList<QMItem> qmItem =new ArrayList<>();

        qmItem.add(new QMItem(SharedPreferenceKt.getQM(getActivity())));

        RecyclerView myrv = (RecyclerView) rootView.findViewById(R.id.qm_recycler);
        QMRecyclerAdapter QMRecyclerAdapter = new QMRecyclerAdapter(qmItem, getActivity().getApplicationContext());
        myrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrv.setAdapter(QMRecyclerAdapter);

        return rootView;
    }

    public static QuickMemoFragment newInstance(){
        Bundle args = new Bundle();
        QuickMemoFragment fragment = new QuickMemoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void showToast(String text) {

    }
}