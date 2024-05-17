package com.example.cardiopediafyp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> {

    private List<ParentItem> parentList;

    public ParentAdapter(List<ParentItem> parentList) {
        this.parentList = parentList;
    }

    public static class ParentViewHolder extends RecyclerView.ViewHolder {
        public ImageView logoIv;
        public TextView titleTv;
        public RecyclerView childRecyclerView;

        public ParentViewHolder(View itemView) {
            super(itemView);
            logoIv = itemView.findViewById(R.id.parentLogoIv);
            titleTv = itemView.findViewById(R.id.parentTitleTv);
            childRecyclerView = itemView.findViewById(R.id.langRecyclerView);
        }
    }

    @Override
    public ParentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_item, parent, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ParentViewHolder holder, int position) {
        ParentItem parentItem = parentList.get(position);
        holder.logoIv.setImageResource(parentItem.getLogo());
        holder.titleTv.setText(parentItem.getTitle());

        holder.childRecyclerView.setHasFixedSize(true);
        holder.childRecyclerView.setLayoutManager(new GridLayoutManager(holder.itemView.getContext(), 3));
        ChildAdapter adapter = new ChildAdapter(parentItem.getMList());
        holder.childRecyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }
}