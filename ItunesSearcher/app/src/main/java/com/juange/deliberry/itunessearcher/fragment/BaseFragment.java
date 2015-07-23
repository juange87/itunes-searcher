package com.juange.deliberry.itunessearcher.fragment;

import android.support.v4.app.Fragment;
import com.juange.deliberry.itunessearcher.actitivy.MainActivity;

/**
 * Created by juange on 23/7/15.
 */
public class BaseFragment extends Fragment {

    public MainActivity getMainActivity() {
        if (getActivity() instanceof MainActivity) {
            return ((MainActivity) getActivity());
        }
        return null;
    }
}
