package com.project.devexlearning.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.devexlearning.R;
import com.project.devexlearning.entity.Course;

import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder> {
    List<Course> items;
    Context context;

    public CoursesAdapter(List<Course> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_list, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CoursesAdapter.ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.price.setText("$" + items.get(position).getPrice());

        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getImgPath(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.iconImg);

        switch (position) {
            case 0:
                holder.bgImg.setImageResource(R.drawable.bg_1);
                holder.constraintLayout.setBackgroundResource(R.drawable.list_background_1);
                break;
            case 1:
                holder.bgImg.setImageResource(R.drawable.bg_2);
                holder.constraintLayout.setBackgroundResource(R.drawable.list_background_2);
                break;
            case 2:
                holder.bgImg.setImageResource(R.drawable.bg_3);
                holder.constraintLayout.setBackgroundResource(R.drawable.list_background_3);
                break;
            case 3:
                holder.bgImg.setImageResource(R.drawable.bg_4);
                holder.constraintLayout.setBackgroundResource(R.drawable.list_background_4);
                break;
            case 4:
                holder.bgImg.setImageResource(R.drawable.bg_5);
                holder.constraintLayout.setBackgroundResource(R.drawable.list_background_5);
                break;
        }
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, price;
        ImageView iconImg, bgImg;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            price = itemView.findViewById(R.id.priceTxt);
            iconImg = itemView.findViewById(R.id.aiIconImg);
            bgImg = itemView.findViewById(R.id.bgImg);
            constraintLayout = itemView.findViewById(R.id.mailLayout);
        }
    }
}
