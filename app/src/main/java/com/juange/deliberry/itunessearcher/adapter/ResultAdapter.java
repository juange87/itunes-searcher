package com.juange.deliberry.itunessearcher.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.juange.deliberry.itunessearcher.R;
import com.juange.deliberry.itunessearcher.model.data.Search;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by juange on 23/7/15.
 */
public class ResultAdapter extends RecyclerView.Adapter<ResultViewHolder> {

    private Context context;
    private List<Search> results = new ArrayList<>();

    public ResultAdapter(Context context, List<Search> results) {
        this.context = context;
        this.results = results;
    }

    @Override
    public ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_result, parent, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultViewHolder holder, int position) {
        final Search search = results.get(position);

        holder.txtSong.setText(search.getTrackName());
        holder.txtArtist.setText(search.getArtistName());
        holder.txtAlbum.setText(search.getCollectionName());
        holder.txtLaunchDate.setText(search.getReleaseDate());
        holder.txtDuration.setText(search.getDuration());
        holder.txtGenre.setText(search.getPrimaryGenreName());
        holder.txtCost.setText(String.valueOf(search.getTrackPrice()) + " " + search.getCurrency());

        Picasso.with(context)
               .load(search.getArtworkUrl100())
               .into(holder.imgArtwork);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
