package com.hfad.fragrecyclerep;

import com.hfad.fragrecyclerep.model.Notes;

public interface CardsSource {
    Notes getCardData(int position);
    int size();
    void deleteNotes(int position);
    void updateNotes(int position,Notes notes);
    void addNotes(Notes notes);
    void clearCardData();
}
