package com.example.ubcandlefest.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ubcandlefest.CandleImageActivity;
import com.example.ubcandlefest.R;
import com.example.ubcandlefest.model.Temple;

import java.util.List;

public class TempleAdapter extends RecyclerView.Adapter<TempleAdapter.TempleViewHolder> {
    private Context context;
    private List<Temple> temples;
    public TempleAdapter(Context context, List<Temple> temple) {
        this.context = context;
        this.temples = temple;
    }
    @NonNull
    @Override
    public TempleAdapter.TempleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.temple_view,parent,false);
        return new TempleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TempleAdapter.TempleViewHolder holder, int position) {
        Temple temple = temples.get(position);
        holder.tvWatName.setText(temple.getName());
        holder.tvDes.setText(temple.getDescription());

        holder.layoutTemple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CandleImageActivity.class);
                intent.putExtra("id",temple.getId());
                intent.putExtra("name",temple.getName());
                Log.d("name",temple.getName());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return temples.size();
    }
    public class TempleViewHolder extends RecyclerView.ViewHolder{
        TextView tvWatName,tvDes;
        ConstraintLayout layoutTemple;
        public  TempleViewHolder(@NonNull View itemView){
            super(itemView);
            tvWatName = itemView.findViewById(R.id.tv_wat_name);
            tvDes = itemView.findViewById(R.id.tv_description);
            layoutTemple = itemView.findViewById(R.id.layout_temple);
        }
    }
}
