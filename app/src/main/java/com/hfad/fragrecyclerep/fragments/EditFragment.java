package com.hfad.fragrecyclerep.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hfad.fragrecyclerep.R;
import com.hfad.fragrecyclerep.model.Notes;



public class EditFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    TextView name, description;
    Notes notes;
    int position;
    Button btnSave;
    private String mParam1;
    private String mParam2;
    String name1,description1;
    public EditFragment() {

    }

    public EditFragment(int position) {
        this.position = position;
    }

    public static EditFragment newInstance(String param1, String param2) {
        EditFragment fragment = new EditFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        initTextView(view);
        return view; }
//вставляем текст с переданной заметкой
    private void initTextView(View view) {
        name = view.findViewById(R.id.editName);
        description = view.findViewById(R.id.editDescription);
        btnSave = view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSaveNotes(view);
            }
        });


    }

    private void initSaveNotes(View view) {
       /* notes.setName((String) name.getText());
        notes.setDescription((String) description.getText());*/
        Log.d("Save", "надо реализовать сохранение");
        name1 =  name.getText().toString();
        description1 = description.getText().toString();
        Log.d("Save", name1+"$"+description1);
        notes.setName(name1);
        notes.setDescription(description1);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }
}