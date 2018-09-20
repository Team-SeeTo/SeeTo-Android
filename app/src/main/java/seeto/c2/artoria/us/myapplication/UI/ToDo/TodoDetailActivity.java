package seeto.c2.artoria.us.myapplication.UI.ToDo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter.CreatedTodoListAdapter;
import seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter.TodoDetailRecyclerAdapter;
import seeto.c2.artoria.us.myapplication.Item.TodoItem;
import seeto.c2.artoria.us.myapplication.R;

public class TodoDetailActivity extends Activity {
    String title;
    ArrayList<TodoItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        items = getIntent().getExtras().getParcelableArrayList("milestones");
        String type = "normal";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);

        RecyclerView TodoDetailRecyclerView;

        TodoDetailRecyclerView = findViewById(R.id.todo_detail_recycler);
        TodoDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        final TodoDetailRecyclerAdapter todoListAdapter = new TodoDetailRecyclerAdapter(items, type);
        TodoDetailRecyclerView.setAdapter(todoListAdapter);
    }
}
