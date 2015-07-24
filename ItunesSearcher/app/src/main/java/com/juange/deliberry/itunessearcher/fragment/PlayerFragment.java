package com.juange.deliberry.itunessearcher.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.juange.deliberry.itunessearcher.R;
import com.juange.deliberry.itunessearcher.model.data.Search;

/**
 * Created by juange on 24/7/15.
 */
public class PlayerFragment extends BaseFragment {

    public static final String ARG_SEARCH = "arg.search";

    public PlayerFragment() {}

    public static PlayerFragment newInstance(Search search) {
        final PlayerFragment resultsFragment = new PlayerFragment();
        Bundle arguments = new Bundle();
        arguments.putParcelable(ARG_SEARCH, search);
        resultsFragment.setArguments(arguments);
        return resultsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View containerView = inflater.inflate(R.layout.fragment_player, container, false);
        ButterKnife.bind(this, containerView);
        return containerView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() == null) {
            throw new IllegalStateException("You should have used Fragment.newInstance()");
        }

        final Search search = getArguments().getParcelable(ARG_SEARCH);
    }
}
