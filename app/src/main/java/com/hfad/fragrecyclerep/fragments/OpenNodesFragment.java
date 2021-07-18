package com.hfad.fragrecyclerep.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import com.hfad.fragrecyclerep.CardsSource;
import com.hfad.fragrecyclerep.R;
import com.hfad.fragrecyclerep.model.CardsSourceImpl;
import com.hfad.fragrecyclerep.model.Notes;

import java.util.ArrayList;


public class OpenNodesFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    AdapterNotes adapterNotes;
    RecyclerView recyclerView;
    private CardsSource data;
    private String mParam1;
    private String mParam2;

    Notes notes;

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

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
        CardsSource data = new CardsSourceImpl(getResources()).init();

        initView(view);
        setHasOptionsMenu(true);
        return view;
    }

    private void initView(View view) {
    recyclerView = view.findViewById(R.id.recyclerView);
        data = new CardsSourceImpl(getResources()).init();
        initRecyclerView();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.openCard:

                return true;
            case R.id.addCard:
                data.addNotes(new Notes("Заметка "+(data.size()+1),
                        "Описание заметки "+(data.size()+1),
                        R.drawable.space1,false));
               // adapterNotes.notifyItemInserted(data.size());
                //если весь список очистить топри создании нужен:
                adapterNotes.notifyDataSetChanged();
                Log.d("LOGIII", "addCard !!!");
                return true;
            case R.id.editCard:
                Log.d("LOGIII", "editCard !!!");
                return true;
            case R.id.deleteCard:
                data.clearCardData();
                adapterNotes.notifyDataSetChanged();
                Log.d("LOGIII", "deleteCard !!!");
                return true;
            case R.id.suprizeCard:
                Log.d("LOGIII", "aboutProgramm !!!");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapterNotes = new AdapterNotes(data);
        recyclerView.setAdapter(adapterNotes);
        adapterNotes.SetOnClickListener(new AdapterNotes.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                initEditRecyclerNote(view, position);
            }
        });
    }

    //изменить конструктор
    private void initEditRecyclerNote(View view, int position) {
        EditFragment editFragment = new EditFragment(position);
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
     /*   arrayList = new ArrayList<>();
        String[] arrayNotes = getResources().getStringArray(R.array.arrayNameNote);
        String[] arrayNotesDescription = getResources().getStringArray(R.array.arrayDescriptionNote);
        for (int i = 0; i < arrayNotes.length; i++) {
            notes = new Notes();
            String Desc = arrayNotesDescription[i];
            String name = arrayNotes[i];
            notes.setDescription(Desc);
            notes.setName(name);
            arrayList.add(notes);*/
    }

}




