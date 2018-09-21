
package seeto.c2.artoria.us.myapplication.UI.ToDo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


import seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter.TodoRecyclerAdapter;
import seeto.c2.artoria.us.myapplication.Item.TodoItem;
import seeto.c2.artoria.us.myapplication.Model.TodoMainModel;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoContract;


public class TodoFragment extends Fragment implements TodoContract.View {

    RecyclerView todoRecyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo, container, false);

        todoRecyclerView = view.findViewById(R.id.TodoList);
        todolistinit();

        return view;
    }


    public static TodoFragment newInstance() {
        Bundle args = new Bundle();
        TodoFragment fragment = new TodoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void todolistinit() {
        ArrayList<Object> data = new ArrayList<>();
        TodoRecyclerAdapter todoRecyclerAdapter = new TodoRecyclerAdapter(data);

        todoRecyclerView.setAdapter(todoRecyclerAdapter);

        for (int i = 0; i<3; i++){
            data.add(new NoLimitList());
            data.add(new CommonLimitList());
            data.add(new HardLimitList());
        }
    }



    //TODO: 서버 통신시 생성자 구현
    public class NoLimitList {
        public String header;
        public ArrayList<TodoItem> milestones = new ArrayList<>();
        public NoLimitList() {
            header = "Do Something";
            for(int i = 0; i<5; i++) {
                milestones.add(new TodoItem( "Something",true));
            }
        }
    }

    public class CommonLimitList {
        public String header, listInfo, color;
        public ArrayList<TodoItem> milestones = new ArrayList<>();
        public CommonLimitList() {
            header = "Do Something";
            listInfo = "3 days left, 100%";
            color = "#E846C1";
            for(int i = 0; i<5; i++) {
                milestones.add(new TodoItem( "Something",false));
            }
        }
    }

    public class HardLimitList {
        public String header, listInfo, color;
        public ArrayList<TodoItem> milestones = new ArrayList<>();
        public HardLimitList() {
            header = "Do Something";
            listInfo = "3 days left, 100%";
            color = "#2C007B";
            for(int i = 0; i<5; i++) {
                milestones.add(new TodoItem( "Something",false));
            }
        }
    }
}
