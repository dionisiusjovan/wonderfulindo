package com.wi.wonderfulindo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    ArrayList<MainModel> mainModels;
    Context context;
    private OnPicClickListener monPicClickListener;

     public MainAdapter(Context context, ArrayList<MainModel> mainModels, OnPicClickListener onPickClickListener){
         this.context = context;
         this.mainModels = mainModels;
         this.monPicClickListener = onPickClickListener;
     }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Create View
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item,parent,false);
        return new ViewHolder(view, monPicClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         //set foto tempat ke imageview
        holder.imageView.setImageResource(mainModels.get(position).getTempat());
        //set nama tempat ke textview
        holder.textView.setText(mainModels.get(position).getNamatempat());

    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
         //Inisialisasi Variabel
        ImageView imageView;
        TextView textView;
        OnPicClickListener onPicClickListener;

        public ViewHolder(@NonNull View itemView, OnPicClickListener onPicClickListener) {
            super(itemView);
            //Assign Variable
            imageView = itemView.findViewById(R.id.fotoBL);
            textView = itemView.findViewById(R.id.txtBL);
            this.onPicClickListener = onPicClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onPicClickListener.onPicClick(getAdapterPosition());
        }
    }

    public interface OnPicClickListener{
         void onPicClick(int position);
    }

}
