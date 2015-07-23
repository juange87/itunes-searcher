package com.juange.deliberry.itunessearcher.api;

import com.juange.deliberry.itunessearcher.BuildConfig;
import com.juange.deliberry.itunessearcher.base.Constants;
import com.juange.deliberry.itunessearcher.model.SearchResultResponse;
import retrofit.RestAdapter;
import rx.Observable;

/**
 * Created by juange on 23/7/15.
 */
public class APIClient implements Constants {

    private static final String API_URL = "https://itunes.apple.com/";
    private String data;
    private final int requestType;

    public APIClient(String data, int requestType) {
        this.data = data;
        this.requestType = requestType;
    }

    public Observable<SearchResultResponse> performRequest() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();

        if (BuildConfig.DEBUG) {
            restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        }

        APIService service = restAdapter.create(APIService.class);

        switch (requestType) {
            case API.REQUEST_TYPE.SEARCH:
                return service.search(data);
        }
        return Observable.empty();
    }
}
