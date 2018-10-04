package seeto.c2.artoria.us.myapplication.UI.QM;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Adapter.QMRecyclerAdapter;
import seeto.c2.artoria.us.myapplication.Item.QMItem;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;

public class QuickMemoFragment extends Fragment implements QuickMemoContract.View{

    private ArrayList<QMItem> qmItem;
    QMRecyclerAdapter QMRecyclerAdapter;
    int i=0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.fragment_quickmemo,null);
        qmItem =new ArrayList<>();

        i++;
        qmItem.add(new QMItem(SharedPreferenceKt.getQM(getActivity())));

        RecyclerView myrv = (RecyclerView) rootView.findViewById(R.id.qm_recycler);
        QMRecyclerAdapter = new QMRecyclerAdapter(qmItem, getActivity().getApplicationContext());
        myrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrv.setAdapter(QMRecyclerAdapter);
        myrv.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), myrv, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), ViewMemoActivity.class);
                intent.putExtra("memo",qmItem.get(position).getPreviewText());
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        return rootView;
    }

    public static QuickMemoFragment newInstance(){
        Bundle args = new Bundle();
        QuickMemoFragment fragment = new QuickMemoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d("Debug","bbbbbbbbbbbbbbb");
        if(i>=1) {
            if(!(SharedPreferenceKt.getQM(getActivity()).equals(qmItem.get(i - 1).getPreviewText()))) {
                qmItem.add(new QMItem(SharedPreferenceKt.getQM(getActivity())));
                QMRecyclerAdapter.notifyDataSetChanged();
                Log.d("Debug","아이 : "+i);
                i++;
            }
        }
    }
}