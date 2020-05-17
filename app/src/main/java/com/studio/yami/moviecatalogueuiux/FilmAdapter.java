package com.studio.yami.moviecatalogueuiux;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmHolder> {

    private Context context;
    private List<Film> filmList;

    FilmAdapter(Context context, List<Film> filmList) {
        this.context = context;
        this.filmList = filmList;
    }

    @NonNull
    @Override
    public FilmHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_layout, viewGroup, false);
        return new FilmHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmHolder filmHolder, int i) {
        filmHolder.onBind(filmList.get(i));
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public class FilmHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Film film;
        ImageView poster;
        TextView title, rating, genre, date;

        FilmHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.iv_poster_list);
            title = itemView.findViewById(R.id.tv_title_list);
            rating = itemView.findViewById(R.id.tv_rating_list);
            genre = itemView.findViewById(R.id.tv_genre_list);
            date = itemView.findViewById(R.id.tv_date_list);
            itemView.setOnClickListener(this);
        }

        void onBind(Film film){
            String getRat = String.valueOf(film.getRating());
            String setRat = getRat + "%";

            this.film = film;
            poster.setImageResource(film.getPoster());
            title.setText(film.getTitle());
            rating.setText(setRat);
            genre.setText(film.getGenre());
            date.setText(film.getDate());
            rating.setTextColor(film.getColor());
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_DATA, film);
            context.startActivity(intent);
        }
    }
}
