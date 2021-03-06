package com.studio.yami.moviecatalogueuiux;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    FilmAdapter adapter;
    RecyclerView rvMovie;
    List<Film> filmList;

    private TypedArray poster;
    private String[] title, date, genre, overview, status, duration, language, actors, crew;
    private int[] rating;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
        setData();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovie = view.findViewById(R.id.rv_movie);
        adapter = new FilmAdapter(getContext(), filmList);
        rvMovie.setAdapter(adapter);
        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void getData(){
        poster = getResources().obtainTypedArray(R.array.poster_movie);
        title = getResources().getStringArray(R.array.title_movie);
        date = getResources().getStringArray(R.array.date_movie);
        genre = getResources().getStringArray(R.array.genre_movie);
        overview = getResources().getStringArray(R.array.overview_movie);
        status = getResources().getStringArray(R.array.status_movie);
        duration = getResources().getStringArray(R.array.duration_movie);
        language = getResources().getStringArray(R.array.language_movie);
        actors = getResources().getStringArray(R.array.actors_movie);
        crew = getResources().getStringArray(R.array.crew_movie);
        rating = getResources().getIntArray(R.array.rating_movie);
    }

    private void setData(){
        filmList = new ArrayList<>();
        for (int i = 0; i< title.length; i++){
            filmList.add(new Film(
                    getContext(),
                    poster.getResourceId(i, -1),
                    title[i],
                    date[i],
                    genre[i],
                    overview[i],
                    status[i],
                    rating[i],
                    duration[i],
                    language[i],
                    actors[i],
                    crew[i]
            ));
        }
    }
}
