package org.tvheadend.tvhclient.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.tvheadend.tvhclient.R;
import org.tvheadend.tvhclient.model.GenreColorDialogItem;

import java.util.List;

public class GenreColorDialogAdapter extends RecyclerView.Adapter<GenreColorDialogAdapter.ViewHolder> {

    private List<GenreColorDialogItem> list;

    public GenreColorDialogAdapter(List<GenreColorDialogItem> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_color_dialog, parent, false);
        return new ViewHolder(view, this);
    }

    @Override
    /**
     * Applies the values to the available layout items
     */
    public void onBindViewHolder(ViewHolder holder, int position) {
        final GenreColorDialogItem item = list.get(position);
        if (item != null) {
            if (holder.color != null) {
                holder.color.setBackgroundColor(item.color);
            }
            if (holder.genre != null) {
                holder.genre.setText(item.genre);
                holder.genre.setTag(position);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView color;
        final TextView genre;
        final GenreColorDialogAdapter adapter;

        public ViewHolder(View view, GenreColorDialogAdapter adapter) {
            super(view);
            this.color = (TextView) view.findViewById(R.id.color);
            this.genre = (TextView) view.findViewById(R.id.genre);

            this.adapter = adapter;
        }
    }
}
