package com.juange.deliberry.itunessearcher.api;

import rx.Observable;

/**
 * Created by juange on 23/7/15.
 */
public class RequestManager {

    public static Observable<?> performRequest(String data, int requestType) {
        return new APIClient(data, requestType).performRequest();
    }
}
