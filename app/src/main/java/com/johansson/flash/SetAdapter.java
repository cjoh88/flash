package com.johansson.flash;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.johansson.flash.setlist.MainListItem;
import com.johansson.flash.setlist.MainListSeparator;
import com.johansson.flash.setlist.MainListSet;

import java.util.ArrayList;

/**
 * Created by chris on 2016-06-02.
 */
public class SetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MainListItem[] items;
    private ArrayList<MainListSet> favorites;
    private LinearLayoutManager layoutManager;
    private FavoritesAdapter favoritesAdapter;

    private SetClickListener setClickListener;

    public static class SetViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView subtitle;
        public SetViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.txtTitle);
            subtitle = (TextView) v.findViewById(R.id.txtSubtitle);
        }
    }

    public static class SeparatorViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public SeparatorViewHolder(View v) {
            super(v);
            text = (TextView) v.findViewById(R.id.sepText);
        }
    }

    public static class FavoritesViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView recyclerView;
        public FavoritesViewHolder(View v) {
            super(v);
            recyclerView = (RecyclerView) v.findViewById(R.id.listFavorites);
        }
    }

    public SetAdapter(MainListItem[] items) {
        this.items = items;
        //this.favorites = getFavorites();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case MainListItem.SET_ITEM:
                return new SetViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_main, parent, false));
            case MainListItem.SET_SEPARATOR:
                return new SeparatorViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_separator, parent, false));
            case MainListItem.SET_FAVORITES:
                return new FavoritesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_favorites_list, parent, false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (items[position].getItemType()) {
            case MainListItem.SET_ITEM:
                bindSetHolder((SetViewHolder) holder, (MainListSet) items[position]);
                break;
            case MainListItem.SET_SEPARATOR:
                bindSeparatorHolder((SeparatorViewHolder) holder, (MainListSeparator) items[position]);
                break;
            case MainListItem.SET_FAVORITES:
                favorites = getFavorites();
                bindFavoritesHolder((FavoritesViewHolder) holder, favorites);
                break;
        }
    }

    private void bindSetHolder(SetViewHolder holder, MainListSet item) {
        holder.title.setText(item.getTitle());
        holder.subtitle.setText(item.getSubtitle());
        if(setClickListener != null) {
            holder.itemView.setOnClickListener(setClickListener);
        }
    }

    private void bindSeparatorHolder(SeparatorViewHolder holder, MainListSeparator item) {
        holder.text.setText(item.getText());
    }

    private void bindFavoritesHolder(FavoritesViewHolder holder, ArrayList<MainListSet> items) {
        holder.recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(holder.recyclerView.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        favoritesAdapter = new FavoritesAdapter(items);
        favoritesAdapter.setSetClickListener(setClickListener);
        holder.recyclerView.setLayoutManager(layoutManager);
        holder.recyclerView.setAdapter(favoritesAdapter);
    }

    private ArrayList<MainListSet> getFavorites() {
        ArrayList<MainListSet> arr = new ArrayList<>();
        for(MainListItem item : items) {
            if(item.getItemType() == MainListItem.SET_ITEM) {
                MainListSet s = (MainListSet) item;
                if(s.isFavorite()) {
                    arr.add(s);
                }
            }
        }
        return arr;
    }

    @Override
    public int getItemViewType(int position) {
        return items[position].getItemType();
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public void setSetClickListener(SetClickListener listener) {
        this.setClickListener = listener;
    }
}
