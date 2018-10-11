package seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.SibalLom;

import static seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.CreateTodoActivity.viewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetTodoTitleFragment extends Fragment {
    static String title;
    String editTodoTitle;
    Context context = getActivity();
    SibalLom sibalLom;
    public SetTodoTitleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_todo_title, container, false);
        sibalLom = ViewModelProviders.of(getActivity()).get(SibalLom.class);
        editTodoTitle = getArguments().getString("title");

        EditText editTitle = view.findViewById(R.id.set_todo_title_edit);
        if(!(editTodoTitle == null))
        {
            editTitle.setText(editTodoTitle);
            Log.d("TODO settitle: title:", editTodoTitle);
            //TODO: 널포인터 고쳐시발
        }
        editTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                title = editTitle.getText().toString();
            }
        });

        TextView nextText = view.findViewById(R.id.set_todo_title_next);
        nextText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTitle.getText().toString().isEmpty()) {
                    Toast.makeText(view.getContext(), "제목을 입력해주세요", Toast.LENGTH_SHORT).show();
                }else {
                    sibalLom.getTitle().setValue(title);
                    Log.d("TODO",sibalLom.getTitle().getValue().toString());
                    viewPager.setCurrentItem(getItem(1));
                }
            }
        });
        return view;
    }

    void setTodoTitle(String title) {

    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    public static SetTodoTitleFragment newInstance() {
        Bundle args = new Bundle();
        args.putString("title", null);

        SetTodoTitleFragment fragment = new SetTodoTitleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static SetTodoTitleFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString("title", title);

        SetTodoTitleFragment fragment = new SetTodoTitleFragment();
        fragment.setArguments(args);
        return fragment;
    }

}