package com.hfad.fragrecyclerep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.hfad.fragrecyclerep.fragments.AdapterNotes;
import com.hfad.fragrecyclerep.fragments.OpenNodesFragment;
import com.hfad.fragrecyclerep.model.Notes;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_layout);
        initToolbar();
        openNodes();
    }

    void initToolbar() {
        Toolbar toolbar = findViewById(R.id.tooolbarContainer);
        setSupportActionBar(toolbar);
    }



    //отрыть фрагмент со списком массива
    void openNodes() {
        Log.d("LOGIII", "OpenCard !!!");
        OpenNodesFragment openNotes = new OpenNodesFragment();
        //  openNotes.setArguments(getIntent().getExtras());
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer1, openNotes);
        fragmentTransaction.commit();

    }

}