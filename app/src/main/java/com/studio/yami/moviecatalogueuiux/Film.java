package com.studio.yami.moviecatalogueuiux;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {

    private int poster;
    private String title;
    private String date;
    private String genre;
    private String overview;
    private String status;
    private int rating;
    private String duration;
    private String language;
    private String actors;
    private String crew;
    private int color;

    Film(Context context, int poster, String title, String date, String genre, String overview, String status, int rating, String duration, String language, String actors, String crew) {
        this.poster = poster;
        this.title = title;
        this.date = date;
        this.genre = genre;
        this.overview = overview;
        this.status = status;
        this.rating = rating;
        this.duration = duration;
        this.language = language;
        this.actors = actors;
        this.crew = crew;

        color = rating < 70? context.getResources().getColor(R.color.colorYellow): context.getResources().getColor(R.color.colorGreen);
    }

    int getPoster() {
        return poster;
    }

    String getTitle() {
        return title;
    }

    String getDate() {
        return date;
    }

    String getGenre() {
        return genre;
    }

    String getOverview() {
        return overview;
    }

    String getStatus() {
        return status;
    }

    int getRating() {
        return rating;
    }

    String getDuration() {
        return duration;
    }

    String getLanguage() {
        return language;
    }

    String getActors() {
        return actors;
    }

    String getCrew() {
        return crew;
    }

    int getColor() {
        return color;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.genre);
        dest.writeString(this.overview);
        dest.writeString(this.status);
        dest.writeInt(this.rating);
        dest.writeString(this.duration);
        dest.writeString(this.language);
        dest.writeString(this.actors);
        dest.writeString(this.crew);
        dest.writeInt(this.color);
    }

    private Film(Parcel in) {
        this.poster = in.readInt();
        this.title = in.readString();
        this.date = in.readString();
        this.genre = in.readString();
        this.overview = in.readString();
        this.status = in.readString();
        this.rating = in.readInt();
        this.duration = in.readString();
        this.language = in.readString();
        this.actors = in.readString();
        this.crew = in.readString();
        this.color = in.readInt();
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
