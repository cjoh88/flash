package com.johansson.flash;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.johansson.flash.list.MainListItem;
import com.johansson.flash.list.MainListSeparator;
import com.johansson.flash.list.MainListSet;

import java.util.ArrayList;

/**
 * Created by chris on 2016-06-02.
 */
public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

    private ArrayList<MainListSet> items;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView subtitle;
        public ImageView favorite;
        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.txtTitle);
            subtitle = (TextView) v.findViewById(R.id.txtSubtitle);
            favorite = (ImageView) v.findViewById(R.id.imgFavorite);
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
        if(item.isFavorite()) {
            holder.favorite.setImageResource(R.drawable.ic_favorite_default_24dp);
        }
        else {
            holder.favorite.setImageResource(R.drawable.ic_favorite_border_default_24dp);
        }
        holder.favorite.setOnClickListener(new FavoriteClickListener(item));
    }

    @Override
    public int getItemViewType(int position) {
        return MainListItem.SET_ITEM;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
