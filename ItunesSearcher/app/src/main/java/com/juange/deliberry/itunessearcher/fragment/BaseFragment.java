package com.juange.deliberry.itunessearcher.fragment;

import android.support.v4.app.Fragment;
import com.juange.deliberry.itunessearcher.actitivy.MainActivity;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by juange on 23/7/15.
 */
public class BaseFragment extends Fragment {

    PublishSubject<Void> destroyedSubject = PublishSubject.create();

    public MainActivity getMainActivity() {
        if (getActivity() instanceof MainActivity) {
            return ((MainActivity) getActivity());
        }
        return null;
    }

    public Observable<Void> destroyed() { return destroyedSubject.asObservable(); }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        destroyedSubject.onNext(null);
    }
}
