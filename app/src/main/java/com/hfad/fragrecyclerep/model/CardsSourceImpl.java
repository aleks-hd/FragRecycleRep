package com.hfad.fragrecyclerep.model;

import android.content.res.Resources;
import android.content.res.TypedArray;

import com.hfad.fragrecyclerep.CardsSource;
import com.hfad.fragrecyclerep.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CardsSourceImpl implements CardsSource {

    private List<Notes> dataSource;
    private Resources resources;

    public CardsSourceImpl(Resources resources) {
        this.dataSource = new ArrayList<>(10);
        this.resources = resources;
    }

    public CardsSourceImpl init() {
        String[] titles = resources.getStringArray(R.array.arrayNameNote);
        String[] description = resources.getStringArray(R.array.arrayDescriptionNote);
        int[] pictures = getImageArray();
        for (int i = 0; i < description.length; i++) {
            dataSource.add(new Notes(titles[i], description[i], pictures[i],  Calendar.getInstance().getTime(),false));
        }
        return this;
    }

    private int[] getImageArray() {
        TypedArray pictures = resources.obtainTypedArray(R.array.arraypictures);
        int lenght = pictures.length();
        int[] answer = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            answer[i] = pictures.getResourceId(i, 0);
        }
        return answer;
    }


    @Override
    public Notes getCardData(int position) {
        return dataSource.get(position);
    }

    @Override
    public int size() {
        return dataSource.size();
    }

    @Override
    public void deleteNotes(int position) {
        dataSource.remove(position);
    }

    @Override
    public void updateNotes(int position, Notes notes) {
        dataSource.set(position, notes);
    }

    @Override
    public void addNotes(Notes notes) {
        dataSource.add(notes);
    }

    @Override
    public void clearCardData() {
        dataSource.clear();
    }
}
