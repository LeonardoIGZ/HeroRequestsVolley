package com.example.herorequestsvolley.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.example.herorequestsvolley.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {
    private ArrayList <Hero> heroes;
    private Context myContext;

    public HeroAdapter(Context myContext, ArrayList <Hero> heroes){
        this.heroes = heroes;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_heroelement, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Here I put the elements for everyone of the cards
        Hero tmpHero =  new Hero();
        tmpHero.setHeroName(heroes.get(position).getHeroName());
        tmpHero.setHeroImage(heroes.get(position).getHeroImage());

        //Set image
        ImageRequest imageRequest = new ImageRequest(tmpHero.getHeroImage(),
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        holder.heroImg.setImageBitmap(response);
                    }
                },80,80,
                ImageView.ScaleType.CENTER,
                Bitmap.Config.ALPHA_8,
                error -> {
                    error.printStackTrace();
                }
        );
        MySingleton.getInstance(myContext).addToRequestQueue(imageRequest);

        //Set name
        holder.heroName.setText(tmpHero.getHeroName());
        holder.heroCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(myContext, tmpHero.getHeroName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView heroImg;
        TextView heroName;
        RelativeLayout heroCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heroImg = itemView.findViewById(R.id.heroImage);
            heroName = itemView.findViewById(R.id.heroName);
            heroCard = itemView.findViewById(R.id.heroCard);
        }
    }

    /*void requestImageMethod(){
        ImageRequest imgReq = new
                ImageRequest("https://umhandroid.momrach.es/wp-content/uploads/2020/05/android_volley.jpeg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        miImg.setImageBitmap(response);
                    }

                },200,200,
                ImageView.ScaleType.CENTER,
                Bitmap.Config.ALPHA_8,
                error -> {
                    error.printStackTrace();
                }
        );
        MySingleton.getInstance(this).addToRequestQueue(imgReq);
    }*/
}
