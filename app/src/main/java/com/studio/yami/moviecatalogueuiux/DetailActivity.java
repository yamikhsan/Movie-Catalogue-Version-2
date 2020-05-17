package com.studio.yami.moviecatalogueuiux;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "EXTRA_DATA";
    ImageView poster;
    TextView title, date, genre, overview, status, rating, duration, language, actors, crew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        poster = findViewById(R.id.iv_poster);
        title = findViewById(R.id.tv_title);
        date = findViewById(R.id.tv_date);
        genre = findViewById(R.id.tv_genre);
        overview = findViewById(R.id.tv_about_parent);
        status = findViewById(R.id.tv_status_child);
        rating = findViewById(R.id.tv_rating_child);
        duration = findViewById(R.id.tv_duration_child);
        language = findViewById(R.id.tv_language_child);
        actors = findViewById(R.id.tv_actors_child);
        crew = findViewById(R.id.tv_crew_child);

        onBind();
    }

    private void onBind(){
        Film film = getIntent().getParcelableExtra(EXTRA_DATA);
        if(film != null){
            String getRat = String.valueOf(film.getRating());
            String setRat = getRat + "%";

            poster.setImageResource(film.getPoster());
            title.setText(film.getTitle());
            date.setText(film.getDate());
            genre.setText(film.getGenre());
            overview.setText(film.getOverview());
            status.setText(film.getStatus());
            rating.setText(setRat);
            duration.setText(film.getDuration());
            language.setText(film.getLanguage());
            actors.setText(film.getActors());
            crew.setText(film.getCrew());
            rating.setTextColor(film.getColor());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
