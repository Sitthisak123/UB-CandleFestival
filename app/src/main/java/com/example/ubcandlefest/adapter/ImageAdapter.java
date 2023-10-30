package com.example.ubcandlefest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ubcandlefest.R;
import com.example.ubcandlefest.model.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    public ImageAdapter(Context context, List<Image> images) {
        this.context = context;
        this.images = images;
    }

    private Context context;
    private List<Image> images;
    @NonNull
    @Override
    public ImageAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_view,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ImageViewHolder holder, int position) {
        Image image = images.get(position);

//        int id = image.getId();
        String imageName = image.getImageName();
        String url = "https://sitthisak123.pythonanywhere.com/static/images/"+imageName;
        Picasso.get().load(url).fit().centerInside().into(holder.imgvCandle);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }
    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imgvCandle;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imgvCandle = itemView.findViewById(R.id.imgv_candle);
        }
    }
}
