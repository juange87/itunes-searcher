package com.juange.deliberry.itunessearcher.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.juange.deliberry.itunessearcher.R;
import com.juange.deliberry.itunessearcher.adapter.RecyclerItemClickListener;
import com.juange.deliberry.itunessearcher.adapter.ResultAdapter;
import com.juange.deliberry.itunessearcher.api.RequestManager;
import com.juange.deliberry.itunessearcher.base.Constants;
import com.juange.deliberry.itunessearcher.model.api.SearchResultResponse;
import com.juange.deliberry.itunessearcher.model.data.Search;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by juange on 23/7/15.
 */
public class ResultsFragment extends BaseFragment {

    public static final String ARG_QUERY = "arg.query";

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<Search> searchResults = new ArrayList<>();

    public ResultsFragment() {}

    public static ResultsFragment newInstance(String query) {
        final ResultsFragment resultsFragment = new ResultsFragment();
        Bundle arguments = new Bundle();
        arguments.putString(ARG_QUERY, query);
        resultsFragment.setArguments(arguments);
        return resultsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View containerView = inflater.inflate(R.layout.fragment_results, container, false);
        ButterKnife.bind(this, containerView);
        return containerView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() == null) {
            throw new IllegalStateException("You should have used Fragment.newInstance()");
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), (view, position) -> {
                    final Search search = searchResults.get(position);
                    getMainActivity().replaceFragment(PlayerFragment.newInstance(search));
                })
        );

        final String query = getArguments().getString(ARG_QUERY);
        RequestManager.performRequest(query, Constants.API.REQUEST_TYPE.SEARCH)
                      .takeUntil(destroyed())
                      .subscribeOn(Schedulers.computation())
                      .observeOn(AndroidSchedulers.mainThread())
                      .map(response -> ((SearchResultResponse) response).getResults())
                      .flatMap(Observable::from)
                      .map(searchResult -> new Search.SearchBuilder(searchResult)
                              .setDuration(searchResult.getTrackTimeMillis())
                              .build())
                      .toList()
                      .subscribe(
                              this::manageResults,
                              this::manageError
                      );
    }

    private void manageResults(List<Search> searchResults) {
        this.searchResults = searchResults;
        ResultAdapter resultAdapter = new ResultAdapter(getActivity(), searchResults);
        recyclerView.setAdapter(resultAdapter);
    }

    private void manageError(Throwable throwable) {
        Toast.makeText(getActivity(), R.string.error_searching, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
