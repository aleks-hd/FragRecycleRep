package com.hfad.fragrecyclerep.fragments;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.hfad.fragrecyclerep.CardsSource;
import com.hfad.fragrecyclerep.R;
import com.hfad.fragrecyclerep.model.Notes;



public class AdapterNotes extends RecyclerView.Adapter<AdapterNotes.ViewHolder> {


    private final static String TAG = "SocialNetworkAdapter";
    private CardsSource dataSource;
    private OnItemClickListener itemClickListener;
    private final Fragment fragment;
    private int menuPosition;

    public int getMenuPosition(){
        return menuPosition;
    }

    public AdapterNotes(CardsSource dataSource, Fragment fragment) {
        this.dataSource = dataSource;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public AdapterNotes.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNotes.ViewHolder holder, int position) {

        holder.setData(dataSource.getCardData(position));

    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public void SetOnClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, descrip;
        AppCompatImageView imageView;
        AppCompatCheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.namesNote);
            imageView = itemView.findViewById(R.id.viewImage);
            descrip = itemView.findViewById(R.id.descriptionNote);
            checkBox = itemView.findViewById(R.id.checkbox);
            registeryContexMenu(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("click", "??????????????" + getAdapterPosition());
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(view, getAdapterPosition());
                    }

                }
            });
            imageView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    menuPosition = getLayoutPosition();
                    itemView.showContextMenu(20,20);
                    return true;
                }
            });
        }

        private void registeryContexMenu(View itemView) {
            if (fragment!=null){
                imageView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        menuPosition = getLayoutPosition();
                        return false;
                    }
                });
                fragment.registerForContextMenu(itemView);
            }
        }

        public void setData(Notes cardData) {
            title.setText(cardData.getName());
            descrip.setText(cardData.getDescription());
            checkBox.setChecked(cardData.isLike());
            imageView.setImageResource(cardData.getPictures());
        }
    }


}
