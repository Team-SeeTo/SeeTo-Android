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
    String title, expiration;
    ArrayList<TodoItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);

        items = getIntent().getExtras().getParcelableArrayList("milestones");
        expiration = getIntent().getExtras().getString("expiration");
        String gotType = getIntent().getExtras().getString("type");
        if(gotType==null) gotType = "STANDARD";
        String title = getIntent().getExtras().getString("title");
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

        TextView titleText = findViewById(R.id.todo_detail_title);
        titleText.setText(title);

        TodoDetailRecyclerView = findViewById(R.id.todo_detail_recycler);
        TodoDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        final TodoDetailRecyclerAdapter todoListAdapter = new TodoDetailRecyclerAdapter(items, type);
        TodoDetailRecyclerView.setAdapter(todoListAdapter);
    }
}
