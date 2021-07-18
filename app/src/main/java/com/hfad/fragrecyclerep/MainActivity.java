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

    private CardsSource data;
    private RecyclerView recyclerView;
    private AdapterNotes adapterNotes;

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

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }
*/


  /*  @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.openCard:
                openNodes();
                return true;
            case R.id.addCard:

                Log.d("LOGIII", "addCard !!!");
                return true;
            case R.id.editCard:
                Log.d("LOGIII", "editCard !!!");
                return true;
            case R.id.deleteCard:

                Log.d("LOGIII", "deleteCard !!!");
                return true;
            case R.id.suprizeCard:
                Log.d("LOGIII", "aboutProgramm !!!");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

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