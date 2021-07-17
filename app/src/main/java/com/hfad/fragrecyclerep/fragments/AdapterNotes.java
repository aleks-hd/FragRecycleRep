package com.hfad.fragrecyclerep.fragments;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.fragrecyclerep.R;
import com.hfad.fragrecyclerep.model.Notes;

import java.util.ArrayList;


public class AdapterNotes extends RecyclerView.Adapter<AdapterNotes.ViewHolder> {

    private ArrayList<Notes> arrayList;

    public AdapterNotes(ArrayList<Notes> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AdapterNotes.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNotes.ViewHolder holder, int position) {

        Notes notes = arrayList.get(position);
        holder.getTextView().setText(notes.getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        AppCompatImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.namesNote);
            imageView = itemView.findViewById(R.id.viewImage);

        }

        public TextView getTextView() {
            return textView;
        }
    }
}
