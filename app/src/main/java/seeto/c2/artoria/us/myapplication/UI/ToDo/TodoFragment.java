
package seeto.c2.artoria.us.myapplication.UI.ToDo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter.TodoRecyclerAdapter;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Item.TodoItem;
import seeto.c2.artoria.us.myapplication.Model.TodoMainModel;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoContract;


public class TodoFragment extends Fragment implements TodoContract.View {

    RecyclerView todoRecyclerView;
    TodoMainModel.Todo[] todoList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo, container, false);

        todoRecyclerView = view.findViewById(R.id.TodoList);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getTodoList("created_at");
    }

    public static TodoFragment newInstance() {
        Bundle args = new Bundle();
        TodoFragment fragment = new TodoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void todolistinit() {
        ArrayList<TodoMainModel.Todo> data = new ArrayList<>(Arrays.asList(todoList));
        Log.d("TODO data size: ", ""+(data.size()));
        TodoRecyclerAdapter todoRecyclerAdapter = new TodoRecyclerAdapter(data);
        todoRecyclerView.setAdapter(todoRecyclerAdapter);
    }

    void completeTodo() {

    }

    void getTodoList(String orderBy) {
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("orderBy", orderBy)
                .putVariable("token", SharedPreferenceKt.getToken(getActivity(),true));
        new Connector(getActivity()).getClient().TodoMain(queryContainerBuilder)
                .enqueue(new Callback<TodoMainModel>() {
                    @Override
                    public void onResponse(Call<TodoMainModel> call, Response<TodoMainModel> response) {
                        TodoMainModel data = response.body();
                        TodoMainModel.Todo[] todos = data.getData().getTodos();
                        if(todos != null) {
                            todoList = todos;
                            Log.d("TODO main", todos[0].getId());
                            Log.d("TODO get request message", response.message());
                            if(todoList == null || todoList.length == 0) {
                                todoRecyclerView.setVisibility(View.GONE);
                                Log.d("TODO visible: ", "none");
                            }else {
                                todoRecyclerView.setVisibility(View.VISIBLE);
                                Log.d("TODO visible: ", "visible");
                                todolistinit();
                            }
                        }else {
                            Log.d("TODO get request failed", "todo list is null");
                        }
                    }

                    @Override
                    public void onFailure(Call<TodoMainModel> call, Throwable t) {
                        Log.d("TODO get request failed", ""+t);
                    }
                });
    }
}
