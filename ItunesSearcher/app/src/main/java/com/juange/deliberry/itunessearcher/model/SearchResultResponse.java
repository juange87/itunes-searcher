package com.juange.deliberry.itunessearcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by juange on 22/7/15.
 */
public class SearchResultResponse implements Parcelable {

    private int resultCount;
    private ArrayList<SearchResult> results = new ArrayList<>();

    public SearchResultResponse(int resultCount, ArrayList<SearchResult> results) {
        this.resultCount = resultCount;
        this.results = results;
    }

    public SearchResultResponse() {}

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public ArrayList<SearchResult> getResults() {
        return results;
    }

    public void setResults(ArrayList<SearchResult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "SearchResultResponse{" +
                "resultCount=" + resultCount +
                ", results=" + results +
                '}';
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.resultCount);
        dest.writeList(this.results);
    }

    protected SearchResultResponse(Parcel in) {
        this.resultCount = in.readInt();
        this.results = new ArrayList<SearchResult>();
        in.readList(this.results, List.class.getClassLoader());
    }

    public static final Parcelable.Creator<SearchResultResponse> CREATOR =
            new Parcelable.Creator<SearchResultResponse>() {
                public SearchResultResponse createFromParcel(Parcel source) {return new SearchResultResponse(source);}

                public SearchResultResponse[] newArray(int size) {return new SearchResultResponse[size];}
            };
}
