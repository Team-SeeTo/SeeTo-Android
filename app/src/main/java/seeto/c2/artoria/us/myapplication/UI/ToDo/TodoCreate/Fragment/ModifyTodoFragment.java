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

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter.CreatedTodoListAdapter;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Item.TodoItem;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.SibalLom;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModifyTodoFragment extends Fragment {

    View view;
    String type, title;
    SibalLom sibalLom;

    public ModifyTodoFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_modify_todo, container, false);
        sibalLom = ViewModelProviders.of(getActivity()).get(SibalLom.class);
        title = getArguments().getString("title");
        sibalLom.getTitle().setValue(title);
        final EditText inputText = view.findViewById(R.id.modify_todo_title_edit);
        inputText.setText(title);

        TextView finish = view.findViewById(R.id.modify_finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputText.getText().toString().isEmpty()) {
                    title = inputText.getText().toString();
                    sibalLom.getTitle().setValue(title);
                    modifyTodoRequest(sibalLom);
                } else{
                    Toast.makeText(view.getContext(), "내용을 입력해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    public static ModifyTodoFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString("title", title);

        ModifyTodoFragment fragment = new ModifyTodoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    void modifyTodoRequest(SibalLom sibalLom) {
        String id = sibalLom.getId().getValue();
        String title = sibalLom.getTitle().getValue();
        String token = SharedPreferenceKt.getToken(getActivity(), true);
        Log.d("modify request", "id: "+id+" title: "+title+" token: "+token);
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("id", id)
                .putVariable("token", token)
                .putVariable("newTitle", title);
        new Connector(getActivity()).getClient().TodoEdit(queryContainerBuilder)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.d("TODO-modify", "Request-successed");
                        Log.d("TODO-modify-response", response.message());
                        getActivity().finish();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.d("TODO-modify", "Request-failed");
                    }
                });
    }

}
