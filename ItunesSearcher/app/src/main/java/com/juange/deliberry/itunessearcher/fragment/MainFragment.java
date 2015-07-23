package com.juange.deliberry.itunessearcher.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.juange.deliberry.itunessearcher.R;

/**
 * Created by juange on 23/7/15.
 */
public class MainFragment extends BaseFragment {

    public MainFragment() {}

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View containerView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, containerView);
        return containerView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
