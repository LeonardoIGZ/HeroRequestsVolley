package com.example.herorequestsvolley.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    }

    @Override
    public int getItemCount() {
        return 0;
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
}
