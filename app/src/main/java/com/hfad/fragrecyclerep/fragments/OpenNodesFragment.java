package com.hfad.fragrecyclerep.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import com.hfad.fragrecyclerep.R;
import com.hfad.fragrecyclerep.model.Notes;

import java.util.ArrayList;


public class OpenNodesFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    ArrayList<Notes> arrayList;
    Notes notes;


    public static OpenNodesFragment newInstance(String param1, String param2) {
        OpenNodesFragment fragment = new OpenNodesFragment();
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
        View view = inflater.inflate(R.layout.fragment_open_nodes, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
//???
        if (savedInstanceState != null) {

        } else {
            initNotes();
        }

        initRecyclerView(recyclerView, arrayList);
        return view;
    }

    private void initRecyclerView(RecyclerView recyclerView, ArrayList<Notes> arrayList) {
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        AdapterNotes adapterNotes = new AdapterNotes(arrayList);
        recyclerView.setAdapter(adapterNotes);
        adapterNotes.SetOnClickListener(new AdapterNotes.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                initEditRecyclerNote(view, position);
            }
        });
    }

    private void initEditRecyclerNote(View view, int position) {
        EditFragment editFragment = new EditFragment(arrayList, position);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer1, editFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    //создать список объектов
    private void initNotes() {
        arrayList = new ArrayList<>();
        String[] arrayNotes = getResources().getStringArray(R.array.arrayNameNote);
        String[] arrayNotesDescription = getResources().getStringArray(R.array.arrayDescriptionNote);
        for (int i = 0; i < arrayNotes.length; i++) {
            notes = new Notes();
            String Desc = arrayNotesDescription[i];
            String name = arrayNotes[i];
            notes.setDescription(Desc);
            notes.setName(name);
            arrayList.add(notes);
        }

    }


}

