package com.juange.deliberry.itunessearcher.api;

import com.juange.deliberry.itunessearcher.model.api.SearchResultResponse;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by juange on 23/7/15.
 */
public interface APIService {

    @GET("/search")
    Observable<SearchResultResponse> search(@Query("term") String query);
}
