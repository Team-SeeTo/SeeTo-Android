package seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter.CreatedTodoListAdapter;
import seeto.c2.artoria.us.myapplication.Item.TodoItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateTodoFragment extends Fragment {

    View view;

    ArrayList<TodoItem> items = new ArrayList<>();

    public CreateTodoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_create_todo, container, false);

        RecyclerView createdTodoRecyclerView;
        createdTodoRecyclerView = view.findViewById(R.id.todo_create_recycler_view);

        final CreatedTodoListAdapter todoListAdapter = new CreatedTodoListAdapter(items);
        createdTodoRecyclerView.setAdapter(todoListAdapter);

        final EditText inputText = (EditText) CreateTodoFragment.this.view.findViewById(R.id.new_text);

        final TextView addMileStone = view.findViewById(R.id.add_milestone);
        addMileStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newText = inputText.getText().toString();
                Log.e("clicked", "newText: " + newText);
                if (!newText.isEmpty()) {
                    addMilestone(newText);
                    inputText.setText("");
                    todoListAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(view.getContext(), "내용을 입력해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView finish = view.findViewById(R.id.todo_finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        return view;
    }

    public static CreateTodoFragment newInstance() {

        Bundle args = new Bundle();

        CreateTodoFragment fragment = new CreateTodoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    void addMilestone(String text) {
        items.add(new TodoItem(text, false));
    }
}
