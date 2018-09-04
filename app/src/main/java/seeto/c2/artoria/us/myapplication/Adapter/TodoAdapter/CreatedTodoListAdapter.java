package seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.Item.TodoItem;

public class CreatedTodoListAdapter extends RecyclerView.Adapter<CreatedTodoListAdapter.CustomViewholder>{
    ArrayList<TodoItem> todoItems;

    public CreatedTodoListAdapter(ArrayList<TodoItem> todoItems){
        this.todoItems = todoItems;
    }


    @Override
    public CustomViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_created_todo,parent,false);
        return new CustomViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewholder holder, int position) {
        holder.todoText.setText(todoItems.get(position).getText());
        holder.todoCheckBox.setChecked(todoItems.get(position).getChecked());

        holder.deleteTodo.setOnClickListener((v) ->{
            todoItems.remove(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return todoItems.size();
    }

    class CustomViewholder extends RecyclerView.ViewHolder{
        private EditText todoText;
        private CheckBox todoCheckBox;
        private ImageView deleteTodo;

        public CustomViewholder(View itemView) {
            super(itemView);
            todoText = itemView.findViewById(R.id.todo_text);
            todoCheckBox = itemView.findViewById(R.id.todo_check_box);
            deleteTodo = itemView.findViewById(R.id.deleteTodo);
        }
    }
}
