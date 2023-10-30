package com.example.ubcandlefest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ubcandlefest.adapter.ImageAdapter;
import com.example.ubcandlefest.model.Image;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CandleImageActivity extends AppCompatActivity {
    List<Image> images;
    ImageAdapter adapter;
    RequestQueue queue;
    RecyclerView rcvCandle;
    FloatingActionButton fabBack;
    TextView tvTempTitle;
    ImageView imgNoPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candle_image);
        images = new ArrayList<Image>();
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",1);
        String name = intent.getStringExtra("name");

        matchView();

        tvTempTitle.setText("รูปต้นเทียน"+name);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CandleImageActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        getCandleImage(id);


    }

    private void getCandleImage(int id) {
        String url = "https://sitthisak123.pythonanywhere.com/api/temple_images/"+ id;
        JsonArrayRequest request = new JsonArrayRequest(
                url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject object;
                        for (int i = 0;i<response.length();i++){
                            try {
                                object = response.getJSONObject(i);
                                Image image = new Image();
                                image.setId(object.getInt("id"));
                                image.setImageName(object.getString("img_name"));
                                image.setTempleName(object.getString("temple_name"));

                                images.add(image);
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if(images.size()>0) {
                            adapter = new ImageAdapter(CandleImageActivity.this, images);
                            rcvCandle.setAdapter(adapter);
                            rcvCandle.setLayoutManager(new LinearLayoutManager(CandleImageActivity.this));
                        }else{
                            imgNoPhoto.setVisibility(View.VISIBLE);
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(
                                CandleImageActivity.this,
                                error.getMessage(),
                                Toast.LENGTH_SHORT
                        ).show();;
                    }
                }
        );

        queue = Volley.newRequestQueue(CandleImageActivity.this);
        queue.add(request);
    }

    private void matchView() {
        rcvCandle = findViewById(R.id.rcv_candle_img);
        fabBack = findViewById(R.id.fab_back);
        tvTempTitle = findViewById(R.id.tv_img_temple_title);
        imgNoPhoto = findViewById(R.id.imgv_no_photo);
    }
}