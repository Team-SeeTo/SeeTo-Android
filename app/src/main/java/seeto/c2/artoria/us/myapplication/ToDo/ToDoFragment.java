package seeto.c2.artoria.us.myapplication.ToDo;

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

import seeto.c2.artoria.us.myapplication.R;

public class ToDoFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo, container, false);

        RecyclerView todoRecyclerView;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        ArrayList<Object> data = new ArrayList<>();
        ListAdapter listAdapter = new ListAdapter(data);

        todoRecyclerView = view.findViewById(R.id.TodoList);
        todoRecyclerView.setLayoutManager(layoutManager);
        todoRecyclerView.setAdapter(listAdapter);

        data.add(new NoLimitList());
        data.add(new CommonLimitList());
        data.add(new HardLimitList());
        data.add(new NoLimitList());
        data.add(new CommonLimitList());
        data.add(new HardLimitList());

        return view;
//        return (ViewGroup) inflater.inflate(R.layout.fragment_todo,container,false);
    }


    public static ToDoFragment newInstance() {
        Bundle args = new Bundle();
        ToDoFragment fragment = new ToDoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    class NoLimitList {
        public String header;

        public NoLimitList() {
            header = "Do Something";
        }
    }

    class CommonLimitList {
        public String header, listInfo;

        public CommonLimitList() {
            header = "Do Something";
            listInfo = "3 days left, 100%";
        }
    }

    class HardLimitList {
        public String header, listInfo;

        public HardLimitList() {
            header = "Do Something";
            listInfo = "3 days left, 100%";
        }
    }


    RecyclerView todoRecyclerView;


    ArrayList<NoLimitList> data = new ArrayList<>();

}