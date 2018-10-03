package seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

import seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter.CreatedTodoListAdapter;
import seeto.c2.artoria.us.myapplication.Item.TodoItem;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.SibalLom;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModifyTodoFragment extends Fragment {


    View view;
    SibalLom sibalLom;
    String type;
    String todoType;
    ArrayList<TodoItem> items = new ArrayList<>();
    CreatedTodoListAdapter todoListAdapter;
    RecyclerView createdTodoRecyclerView;

    public ModifyTodoFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(sibalLom.getMode().getValue().equals("Hard")) {
            type = "hard";
        } else {
            type = "normal";
        }
        Log.d("TODO type", type);
        todoListAdapter = new CreatedTodoListAdapter(items, type);
        createdTodoRecyclerView.setAdapter(todoListAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_create_todo, container, false);
        sibalLom = ViewModelProviders.of(getActivity()).get(SibalLom.class);
        todoType = getArguments().getString("todoType");

        createdTodoRecyclerView = view.findViewById(R.id.todo_modify_recycler_view);



        final EditText inputText = (EditText) ModifyTodoFragment.this.view.findViewById(R.id.modify_text);

        final TextView addMileStone = view.findViewById(R.id.modify_add_milestone);
        addMileStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newText = inputText.getText().toString();
                if (!newText.isEmpty()) {
                    addMilestone(newText);
                    inputText.setText("");
                    todoListAdapter.notifyItemInserted(todoListAdapter.getItemCount());
                } else {
                    Toast.makeText(view.getContext(), "내용을 입력해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView finish = view.findViewById(R.id.modify_finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(todoListAdapter.getItemCount()<1) {
                    Toast.makeText(view.getContext(), "마일스톤을 추가해주세요", Toast.LENGTH_SHORT).show();
                }else {
                    getActivity().finish();
                }
            }
        });

        return view;
    }

    public static CreateTodoFragment newInstance(String todoType) {

        Bundle args = new Bundle();
        args.putString("todoType", todoType);

        CreateTodoFragment fragment = new CreateTodoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    void addMilestone(String text) {
        items.add(new TodoItem(text, false));
    }

}
