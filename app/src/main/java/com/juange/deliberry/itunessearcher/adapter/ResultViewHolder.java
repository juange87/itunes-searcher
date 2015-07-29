package com.juange.deliberry.itunessearcher.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.juange.deliberry.itunessearcher.R;

/**
 * Created by juange on 23/7/15.
 */
public class ResultViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.img_artwork)
    ImageView imgArtwork;

    @Bind(R.id.txt_song)
    TextView txtSong;

    @Bind(R.id.txt_artist)
    TextView txtArtist;

    @Bind(R.id.txt_album)
    TextView txtAlbum;

    @Bind(R.id.txt_launch_date)
    TextView txtLaunchDate;

    @Bind(R.id.txt_duration)
    TextView txtDuration;

    @Bind(R.id.txt_genre)
    TextView txtGenre;

    @Bind(R.id.txt_cost)
    TextView txtCost;

    public ResultViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
