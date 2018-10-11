package seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter.CreateNewTodoListAdapter;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.SibalLom;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateTodoFragment extends Fragment {

    View view;
    SibalLom sibalLom;
    String type;
    String todoType;
    ArrayList<String> items = new ArrayList<>();
    CreateNewTodoListAdapter todoListAdapter;
    RecyclerView createdTodoRecyclerView;
    String[] stringfiedItems;

    public CreateTodoFragment() {
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
        todoListAdapter = new CreateNewTodoListAdapter(items, type);
        createdTodoRecyclerView.setAdapter(todoListAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_create_todo, container, false);
        sibalLom = ViewModelProviders.of(getActivity()).get(SibalLom.class);
        sibalLom.setMilestone(items);

        createdTodoRecyclerView = view.findViewById(R.id.todo_create_recycler_view);

        final EditText inputText = (EditText) CreateTodoFragment.this.view.findViewById(R.id.new_text);

        final TextView addMileStone = view.findViewById(R.id.add_milestone);
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

        TextView finish = view.findViewById(R.id.todo_finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(todoListAdapter.getItemCount()<1) {
                    Toast.makeText(view.getContext(), "마일스톤을 추가해주세요", Toast.LENGTH_SHORT).show();
                }else {
                    stringfiedItems = new String[sibalLom.getMilestone().getValue().size()];
                    int index = 0;
                    for(String app: sibalLom.getMilestone().getValue()) {
                        stringfiedItems[index] = app;
                        index++;
                    }
                    createTodoRequest(sibalLom);
                }
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
        items.add(text);
    }

    void createTodoRequest(SibalLom sibalLom) {
        Log.d("string", stringfiedItems[0]);
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("title", sibalLom.getTitle().getValue())
                .putVariable("milestones", stringfiedItems)
                .putVariable("type", sibalLom.getMode().getValue())
                .putVariable("expiration", sibalLom.getExpiration().getValue())
                .putVariable("token", SharedPreferenceKt.getToken(getActivity(),true));
        Log.d("TODO stones", stringfiedItems[0]);
        new Connector(getActivity()).getClient().NewTODO(queryContainerBuilder)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.d("TODO-create", "Request-successed");
                        Log.d("TODO-response", response.message());
                        getActivity().finish();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.d("TODO-create", "Request-failed");
                    }
                });
    }

}
