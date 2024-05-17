package com.example.cardiopediafyp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {

    private List<ChildItem> childList;

    public ChildAdapter(List<ChildItem> childList) {
        this.childList = childList;
    }

    public static class ChildViewHolder extends RecyclerView.ViewHolder {
        public ImageView logo;
        public TextView title;

        public ChildViewHolder(View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.childLogoIv);
            title = itemView.findViewById(R.id.childTitleTv);
        }
    }

    @Override
    public ChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChildViewHolder holder, int position) {
        ChildItem childItem = childList.get(position);
        holder.logo.setImageResource(childItem.getLogo());
        holder.title.setText(childItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return childList.size();
    }
}