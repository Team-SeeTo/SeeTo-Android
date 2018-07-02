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
        View view = inflater.inflate(R.layout.fragment_todo,container,false);

        RecyclerView todoRecyclerView;
        LinearLayoutManager layoutManager= new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        ArrayList<TodoList> data = new ArrayList<>();
        ListAdapter listAdapter = new ListAdapter(data);

        todoRecyclerView = view.findViewById(R.id.TodoList);
        todoRecyclerView.setLayoutManager(layoutManager);
        todoRecyclerView.setAdapter(listAdapter);

        data.add(new TodoList());
        data.add(new TodoList());
        data.add(new TodoList());
        data.add(new TodoList());
        data.add(new TodoList());
        data.add(new TodoList());


        return view;
//        return (ViewGroup) inflater.inflate(R.layout.fragment_todo,container,false);
    }


    public static ToDoFragment newInstance(){
        Bundle args = new Bundle();
        ToDoFragment fragment = new ToDoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    class TodoList {
        public String header;

        public TodoList() {
            header = "Do Something";
        }
    }

    RecyclerView todoRecyclerView;


    ArrayList<TodoList> data = new ArrayList<>();

}
