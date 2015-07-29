package com.juange.deliberry.itunessearcher.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.juange.deliberry.itunessearcher.model.api.SearchResult;

/**
 * Created by juange on 24/7/15.
 */
public class Search implements Parcelable {

    private String artistName;
    private String collectionName;
    private String trackName;
    private String previewUrl;
    private String artworkUrl30;
    private String artworkUrl60;
    private String artworkUrl100;
    private double trackPrice;
    private String releaseDate;
    private int trackTimeMillis;
    private String currency;
    private String primaryGenreName;
    private String duration;

    public Search() {}

    private Search(SearchBuilder builder) {
        this.artistName = builder.artistName;
        this.collectionName = builder.collectionName;
        this.trackName = builder.trackName;
        this.previewUrl = builder.previewUrl;
        this.artworkUrl30 = builder.artworkUrl30;
        this.artworkUrl60 = builder.artworkUrl60;
        this.artworkUrl100 = builder.artworkUrl100;
        this.trackPrice = builder.trackPrice;
        this.releaseDate = builder.releaseDate;
        this.trackTimeMillis = builder.trackTimeMillis;
        this.duration = builder.duration;
        this.currency = builder.currency;
        this.primaryGenreName = builder.primaryGenreName;
    }

    @Override
    public String toString() {
        return "Search{" +
                "artistName='" + artistName + '\'' +
                ", collectionName='" + collectionName + '\'' +
                ", trackName='" + trackName + '\'' +
                ", previewUrl='" + previewUrl + '\'' +
                ", artworkUrl30='" + artworkUrl30 + '\'' +
                ", artworkUrl60='" + artworkUrl60 + '\'' +
                ", artworkUrl100='" + artworkUrl100 + '\'' +
                ", trackPrice=" + trackPrice +
                ", releaseDate='" + releaseDate + '\'' +
                ", trackTimeMillis=" + trackTimeMillis +
                ", currency='" + currency + '\'' +
                ", primaryGenreName='" + primaryGenreName + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public double getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(double trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(int trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public static class SearchBuilder {

        private String artistName;
        private String collectionName;
        private String trackName;
        private String previewUrl;
        private String artworkUrl30;
        private String artworkUrl60;
        private String artworkUrl100;
        private double trackPrice;
        private String releaseDate;
        private int trackTimeMillis;
        private String currency;
        private String primaryGenreName;
        private String duration;

        public SearchBuilder() {}

        public SearchBuilder(SearchResult searchResult) {
            this.artistName = searchResult.getArtistName();
            this.collectionName = searchResult.getCollectionName();
            this.trackName = searchResult.getTrackName();
            this.previewUrl = searchResult.getPreviewUrl();
            this.artworkUrl30 = searchResult.getArtworkUrl30();
            this.artworkUrl60 = searchResult.getArtworkUrl60();
            this.artworkUrl100 = searchResult.getArtworkUrl100();
            this.trackPrice = searchResult.getTrackPrice();
            this.releaseDate = searchResult.getReleaseDate();
            this.currency = searchResult.getCurrency();
            this.primaryGenreName = searchResult.getPrimaryGenreName();
        }

        public SearchBuilder setArtistName(String artistName) {
            this.artistName = artistName;
            return this;
        }

        public SearchBuilder setCollectionName(String collectionName) {
            this.collectionName = collectionName;
            return this;
        }

        public SearchBuilder setTrackName(String trackName) {
            this.trackName = trackName;
            return this;
        }

        public SearchBuilder setPreviewUrl(String previewUrl) {
            this.previewUrl = previewUrl;
            return this;
        }

        public SearchBuilder setArtworkUrl30(String artworkUrl30) {
            this.artworkUrl30 = artworkUrl30;
            return this;
        }

        public SearchBuilder setArtworkUrl60(String artworkUrl60) {
            this.artworkUrl60 = artworkUrl60;
            return this;
        }

        public SearchBuilder setArtworkUrl100(String artworkUrl100) {
            this.artworkUrl100 = artworkUrl100;
            return this;
        }

        public SearchBuilder setTrackPrice(double trackPrice) {
            this.trackPrice = trackPrice;
            return this;
        }

        public SearchBuilder setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public SearchBuilder setDuration(int millis) {
            this.duration = String.valueOf(millis / 1000) + " s.";
            return this;
        }

        public SearchBuilder setTrackTimeMillis(int trackTimeMillis) {
            this.trackTimeMillis = trackTimeMillis;
            return this;
        }

        public SearchBuilder setCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public SearchBuilder setPrimaryGenreName(String primaryGenreName) {
            this.primaryGenreName = primaryGenreName;
            return this;
        }

        public Search build() {
            return new Search(this);
        }
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.artistName);
        dest.writeString(this.collectionName);
        dest.writeString(this.trackName);
        dest.writeString(this.previewUrl);
        dest.writeString(this.artworkUrl30);
        dest.writeString(this.artworkUrl60);
        dest.writeString(this.artworkUrl100);
        dest.writeDouble(this.trackPrice);
        dest.writeString(this.releaseDate);
        dest.writeInt(this.trackTimeMillis);
        dest.writeString(this.currency);
        dest.writeString(this.primaryGenreName);
        dest.writeString(this.duration);
    }

    protected Search(Parcel in) {
        this.artistName = in.readString();
        this.collectionName = in.readString();
        this.trackName = in.readString();
        this.previewUrl = in.readString();
        this.artworkUrl30 = in.readString();
        this.artworkUrl60 = in.readString();
        this.artworkUrl100 = in.readString();
        this.trackPrice = in.readDouble();
        this.releaseDate = in.readString();
        this.trackTimeMillis = in.readInt();
        this.currency = in.readString();
        this.primaryGenreName = in.readString();
        this.duration = in.readString();
    }

    public static final Parcelable.Creator<Search> CREATOR = new Parcelable.Creator<Search>() {
        public Search createFromParcel(Parcel source) {return new Search(source);}

        public Search[] newArray(int size) {return new Search[size];}
    };
}
