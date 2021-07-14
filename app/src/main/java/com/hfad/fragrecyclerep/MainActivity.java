package com.hfad.fragrecyclerep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_layout);
        initToolbar();

    }

   void initToolbar(){
        Toolbar toolbar = findViewById(R.id.tooolbarContainer);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
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
    }

   void openNodes(){
       Log.d("LOGIII", "OpenCard !!!");
       

    }

}