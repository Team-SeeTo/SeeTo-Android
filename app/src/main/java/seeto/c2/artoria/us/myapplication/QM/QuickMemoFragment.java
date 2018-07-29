package seeto.c2.artoria.us.myapplication.QM;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import seeto.c2.artoria.us.myapplication.Ideas.IdeasFragment;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.ToDo.ToDoFragment;

public class QuickMemoFragment extends Fragment implements QuickMemoContract.View{
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return (ViewGroup) inflater.inflate(R.layout.fragment_quickmemo,container,false);
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
