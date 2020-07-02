package com.example.gym;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class Adpater extends RecyclerView.Adapter<Adpater.viewholder> {
    private Context context;
    private ArrayList<Model>  stored = new ArrayList<>();



    public Adpater(Context context) {
        this.context = context;
    }



    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        viewholder viewholder= new viewholder(v);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, final int position) {
        holder.Title.setText(stored.get(position).getTitle());
        holder.description.setText(stored.get(position).getLondescr());


        Glide.with(context)
                .asBitmap()
                .load(stored.get(position).getImageUrl())
                .into(holder.imageView);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Training.class);
              intent.putExtra("key",stored.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return stored.size();
    }

    public void setStored(ArrayList<Model> stored) {
        this.stored = stored;
        notifyDataSetChanged();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        private TextView Title;
        private TextView description;
        private ImageView imageView;
        private CardView cardView;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.txtTitle);
            description =itemView.findViewById(R.id.txtDescr);
            imageView = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.parent);
        }
    }
}
