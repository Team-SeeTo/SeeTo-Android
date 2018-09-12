package seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import seeto.c2.artoria.us.myapplication.R;

import static seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.CreateTodoActivity.viewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectDueDateFragment extends Fragment {

    public SelectDueDateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_select_due_date, container, false);

        TextView nextText = (TextView) view.findViewById(R.id.date_next);
        nextText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(getItem(+1)); //getItem(-1) for previous
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    public static SelectDueDateFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SelectDueDateFragment fragment = new SelectDueDateFragment();
        fragment.setArguments(args);
        return fragment;
    }



}
