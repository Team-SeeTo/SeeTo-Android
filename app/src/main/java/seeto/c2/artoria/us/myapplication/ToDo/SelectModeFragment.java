package seeto.c2.artoria.us.myapplication.ToDo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import seeto.c2.artoria.us.myapplication.R;

import static seeto.c2.artoria.us.myapplication.ToDo.ToDoCreateActivity.viewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectModeFragment extends Fragment {


    public SelectModeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_select_mode, container, false);
        String[] modeList = {
                "Standard", "Hard", "Unlimited"
        };

        ArrayAdapter<String> modeAdapter = new ArrayAdapter<>(
                getContext(),
                R.layout.support_simple_spinner_dropdown_item,
                modeList
        );

        MaterialBetterSpinner materialBetterSpinner;

        materialBetterSpinner = view.findViewById(R.id.mode_spinner);
        materialBetterSpinner.setAdapter(modeAdapter);
        materialBetterSpinner.setText(modeAdapter.getItem(0).toString());

        TextView nextText = (TextView) view.findViewById(R.id.mode_next);
        nextText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(getItem(+1));
            }
        });

        return view;
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    public static SelectModeFragment newInstance() {

        Bundle args = new Bundle();

        SelectModeFragment fragment = new SelectModeFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
