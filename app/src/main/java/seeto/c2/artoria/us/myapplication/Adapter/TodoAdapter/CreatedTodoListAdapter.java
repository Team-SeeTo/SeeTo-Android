package seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.Item.TodoItem;

public class CreatedTodoListAdapter extends RecyclerView.Adapter<CreatedTodoListAdapter.CustomViewholder> {
    ArrayList<TodoItem> todoItems;
    String type = "normal";

    public CreatedTodoListAdapter(ArrayList<TodoItem> todoItems, String type) {
        this.todoItems = todoItems;
        this.type = type;
        Log.d("CreatedTodoLostAdapter", "Todo Type: " + this.type);
    }


    @Override
    public CustomViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int res;
        switch (type) {
            case "normal":
                res = R.layout.item_created_normal_todo;
                break;
            case "hard":
                res = R.layout.item_created_hard_todo;
                break;
            default:
                res = R.layout.item_created_normal_todo;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(res, parent, false);
        return new CustomViewholder(view, type);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull CustomViewholder holder, int position) {
        holder.todoText.setText(todoItems.get(position).getText());
        holder.todoCheckBox.setChecked(todoItems.get(position).getChecked());

        if (holder.todoCheckBox.isChecked()) {
            switch (type) {
                case "normal":
                    holder.todoText.setTextColor(R.color.stdComplete);
                    break;
                case "hard":
                    holder.todoText.setTextColor(R.color.hardComplete);
            }
            todoItems.get(holder.getAdapterPosition()).setChecked(true);
        } else {
            holder.todoText.setTextColor(Color.BLACK);
            todoItems.get(holder.getAdapterPosition()).setChecked(false);
        }

        holder.todoCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switch (type) {
                        case "normal":
                            holder.todoText.setTextColor(R.color.stdComplete);
                            break;
                        case "hard":
                            holder.todoText.setTextColor(R.color.hardComplete);
                    }
                    todoItems.get(holder.getAdapterPosition()).setChecked(true);
                } else {
                    holder.todoText.setTextColor(Color.BLACK);
                    todoItems.get(holder.getAdapterPosition()).setChecked(false);
                }
            }
        });

        holder.todoText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String curText = s.toString();
                todoItems.get(holder.getAdapterPosition()).setText(curText);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        holder.deleteTodo.setOnClickListener((v) -> {
            todoItems.remove(holder.getAdapterPosition());
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return todoItems.size();
    }

    class CustomViewholder extends RecyclerView.ViewHolder {
        private EditText todoText;
        private CheckBox todoCheckBox;
        private ImageView deleteTodo;

        public CustomViewholder(View itemView, String type) {
            super(itemView);

            switch (type) {
                case "normal":
                    todoText = itemView.findViewById(R.id.todo_created_normal_text);
                    todoCheckBox = itemView.findViewById(R.id.todo_created_normal_check_box);
                    deleteTodo = itemView.findViewById(R.id.todo_created_normal_delete_todo);
                case "hard":
                    todoText = itemView.findViewById(R.id.todo_created_hard_text);
                    todoCheckBox = itemView.findViewById(R.id.todo_created_hard_check_box);
                    deleteTodo = itemView.findViewById(R.id.todo_created_hard_delete_todo);
                default:
                    todoText = itemView.findViewById(R.id.todo_created_normal_text);
                    todoCheckBox = itemView.findViewById(R.id.todo_created_normal_check_box);
                    deleteTodo = itemView.findViewById(R.id.todo_created_normal_delete_todo);
            }
        }
    }
}
