package com.hfad.fragrecyclerep.fragments;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.fragrecyclerep.R;
import com.hfad.fragrecyclerep.model.Notes;

import java.util.ArrayList;


public class AdapterNotes extends RecyclerView.Adapter<AdapterNotes.ViewHolder> {

    private ArrayList<Notes> arrayList;

    private OnItemClickListener itemClickListener;

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
        holder.getDescrip().setText(notes.getDescription());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void SetOnClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView, descrip;
        AppCompatImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.namesNote);
            imageView = itemView.findViewById(R.id.viewImage);
            descrip = itemView.findViewById(R.id.descriptionNote);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("click", "нажатие" + getAdapterPosition());
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(view, getAdapterPosition() );
                    }

                }
            });
        }

        public TextView getTextView() {
            return textView;
        }

        public TextView getDescrip() {
            return descrip;
        }

    }


}
