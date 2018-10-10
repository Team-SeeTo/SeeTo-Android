package seeto.c2.artoria.us.myapplication.UI.ToDo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.CreateTodoActivity;

public class TodoDetailActivity extends Activity {
    String title, expiration, id, gotType;
    ArrayList<TodoItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);

        items = getIntent().getExtras().getParcelableArrayList("milestones");
        expiration = getIntent().getExtras().getString("expiration");
        gotType = getIntent().getExtras().getString("type");
        title = getIntent().getExtras().getString("title");
        id = getIntent().getExtras().getString("id");
        if(gotType==null) gotType = "STANDARD";

        Log.d("TODO detail expiration: ", expiration);
        String type;
        switch(gotType) {
            case "HARD":
                type = "hard";
                break;
            case "STANDARD":
            case "INFINITY":
                type = "normal";
                break;
            default:
                type = "normal";
        }

        RecyclerView TodoDetailRecyclerView;
        TextView expirationText = findViewById(R.id.todo_detail_expiration);
        expirationText.setText(expiration);

        FloatingActionButton modifyBtn = findViewById(R.id.todo_detail_modify_btn);
        modifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TodoDetailActivity.this, CreateTodoActivity.class);
                intent.putExtra("editTodoType", "modify");
                intent.putExtra("id", id);
                intent.putExtra("title", title);
                intent.putExtra("mode", gotType);
                intent.putExtra("expiration", expiration);
                intent.putExtra("items", items);
                startActivity(intent);
            }
        });

        TextView titleText = findViewById(R.id.todo_detail_title);
        titleText.setText(title);

        TodoDetailRecyclerView = findViewById(R.id.todo_detail_recycler);
        TodoDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        final TodoDetailRecyclerAdapter todoListAdapter = new TodoDetailRecyclerAdapter(items, type, id);
        TodoDetailRecyclerView.setAdapter(todoListAdapter);
    }
}
