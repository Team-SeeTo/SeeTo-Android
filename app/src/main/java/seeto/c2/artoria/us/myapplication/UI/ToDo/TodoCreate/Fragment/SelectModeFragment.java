package seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.Arrays;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.SibalLom;

import static seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.CreateTodoActivity.viewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectModeFragment extends Fragment {
    String editTodoMode;

    public SelectModeFragment() {
        // Required empty public constructor
    }
    SibalLom sibalLom;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sibalLom = ViewModelProviders.of(getActivity()).get(SibalLom.class);
        editTodoMode = getArguments().getString("editTodoMode");

        View view = inflater.inflate(R.layout.fragment_select_mode, container, false);
        String[] modeList = {
                "STANDARD", "HARD", "INFINITY"
        };

        ArrayAdapter<String> modeAdapter = new ArrayAdapter<>(
                getContext(),
                R.layout.support_simple_spinner_dropdown_item,
                modeList
        );

        MaterialBetterSpinner materialBetterSpinner;

        materialBetterSpinner = view.findViewById(R.id.mode_spinner);
        materialBetterSpinner.setAdapter(modeAdapter);
        if(editTodoMode == null)
            materialBetterSpinner.setText(modeAdapter.getItem(0).toString());
        else {
            materialBetterSpinner.setText(editTodoMode);
        }

        TextView nextText = (TextView) view.findViewById(R.id.mode_next);
        nextText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mode = materialBetterSpinner.getText().toString();
                sibalLom.getMode().setValue(mode);
                Log.d("TODO", sibalLom.getMode().getValue());
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
        args.putString("editTodoMode", null);

        SelectModeFragment fragment = new SelectModeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static SelectModeFragment newInstance(String editTodoMode) {

        Bundle args = new Bundle();
        args.putString("editTodoMode", editTodoMode);

        SelectModeFragment fragment = new SelectModeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    void setMode(String mode) {

    }

}