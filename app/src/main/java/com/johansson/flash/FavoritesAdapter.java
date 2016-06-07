package com.johansson.flash;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.johansson.flash.mainlist.MainListItem;
import com.johansson.flash.mainlist.MainListSet;

import java.util.ArrayList;

/**
 * Created by chris on 2016-06-02.
 */
public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

    private ArrayList<MainListSet> items;
    private SetClickListener setClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView subtitle;
        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.txtTitle);
            subtitle = (TextView) v.findViewById(R.id.txtSubtitle);
        }
    }

    public FavoritesAdapter(ArrayList<MainListSet> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_favorite, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MainListSet item = items.get(position);
        holder.title.setText(item.getTitle());
        holder.subtitle.setText(item.getSubtitle());
        if(setClickListener != null) {
            holder.itemView.setOnClickListener(setClickListener);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return MainListItem.SET_ITEM;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setSetClickListener(SetClickListener listener) {
        this.setClickListener = listener;
    }
}
